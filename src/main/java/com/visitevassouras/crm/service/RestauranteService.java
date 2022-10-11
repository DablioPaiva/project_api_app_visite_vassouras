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
                restaurante.getNomeRestaurante(),
                restaurante.getLogoRestaurante(),
                restaurante.getUrlRestaurante()
        )).collect(Collectors.toList());
    }
    public RestauranteResponse createRestaurante(RestauranteCreatedRequest request) {
        var newRestaurante = new Restaurantes();
        newRestaurante.setNomeRestaurante(request.getNomeRestaurante());
        newRestaurante.setLogoRestaurante(request.getLogoRestaurante());
        newRestaurante.setUrlRestaurante(request.getUrlRestaurante());

        var saveRestaurante = repository.save(newRestaurante);

        return new RestauranteResponse(
                saveRestaurante.getId(),
                saveRestaurante.getNomeRestaurante(),
                saveRestaurante.getLogoRestaurante(),
                saveRestaurante.getUrlRestaurante()
        );
    }

    public RestauranteResponse updateRestaurante(Long id, RestauranteUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var restaurante = result.get();
        restaurante.setNomeRestaurante(request.getNomeRestaurante());
        restaurante.setLogoRestaurante(request.getLogoRestaurante());
        restaurante.setUrlRestaurante(request.getUrlRestaurante());
        var saveRestaurante = repository.save(restaurante);

        return new RestauranteResponse(
                saveRestaurante.getId(),
                saveRestaurante.getNomeRestaurante(),
                saveRestaurante.getLogoRestaurante(),
                saveRestaurante.getUrlRestaurante()
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
                restaurante.getNomeRestaurante(),
                restaurante.getLogoRestaurante(),
                restaurante.getUrlRestaurante()
        );
    }
}
