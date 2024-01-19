package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entities.Visita;

import java.util.List;
import java.util.UUID;

public record VisitanteDTO(
        Long id,
        String nome,
        String documento,
        String telefone
) {
}
