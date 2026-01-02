package com.henrique.api.controller;


import com.henrique.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        var paciente = this.repository.save(new Paciente(dados));

        DadosDetalhamentoPaciente dto = new DadosDetalhamentoPaciente(paciente);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(Pageable paginacao) {
        var page = this.repository.findAll(paginacao).map(DadosListagemPaciente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados, @PathVariable Long id) {
        var paciente = this.repository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var paciente = this.repository.getReferenceById(id);
        paciente.deletar();
    }
}
