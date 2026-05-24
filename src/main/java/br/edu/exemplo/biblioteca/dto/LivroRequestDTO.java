package br.edu.exemplo.biblioteca.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class LivroRequestDTO {
@NotBlank(message = "O título é obrigatório.")
private String titulo;
@NotBlank(message = "O autor é obrigatório.")
private String autor;
@NotNull(message = "O ano de publicação é obrigatório.")
@Min(value = 1000, message = "O ano de publicação deve ser válido.")
private Integer anoPublicacao;
public String getTitulo() {
return titulo;
}
public void setTitulo(String titulo) {
this.titulo = titulo;
}
public String getAutor() {
return autor;
}
public void setAutor(String autor) {
this.autor = autor;
}
public Integer getAnoPublicacao() {
return anoPublicacao;
}
public void setAnoPublicacao(Integer anoPublicacao) {
this.anoPublicacao = anoPublicacao;
}
}