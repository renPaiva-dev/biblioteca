package br.edu.exemplo.biblioteca.repository;

import br.edu.exemplo.biblioteca.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}