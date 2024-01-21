package br.com.fiap.techchallenge.dto.visitante;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;

import java.util.List;

public record VisitanteRequestDTO(Long id,
                                  String nome,
                                  String documento,
                                  String telefone,
                                  List<VisitaRequestDTO> visitas) {


}
