package br.com.fiap.techchallenge.dto;

import java.time.LocalDate;

public record VisitaDTO(Integer numeroApartamento,
                        String nomeTorre,
                        LocalDate dataExpiracao) {

}
