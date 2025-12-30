package com.henrique.api.controller;


import com.henrique.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    public MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        this.repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return this.repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping("{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados, @PathVariable Long id) {
        var medico = this.repository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var medico = this.repository.getReferenceById(id);
        medico.deletar();

    }
}
