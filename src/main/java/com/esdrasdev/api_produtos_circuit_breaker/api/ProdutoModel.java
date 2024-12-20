package com.esdrasdev.api_produtos_circuit_breaker.api;

import com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes.AvaliacaoModel;
import com.esdrasdev.api_produtos_circuit_breaker.domain.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ProdutoModel {

    public Long id;
    public String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<AvaliacaoModel> avaliacoes;

    public ProdutoModel() {

    }

    public ProdutoModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ProdutoModel(Long id, String nome, List<AvaliacaoModel> avaliacoes) {
        this.id = id;
        this.nome = nome;
        this.avaliacoes = avaliacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AvaliacaoModel> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public static ProdutoModel of(Produto produto) {
        return new ProdutoModel(
                produto.getId(),
                produto.getNome()
        );
    }

    public static ProdutoModel of(Produto produto, List<AvaliacaoModel> avaliacoes) {
        return new ProdutoModel(
                produto.getId(),
                produto.getNome(),
                avaliacoes
        );
    }

}
