package br.com.fiap.techchallenge.dto.acesso;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public record LiberacaoAcessoRequestDTO(
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido")
        String documento,
        Integer apartamento,
        Integer andar,
        String torre
) {
}
