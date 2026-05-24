package br.edu.exemplo.biblioteca.controller;

import br.edu.exemplo.biblioteca.dto.AlunoRequestDTO;
import br.edu.exemplo.biblioteca.dto.AlunoResponseDTO;
import br.edu.exemplo.biblioteca.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponseDTO cadastrar(@RequestBody @Valid AlunoRequestDTO dto) {
        return alunoService.cadastrar(dto);
    }

    @GetMapping
    public List<AlunoResponseDTO> listar() {
        return alunoService.listar();
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }
}