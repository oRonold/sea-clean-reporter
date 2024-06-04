package br.com.fiap.inovacao.azul.api.domain.ong.dto;

import br.com.fiap.inovacao.azul.api.domain.ong.Ong;

public record ListagemOngDTO(Long id, String name, String description, String email, String telefone) {

    public ListagemOngDTO(Ong ong){
        this(ong.getId(), ong.getNome(), ong.getDescricao(), ong.getEmail(), ong.getTelefone());
    }
}
