package br.edu.exemplo.biblioteca.controller;

import br.edu.exemplo.biblioteca.dto.LivroRequestDTO;
import br.edu.exemplo.biblioteca.dto.LivroResponseDTO;
import br.edu.exemplo.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/livros")
public class LivroController {
private final LivroService livroService;
public LivroController(LivroService livroService) {
this.livroService = livroService;
}
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public LivroResponseDTO cadastrar(@RequestBody @Valid LivroRequestDTO dto) {
return livroService.cadastrar(dto);
}
@GetMapping
public List<LivroResponseDTO> listar() {
return livroService.listar();
}
@GetMapping("/{id}")
public LivroResponseDTO buscarPorId(@PathVariable Long id) {
return livroService.buscarPorId(id);
}
@PutMapping("/{id}/emprestar")
public LivroResponseDTO emprestar(@PathVariable Long id) {
return livroService.emprestar(id);
}
@PutMapping("/{id}/devolver")
public LivroResponseDTO devolver(@PathVariable Long id) {
return livroService.devolver(id);
}
@PutMapping("/{id}")
public LivroResponseDTO atualizar(@PathVariable Long id,
  @RequestBody @Valid LivroRequestDTO dto) {
    return livroService.atualizar(id, dto);
}
}

