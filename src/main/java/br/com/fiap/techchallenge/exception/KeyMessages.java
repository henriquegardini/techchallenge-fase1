package br.com.fiap.techchallenge.exception;

public enum KeyMessages {
    VISITANTE_NOT_FOUND("Visitante não encontrado."),
    VISITA_NOT_FOUND("Visita não encontrada."),
    DOCUMENT_REGISTERED_AS_MORADOR("Documento está registrado como morador."),
    DATE_MORADOR_EXPIRED("Data de acesso expirada. Favor atualizar com síndico"),
    DATE_VISITA_EXPIRED("Data de acesso expirada. Favor confirmar visita com morador"),
    VISITA_NOT_FOUND_FOR_VISITANTE("Nenhuma visita cadastrada para o visitante. Favor confirmar com morador e cadastrar visita."),
    PESSOA_NOT_FOUND("Pessoal não está cadastrado. Solicite o cadastramento como morador ou visitante."),
    DOCUMENT_ALREADY_REGISTERED("Documento já está registrado.");


    String value;

    KeyMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
