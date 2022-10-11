package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.dto.restaurantes.RestauranteCreatedRequest;
import com.visitevassouras.crm.dto.restaurantes.RestauranteResponse;
import com.visitevassouras.crm.dto.restaurantes.RestauranteUpdateRequest;
import com.visitevassouras.crm.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/restaurantes")
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RestauranteResponse>> getAll(){
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }
    @PostMapping("/restaurantes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <RestauranteResponse> create(@RequestBody @Valid RestauranteCreatedRequest request) {
        var result = service.createRestaurante(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/restaurantes/{id}")
    public ResponseEntity<RestauranteResponse> update(
            @PathVariable("id") Long id,
            @RequestBody @Valid RestauranteUpdateRequest updateRequest) {
        var restaurante = service.updateRestaurante(id, updateRequest);
        return ResponseEntity.ok(restaurante);
    }

    @DeleteMapping("/restaurantes/{id}")
    public ResponseEntity<RestauranteResponse> delete(@PathVariable("id") Long id) {
        var restaurante = service.delete(id);
        return ResponseEntity.ok(restaurante);
    }

}
