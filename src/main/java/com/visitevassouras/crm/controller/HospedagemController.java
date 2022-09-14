package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.exceptions.ResourceNotFoundException;
import com.visitevassouras.crm.model.Hospedagem;
import com.visitevassouras.crm.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/hospedagem")
public class HospedagemController {

    @Autowired
    private HospedagemRepository hospedagemRepository; //adiciona instancia

    @GetMapping
    public List<Hospedagem> listar() {
        return hospedagemRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hospedagem adicionar(@RequestBody Hospedagem hospedagem) { // @RequestBody: o corpo da requisição json será convertido para o objeto java Atrativo
        return hospedagemRepository.save(hospedagem);
    }

    @PutMapping("{id}")
    public ResponseEntity<Hospedagem> updateHospedagem(@PathVariable long id, @RequestBody Hospedagem hospedagemDetails) {
        Hospedagem updateHospedagem = hospedagemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar esse Hotel/Pousada:" + id));

        updateHospedagem.setNomeHospedagem(hospedagemDetails.getNomeHospedagem());
        updateHospedagem.setImagemHospedagem(hospedagemDetails.getImagemHospedagem());
        updateHospedagem.setUrlHospedagem(hospedagemDetails.getUrlHospedagem());

        hospedagemRepository.save(updateHospedagem);

        return ResponseEntity.ok(updateHospedagem);
    }

}
