package com.visitevassouras.crm.service;

import com.visitevassouras.crm.entity.Restaurantes;
import com.visitevassouras.crm.dto.restaurantes.RestauranteResponse;
import com.visitevassouras.crm.dto.restaurantes.RestauranteCreatedRequest;
import com.visitevassouras.crm.dto.restaurantes.RestauranteUpdateRequest;
import com.visitevassouras.crm.exception.ResourceNotFoundException;
import com.visitevassouras.crm.repository.RestaurantesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {
    private final RestaurantesRepository repository;

    public RestauranteService(RestaurantesRepository repository) {
        this.repository = repository;
    }

    public List<RestauranteResponse> listAll() {
        var result = repository.findAll();

        return result.stream().map(restaurante -> new RestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getLogo(),
                restaurante.getUrl(),
                restaurante.getAtivo()
        )).collect(Collectors.toList());
    }
    public RestauranteResponse createRestaurante(RestauranteCreatedRequest request) {
        var newRestaurante = new Restaurantes();
        newRestaurante.setNome(request.getNome());
        newRestaurante.setLogo(request.getLogo());
        newRestaurante.setUrl(request.getUrl());
        newRestaurante.setAtivo(request.getAtivo());

        var saveRestaurante = repository.save(newRestaurante);

        return new RestauranteResponse(
                saveRestaurante.getId(),
                saveRestaurante.getNome(),
                saveRestaurante.getLogo(),
                saveRestaurante.getUrl(),
                saveRestaurante.getAtivo()
        );
    }

    public RestauranteResponse updateRestaurante(Long id, RestauranteUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var restaurante = result.get();
        restaurante.setNome(request.getNome());
        restaurante.setLogo(request.getLogo());
        restaurante.setUrl(request.getUrl());
        var saveRestaurante = repository.save(restaurante);

        return new RestauranteResponse(
                saveRestaurante.getId(),
                saveRestaurante.getNome(),
                saveRestaurante.getLogo(),
                saveRestaurante.getUrl(),
                saveRestaurante.getAtivo()
        );
    }

    public RestauranteResponse delete(Long id) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        Restaurantes restaurante = result.get();
        repository.delete(restaurante);

        return new RestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getLogo(),
                restaurante.getUrl(),
                restaurante.getAtivo()
        );
    }
}
