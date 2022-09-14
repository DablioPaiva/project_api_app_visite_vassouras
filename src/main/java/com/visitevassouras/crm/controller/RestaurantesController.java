package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.exceptions.ResourceNotFoundException;
import com.visitevassouras.crm.model.Restaurantes;
import com.visitevassouras.crm.repository.RestaurantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/restaurantes")
public class RestaurantesController {

    @Autowired
    private RestaurantesRepository restaurantesRepository; //adiciona instancia

    @GetMapping
    public List<Restaurantes> listar() {
        return restaurantesRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurantes adicionar(@RequestBody Restaurantes restaurantes) { // @RequestBody: o corpo da requisição json será convertido para o objeto java Atrativo
        return restaurantesRepository.save(restaurantes);
    }

    @PutMapping("{id}")
    public ResponseEntity<Restaurantes> updateRestaurantes(@PathVariable long id, @RequestBody Restaurantes restaurantesDetails) {
        Restaurantes updateRestaurantes = restaurantesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar esse Restaurante:" + id));

        updateRestaurantes.setNomeRestaurante(restaurantesDetails.getNomeRestaurante());
        updateRestaurantes.setLogoRestaurante(restaurantesDetails.getLogoRestaurante());
        updateRestaurantes.setUrlRestaurante(restaurantesDetails.getUrlRestaurante());

        restaurantesRepository.save(updateRestaurantes);

        return ResponseEntity.ok(updateRestaurantes);
    }

}
