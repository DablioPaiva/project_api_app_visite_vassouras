package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.dto.evento.EventoCreatedRequest;
import com.visitevassouras.crm.dto.evento.EventoResponse;
import com.visitevassouras.crm.dto.evento.EventoUpdateRequest;
import com.visitevassouras.crm.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EventoResponse>> getAll(){
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <EventoResponse> create(@RequestBody @Valid EventoCreatedRequest request) {
        var result = service.createEvento(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<EventoResponse> update(
            @PathVariable("id") Long id,
            @RequestBody @Valid EventoUpdateRequest updateRequest) {
        var evento = service.updateEvento(id, updateRequest);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EventoResponse> delete(@PathVariable("id") Long id) {
        var evento = service.delete(id);
        return ResponseEntity.ok(evento);
    }

}
