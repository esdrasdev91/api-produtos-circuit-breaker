package com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes;

import java.util.List;

public interface AvaliacaoClient {

    List<AvaliacaoModel> buscarTodosPorProduto(Long productId);
}