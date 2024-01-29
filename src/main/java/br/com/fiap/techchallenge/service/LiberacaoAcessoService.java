package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoRequestDTO;
import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoResponseDTO;
import br.com.fiap.techchallenge.entities.Morador;
import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.exception.OutdatedException;
import br.com.fiap.techchallenge.mappers.liberacaoAcesso.LiberacaoAcesso;
import br.com.fiap.techchallenge.repository.MoradorRepository;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LiberacaoAcessoService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private VisitanteRepository visitanteRepository;

    private Visita visita;

    public LiberacaoAcessoResponseDTO liberar(LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {

        Optional<Morador> morador = buscaMorador(liberacaoAcessoResquestDTO);
        if (morador.isPresent()) {
            if (verificaMoradorDesatualizado(morador.get())) {
              return LiberacaoAcesso.toMoradorResponseDTO(morador.get(),KeyMessages.DATE_MORADOR_EXPIRED.getValue());
            }
            return moradorResponseDTO(morador.get());
        }
        else {
            Optional<Visitante> visitante = visitanteRepository.findByDocumento(liberacaoAcessoResquestDTO.documento());
            if (visitante.isPresent()) {
                visita = buscaVisita(visitante.get(), liberacaoAcessoResquestDTO);
                if (Objects.nonNull(visita)) {
                    if (verificaValidadeDaVisita(visita)) {
                         return visitanteResponseDTO(visitante.get());
                    }
                    else {
                        throw new OutdatedException(KeyMessages.DATE_VISITA_EXPIRED.getValue());
                    }
                } else {
                    throw new NotFoundException((KeyMessages.VISITA_NOT_FOUND_FOR_VISITANTE.getValue()));
                }
            } else {
                throw new NotFoundException(KeyMessages.DOCUMENT_NOT_FOUND_AS_MORADOR_OR_VISITANTE.getValue());
            }
        }
    }

    private Visita buscaVisita(Visitante visitante, LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {
        List<Visita> visitas = visitante.getVisitas();
        if (!visitas.isEmpty()) {
            for (Visita v : visitas) {
                if (v.getApartamento().equals(liberacaoAcessoResquestDTO.apartamento()) && v.getAndar().equals(liberacaoAcessoResquestDTO.andar()) && v.getTorre().equals(liberacaoAcessoResquestDTO.torre())) {
                    return v;
                }
            }
            throw new NotFoundException((KeyMessages.VISITA_DATA_INCORRECT_FOR_VISITANTE.getValue()));
        }
        return null;
    }
    private static boolean verificaMoradorDesatualizado(Morador morador) {
        return morador.getAtualizacao().isBefore(LocalDate.now().minusYears(1));
    }

    private static boolean verificaValidadeDaVisita(Visita v) {
        return v.getExpiracao().isAfter(LocalDate.now().minusDays(7));
    }

    private Optional<Morador> buscaMorador(LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {
        Optional<Morador> morador = moradorRepository.findByDocumento(liberacaoAcessoResquestDTO.documento());
        return morador;
    }

    private LiberacaoAcessoResponseDTO moradorResponseDTO(Morador morador) {
        return new LiberacaoAcessoResponseDTO(morador.getDocumento(), morador.getNome(), morador.getAtualizacao(), morador.getApartamento(), morador.getAndar(), morador.getTorre(), "");
    }

    private LiberacaoAcessoResponseDTO visitanteResponseDTO(Visitante visitante) {
        return new LiberacaoAcessoResponseDTO(visitante.getDocumento(), visitante.getNome(), visita.getExpiracao(), visita.getApartamento(), visita.getAndar(), visita.getTorre(), "");
    }

}
