package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.dto.atrativo.AtrativoCreatedRequest;
import com.visitevassouras.crm.dto.atrativo.AtrativoResponse;
import com.visitevassouras.crm.dto.atrativo.AtrativoUpdateRequest;
import com.visitevassouras.crm.service.AtrativoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/atrativos")
public class AtrativoController {
    private final AtrativoService service;

    public AtrativoController(AtrativoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AtrativoResponse>> getAll(){
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/atrativos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <AtrativoResponse> create(@RequestBody @Valid AtrativoCreatedRequest request) {
        var result = service.createAtrativo(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/atrativos/{id}")
    public ResponseEntity<AtrativoResponse> update(
            @PathVariable("id") Long id,
            @RequestBody @Valid AtrativoUpdateRequest updateRequest) {
        var atrativo = service.updateAtrativo(id, updateRequest);
        return ResponseEntity.ok(atrativo);
    }

    @DeleteMapping("/atrativos/{id}")
    public ResponseEntity<AtrativoResponse> delete(@PathVariable("id") Long id) {
        var atrativo = service.delete(id);
        return ResponseEntity.ok(atrativo);
    }
}
