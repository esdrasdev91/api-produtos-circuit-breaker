package com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AvaliacaoClient {

    List<AvaliacaoModel> buscarTodosPorProduto(Long productId);
}