package br.edu.exemplo.biblioteca.service;

import br.edu.exemplo.biblioteca.dto.AlunoRequestDTO;
import br.edu.exemplo.biblioteca.dto.AlunoResponseDTO;
import br.edu.exemplo.biblioteca.entity.Aluno;
import br.edu.exemplo.biblioteca.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponseDTO cadastrar(AlunoRequestDTO dto) {
        Aluno aluno = new Aluno(dto.getNome(), dto.getMatricula(), dto.getTurma());
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return new AlunoResponseDTO(alunoSalvo);
    }

    public List<AlunoResponseDTO> listar() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoResponseDTO::new)
                .toList();
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
        return new AlunoResponseDTO(aluno);
    }
}