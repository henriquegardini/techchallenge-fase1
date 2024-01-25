package br.com.fiap.techchallenge.mappers.liberacaoAcesso;

import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoResponseDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.entities.Morador;
import br.com.fiap.techchallenge.entities.Visita;

import java.time.LocalDate;

public interface LiberacaoAcesso {
    static LiberacaoAcessoResponseDTO toMoradorResponseDTO(final Morador morador, String obs) {
        return new LiberacaoAcessoResponseDTO(
                morador.getDocumento(),
                morador.getNome(),
                morador.getAtualizacao(),
                morador.getApartamento(),
                morador.getAndar(),
                morador.getTorre(),
                obs
        );
    }
}
