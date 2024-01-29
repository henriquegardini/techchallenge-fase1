package br.com.fiap.techchallenge.dto.acesso;

import java.time.LocalDate;

public record LiberacaoAcessoResponseDTO(
        String documento,
        String nome,
        LocalDate expiracao,
        Integer apartamento,
        Integer andar,
        String torre,
        String obs
) {
}
