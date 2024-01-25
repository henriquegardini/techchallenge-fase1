package br.com.fiap.techchallenge.dto.visita;

import java.time.LocalDate;

public record VisitaResponseDTO(
        Long id,
        Integer apartamento,
        Integer andar,
        String torre,
        LocalDate inclusao,
        LocalDate expiracao,
        String nome
) {
}
