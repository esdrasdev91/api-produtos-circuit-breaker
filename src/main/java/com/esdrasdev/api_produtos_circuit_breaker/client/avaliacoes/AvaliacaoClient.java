package com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@FeignClient(name = "avaliacaoClient", url = "http://localhost:8090")
public interface AvaliacaoClient {

    List<AvaliacaoModel> buscarTodosPorProduto(Long productId);
}