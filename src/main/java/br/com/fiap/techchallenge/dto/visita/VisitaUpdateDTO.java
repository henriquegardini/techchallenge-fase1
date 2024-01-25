package br.com.fiap.techchallenge.dto.visita;

import java.time.LocalDate;

public record VisitaUpdateDTO(
        Integer apartamento,
        Integer andar,
        String torre,
        LocalDate expiracao
) {
}
