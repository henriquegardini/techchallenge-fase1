package br.com.fiap.techchallenge.dto.visita;


import java.time.LocalDate;

public record VisitaRequestDTO(
        Integer apartamento,
        String torre,
        Integer andar,
        LocalDate expiracao,
        String documento
) {
}
