package br.edu.exemplo.biblioteca.exception;

public class ErroResponse {
private String mensagem;
public ErroResponse(String mensagem) {
this.mensagem = mensagem;
}
public String getMensagem() {
return mensagem;
}
}
