package com.henrique.api.medico;

import com.henrique.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        String nome,
        String telefone,
        DadosEndereco endereco
    ) {
}
