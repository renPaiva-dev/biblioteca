package br.edu.exemplo.biblioteca.repository;
import br.edu.exemplo.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroRepository extends JpaRepository<Livro, Long> {
}