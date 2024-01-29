package br.com.fiap.techchallenge.dto.acesso;

public record LiberacaoAcessoRequestDTO(
        String documento,
        Integer apartamento,
        Integer andar,
        String torre
) {
}
