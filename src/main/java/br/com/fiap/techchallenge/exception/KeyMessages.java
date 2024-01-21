package br.com.fiap.techchallenge.exception;

public enum KeyMessages {
    VISITANTE_NOT_FOUND("Visitante não encontrado."),
    DOCUMENT_ALREADY_REGISTERED("Documento já está registrado.");

    String value;

    KeyMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
