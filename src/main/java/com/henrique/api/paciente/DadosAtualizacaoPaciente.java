package com.henrique.api.paciente;

import com.henrique.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
    String nome,
    String telefone,
    DadosEndereco endereco
    ) {
}
