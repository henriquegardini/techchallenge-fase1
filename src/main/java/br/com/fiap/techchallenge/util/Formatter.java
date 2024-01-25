package br.com.fiap.techchallenge.util;

import org.springframework.stereotype.Service;

@Service
public class Formatter {
    public Formatter() {
    }

    public String formatarDocumento(String documento) {
        // Remover caracteres não numéricos do documento
        String cpfLimpo = documento.replaceAll("\\D", "");

        // Aplicar a máscara do CPF
        String cpfFormatado = cpfLimpo.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        return cpfFormatado;
    }
    public  String formatarTelefone(String numeroTelefone) {
        // Remover caracteres não numéricos do número de telefone
        String numeroLimpo = numeroTelefone.replaceAll("\\D", "");

        // Aplicar a máscara do número de telefone
        String telefoneFormatado = numeroLimpo.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1)$2-$3");

        return telefoneFormatado;
    }
}
