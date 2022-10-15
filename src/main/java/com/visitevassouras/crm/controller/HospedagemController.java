package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.dto.hospedagem.HospedagemCreatedRequest;
import com.visitevassouras.crm.dto.hospedagem.HospedagemResponse;
import com.visitevassouras.crm.dto.hospedagem.HospedagemUpdateRequest;
import com.visitevassouras.crm.service.HospedagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/hospedagens")
public class HospedagemController {
    private final HospedagemService service;

    public HospedagemController(HospedagemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HospedagemResponse>> getAll(){
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <HospedagemResponse> create(@RequestBody @Valid HospedagemCreatedRequest request) {
        var result = service.createHospedagem(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<HospedagemResponse> update(
            @PathVariable("id") Long id,
            @RequestBody @Valid HospedagemUpdateRequest updateRequest) {
        var hospedagem = service.updateHospedagem(id, updateRequest);
        return ResponseEntity.ok(hospedagem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HospedagemResponse> delete(@PathVariable("id") Long id) {
        var hospedagem = service.delete(id);
        return ResponseEntity.ok(hospedagem);
    }
}
