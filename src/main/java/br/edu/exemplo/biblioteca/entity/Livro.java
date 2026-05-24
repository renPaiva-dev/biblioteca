package br.edu.exemplo.biblioteca.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Livro {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String titulo;
private String autor;
private Integer anoPublicacao;
private boolean disponivel = true;
public Livro() {
}
public Livro(String titulo, String autor, Integer anoPublicacao) {
this.titulo = titulo;
this.autor = autor;
this.anoPublicacao = anoPublicacao;
this.disponivel = true;
}
public Long getId() {
return id;
}
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
public boolean isDisponivel() {
return disponivel;
}
public void emprestar() {
if (!disponivel) {
throw new IllegalStateException("Livro já está emprestado.");
}
this.disponivel = false;
}
public void devolver() {
if (disponivel) {
throw new IllegalStateException("Livro já está disponível.");
}
this.disponivel = true;
}
}