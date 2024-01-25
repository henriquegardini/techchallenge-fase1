package br.com.fiap.techchallenge.dto.visitante;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;

import java.util.List;

public record VisitanteRequestDTO(
        String documento,
        String nome,
        String telefone,
        List<VisitaRequestDTO> visitas
) {
}
