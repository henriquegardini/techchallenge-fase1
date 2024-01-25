package br.com.fiap.techchallenge.dto.acesso;

import java.time.LocalDate;
import javax.validation.constraints.Pattern;

public record LiberacaoAcessoResponseDTO(@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido")String documento,
                                         String nome,
                                         LocalDate expiracao,
                                         Integer apartamento,
                                         String torre){
}
