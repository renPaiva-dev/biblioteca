package br.edu.exemplo.biblioteca.dto;

import br.edu.exemplo.biblioteca.entity.Aluno;

public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String matricula;
    private String turma;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
        this.turma = aluno.getTurma();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getTurma() { return turma; }
}