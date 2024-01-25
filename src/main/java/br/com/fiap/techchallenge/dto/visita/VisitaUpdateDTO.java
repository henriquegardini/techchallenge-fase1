package br.com.fiap.techchallenge.dto.visita;

import java.time.LocalDate;

public record VisitaUpdateDTO(
        LocalDate expiracao
) {
}
