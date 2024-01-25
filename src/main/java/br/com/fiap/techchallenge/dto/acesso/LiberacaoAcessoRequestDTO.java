package br.com.fiap.techchallenge.dto.acesso;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public record LiberacaoAcessoRequestDTO(
        String documento,
        Integer apartamento,
        Integer andar,
        String torre
) {
}
