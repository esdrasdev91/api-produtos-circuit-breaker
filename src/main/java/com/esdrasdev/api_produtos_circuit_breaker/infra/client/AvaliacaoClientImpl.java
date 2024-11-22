package com.esdrasdev.api_produtos_circuit_breaker.infra.client;

import com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes.AvaliacaoClient;
import com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes.AvaliacaoModel;

import java.util.List;

public class AvaliacaoClientImpl implements AvaliacaoClient {


    @Override
    public List<AvaliacaoModel> buscarTodosPorProduto(Long productId) {
        return List.of();
    }


}
