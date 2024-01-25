package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoResponseDTO;
import br.com.fiap.techchallenge.entities.Morador;
import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.ConflictException;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.exception.OutdatedException;
import br.com.fiap.techchallenge.repository.MoradorRepository;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import br.com.fiap.techchallenge.util.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class LiberacaoAcessoService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private VisitanteRepository visitanteRepository;

    private Formatter formatter = new Formatter();

    public LiberacaoAcessoResponseDTO liberar(String documento) {
        documento = formatter.formatarDocumento(documento);
        Optional<Morador> morador = moradorRepository.findByDocumento(documento);
        boolean liberado = false;

        if (morador.isPresent()) {
            if(morador.get().getAtualizacao().isBefore(LocalDate.now().minusYears(1))){
                throw new OutdatedException(KeyMessages.DATE_MORADOR_EXPIRED.getValue());
            }
            return new LiberacaoAcessoResponseDTO(morador.get().getDocumento(), morador.get().getNome(), morador.get().getAtualizacao(), morador.get().getApartamento(), morador.get().getTorre());
        } else{
            Optional<Visitante> visitante = visitanteRepository.findByDocumento(documento);
            if(visitante.isPresent()){
                List<Visita> visitas = visitante.get().getVisitas();
                List<Visita> visitasValidas = new ArrayList<>();
                if(visitas.isEmpty()){
                    throw new NotFoundException(KeyMessages.VISITA_NOT_FOUND_FOR_VISITANTE.getValue());
                }
                for(Visita v : visitas){
                    if(v.getExpiracao().isAfter(LocalDate.now().minusDays(7))){
                       visitasValidas.add(v);
                        liberado = true;
                    }
                }
                if(liberado){
                    Visita visitaComMaiorDataExpirar = visitasValidas.stream()
                            .max(Comparator.comparing(Visita::getExpiracao))
                            .orElse(null);
                    return new LiberacaoAcessoResponseDTO(visitante.get().getDocumento(), visitante.get().getNome(), visitaComMaiorDataExpirar.getExpiracao(), visitaComMaiorDataExpirar.getApartamento(),visitaComMaiorDataExpirar.getTorre());
                }
                else{
                    throw new OutdatedException(KeyMessages.DATE_VISITA_EXPIRED.getValue());
                }
            }else{
                throw new NotFoundException((KeyMessages.DOCUMENT_NOT_FOUND_AS_MORADOR_OR_VISITANTE.getValue()));
            }
        }
    }
}
