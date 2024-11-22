package com.esdrasdev.api_produtos_circuit_breaker.infra.client;

import com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes.AvaliacaoClient;
import com.esdrasdev.api_produtos_circuit_breaker.client.avaliacoes.AvaliacaoModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Component
public class AvaliacaoClientImpl implements AvaliacaoClient {

    private final Logger logger = LoggerFactory.getLogger(AvaliacaoClientImpl.class);
    private final RestTemplate restTemplate;

    private final static String API_URL = UriComponentsBuilder
            .fromHttpUrl("http://localhost:8090/avaliacoes")
            .queryParam("produtoId", "{produtoId}")
            .encode()
            .toUriString();

    public AvaliacaoClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @CircuitBreaker(name = "avaliacaoCB", fallbackMethod = "buscarTodosProdutosNoCache")
    public List<AvaliacaoModel> buscarTodosPorProduto(Long produtoId) {
        final List<AvaliacaoModel> avaliacoes = executarRequisicao(produtoId);
        return avaliacoes;
    }

    private final Map<Long, List<AvaliacaoModel>> CACHE = new HashMap<>();

    private List<AvaliacaoModel> executarRequisicao(Long produtoId) {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("produtoId", produtoId);

        logger.info("Buscando avaliações");
        final AvaliacaoModel[] avaliacoes;

        try {
            avaliacoes = restTemplate.getForObject(API_URL, AvaliacaoModel[].class, parametros);
        } catch (Exception e) {
            logger.error("Erro ao buscar avaliações");
            throw e;
        }

        logger.info("Alimentando o cache");
        CACHE.put(produtoId, Arrays.asList(avaliacoes));

        return Arrays.asList(avaliacoes);
    }

    private List<AvaliacaoModel> buscarTodosProdutosNoCache(Long produtoId, Throwable e) {
        logger.info("Buscando no Cache");
        return CACHE.getOrDefault(produtoId, new ArrayList<>());
    }

}
