package br.edu.exemplo.biblioteca.dto;
import br.edu.exemplo.biblioteca.entity.Livro;
public class LivroResponseDTO {
private Long id;
private String titulo;
private String autor;
private Integer anoPublicacao;
private boolean disponivel;
public LivroResponseDTO(Livro livro) {
this.id = livro.getId();
this.titulo = livro.getTitulo();
this.autor = livro.getAutor();
this.anoPublicacao = livro.getAnoPublicacao();

this.disponivel = livro.isDisponivel();
}
public Long getId() {
return id;
}
public String getTitulo() {
return titulo;
}
public String getAutor() {
return autor;
}
public Integer getAnoPublicacao() {
return anoPublicacao;
}
public boolean isDisponivel() {
return disponivel;
}
}