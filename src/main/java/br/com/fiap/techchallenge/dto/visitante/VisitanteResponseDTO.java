package br.com.fiap.techchallenge.dto.visitante;

import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;

import java.util.List;

public record VisitanteResponseDTO (Long id,
                                   String nome,
                                   String documento,
                                   String telefone,
                                   List<VisitaResponseDTO> visitas){

}
