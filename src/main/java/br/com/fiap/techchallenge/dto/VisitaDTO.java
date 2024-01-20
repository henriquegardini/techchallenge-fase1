package br.com.fiap.techchallenge.dto;

import java.time.LocalDate;

public record VisitaDTO(Integer apartamento,
                        String torre,
                        LocalDate expiracao) {

}
