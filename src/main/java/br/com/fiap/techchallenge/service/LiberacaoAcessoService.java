package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoRequestDTO;
import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoResponseDTO;
import br.com.fiap.techchallenge.entities.Morador;
import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.exception.OutdatedException;
import br.com.fiap.techchallenge.repository.MoradorRepository;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import br.com.fiap.techchallenge.util.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class LiberacaoAcessoService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private VisitanteRepository visitanteRepository;

    private Formatter formatter = new Formatter();
    private boolean encontrado = false;
    private boolean liberado = false;
    private Visita visita;

    public LiberacaoAcessoResponseDTO liberar(LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {

        var morador = buscaMorador(liberacaoAcessoResquestDTO);
        if (morador.isPresent()) {
            if (morador.get().getAtualizacao().isBefore(LocalDate.now().minusYears(1))) {
                throw new OutdatedException(KeyMessages.DATE_MORADOR_EXPIRED.getValue());
            }
            return new LiberacaoAcessoResponseDTO(morador.get().getDocumento(),
                    morador.get().getNome(),
                    morador.get().getAtualizacao(),
                    morador.get().getApartamento(),
                    morador.get().getAndar(),
                    morador.get().getTorre());
        }

        Optional<Visitante> visitante = visitanteRepository.findByDocumento(liberacaoAcessoResquestDTO.documento());
        if (visitante.isPresent()) {
            if (buscaVisita(visitante, liberacaoAcessoResquestDTO)) {
                if (this.liberado) {
                    return new LiberacaoAcessoResponseDTO(visitante.get().getDocumento(),
                            visitante.get().getNome(),
                            this.visita.getExpiracao(),
                            this.visita.getApartamento(),
                            this.visita.getAndar(),
                            this.visita.getTorre());
                } else if (this.encontrado) {
                    throw new OutdatedException(KeyMessages.DATE_VISITA_EXPIRED.getValue());
                } else {
                    throw new NotFoundException((KeyMessages.PESSOA_NOT_FOUND.getValue()));
                }
            } else {
                throw new NotFoundException((KeyMessages.VISITA_NOT_FOUND.getValue()));
            }
        }
        return null;
    }

    private Optional<Morador> buscaMorador(LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {
        Optional<Morador> morador = moradorRepository.findByApartamento(
                formatter.formatarDocumento(liberacaoAcessoResquestDTO.documento()),
                liberacaoAcessoResquestDTO.apartamento(),
                liberacaoAcessoResquestDTO.andar(),
                liberacaoAcessoResquestDTO.torre());
        return morador;
    }

    private Boolean buscaVisita(Optional<Visitante> visitante, LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {
        Boolean achouVisita = false;
        List<Visita> visitas = visitante.get().getVisitas();
        if (!visitas.isEmpty()) {
            for (Visita v : visitas) {
                if (v.getApartamento().equals(liberacaoAcessoResquestDTO.apartamento()) &&
                        v.getAndar().equals(liberacaoAcessoResquestDTO.andar()) &&
                        v.getTorre().equals(liberacaoAcessoResquestDTO.torre())) {
                    this.encontrado = true;
                    achouVisita = true;
                    if (v.getExpiracao().isAfter(LocalDate.now().minusDays(7))) {
                        this.visita = v;
                        this.liberado = true;
                        achouVisita = true;
                    }
                }
            }
        } else {
            throw new NotFoundException((KeyMessages.VISITANTE_NOT_FOUND.getValue()));
        }
        return achouVisita;
    }

}
