package br.com.fiap.techchallenge.dto.visitante;

import java.util.List;

public record VisitanteResponseDTO(String documento,
                                   String nome,
                                   String telefone,
                                   List<br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO> visitas){

}
