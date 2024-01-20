package br.com.fiap.techchallenge.dto;

public record VisitanteDTO(
        Long id,
        String nome,
        String documento,
        String telefone
) {
}
