package br.com.fiap.techchallenge.dto;

import java.util.UUID;

public record VisitanteDTO(
        UUID id,
        String nome,
        String documento,
        String telefone
) {
}
