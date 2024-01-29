package br.com.fiap.techchallenge.exception;

public enum KeyMessages {
    VISITANTE_NOT_FOUND("Visitante não encontrado."),
    VISITA_NOT_FOUND("Visita não encontrada."),
    DOCUMENT_REGISTERED_AS_MORADOR("Documento está registrado como morador."),
    DOCUMENT_IS_NULL("Documento não deve ser nulo."),
    DATE_MORADOR_EXPIRED("Data de acesso expirada. Favor atualizar cadastro com síndico."),
    DATE_VISITA_EXPIRED("Data de acesso expirada. Favor confirmar visita com morador."),
    DATE_VISITA_IN_THE_PAST("Data de expiração não pode ser menor que o dia atual."),
    VISITA_NOT_FOUND_FOR_VISITANTE("Nenhuma visita cadastrada para o visitante. Favor confirmar com morador e cadastrar visita."),
    VISITA_DATA_INCORRECT_FOR_VISITANTE("Dados incompatíveis de visita. Favor confirmar dados e revisar visita."),
    DOCUMENT_NOT_FOUND_AS_MORADOR_OR_VISITANTE("Documento não está cadastrado como morador ou visitante. Confirmar dados com o responsável."),
    DOCUMENT_ALREADY_REGISTERED("Documento já está registrado.");


    String value;

    KeyMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
