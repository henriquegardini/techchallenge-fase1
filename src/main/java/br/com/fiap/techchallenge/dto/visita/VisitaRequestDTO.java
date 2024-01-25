package br.com.fiap.techchallenge.dto.visita;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record VisitaRequestDTO(Integer apartamento,
                               String torre,
                               Integer andar,
                               LocalDate expiracao,
                               String documento) {

}
