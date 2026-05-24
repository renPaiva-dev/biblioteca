package br.edu.exemplo.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String matricula;
    private String turma;

    public Aluno() {}

    public Aluno(String nome, String matricula, String turma) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
}