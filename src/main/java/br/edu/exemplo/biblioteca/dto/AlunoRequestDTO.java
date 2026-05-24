package br.edu.exemplo.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;

public class AlunoRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "A matrícula é obrigatória.")
    private String matricula;

    @NotBlank(message = "A turma é obrigatória.")
    private String turma;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
}