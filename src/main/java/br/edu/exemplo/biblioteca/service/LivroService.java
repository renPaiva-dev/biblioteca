package br.edu.exemplo.biblioteca.service;
import br.edu.exemplo.biblioteca.dto.LivroRequestDTO;
import br.edu.exemplo.biblioteca.dto.LivroResponseDTO;
import br.edu.exemplo.biblioteca.entity.Livro;
import br.edu.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LivroService {
private final LivroRepository livroRepository;
public LivroService(LivroRepository livroRepository) {
this.livroRepository = livroRepository;

}
public LivroResponseDTO cadastrar(LivroRequestDTO dto) {
Livro livro = new Livro(
dto.getTitulo(),
dto.getAutor(),
dto.getAnoPublicacao()
);
Livro livroSalvo = livroRepository.save(livro);
return new LivroResponseDTO(livroSalvo);
}
public List<LivroResponseDTO> listar() {
return livroRepository.findAll()
.stream()
.map(LivroResponseDTO::new)
.toList();
}
public LivroResponseDTO buscarPorId(Long id) {
Livro livro = buscarLivroOuFalhar(id);
return new LivroResponseDTO(livro);
}
public LivroResponseDTO emprestar(Long id) {
Livro livro = buscarLivroOuFalhar(id);
livro.emprestar();
Livro livroAtualizado = livroRepository.save(livro);
return new LivroResponseDTO(livroAtualizado);
}
public LivroResponseDTO devolver(Long id) {
Livro livro = buscarLivroOuFalhar(id);
livro.devolver();
Livro livroAtualizado = livroRepository.save(livro);
return new LivroResponseDTO(livroAtualizado);
}
private Livro buscarLivroOuFalhar(Long id) {
return livroRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Livro não encontrado."));
}
public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
    Livro livro = buscarLivroOuFalhar(id);

    livro.setTitulo(dto.getTitulo());
    livro.setAutor(dto.getAutor());
    livro.setAnoPublicacao(dto.getAnoPublicacao());

    Livro livroAtualizado = livroRepository.save(livro);
    return new LivroResponseDTO(livroAtualizado);
}
}