package br.com.fiap.techchallenge.dto.visita;

import java.time.LocalDate;

public record VisitaUpdateDTO(Integer apartamento,
                              String torre,
                              Integer andar,
                              LocalDate expiracao) {

}
