package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.exceptions.ResourceNotFoundException;
import com.visitevassouras.crm.model.Atrativo;
import com.visitevassouras.crm.repository.AtrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/atrativos")
public class AtrativoController {

    @Autowired
    private AtrativoRepository atrativoRepository; //adiciona instancia

    @GetMapping
    public List<Atrativo> listar() {
        return atrativoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atrativo adicionar(@RequestBody Atrativo atrativo) { // @RequestBody: o corpo da requisição json será convertido para o objeto java Atrativo
        return atrativoRepository.save(atrativo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Atrativo> updateAtrativo(@PathVariable long id, @RequestBody Atrativo atrativoDetails) {
        Atrativo updateAtrativo = atrativoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar esse Atrativo:" + id));

        updateAtrativo.setNomeAtrativo(atrativoDetails.getNomeAtrativo());
        updateAtrativo.setEnderecoAtrativo(atrativoDetails.getEnderecoAtrativo());
        updateAtrativo.setDescricaoAtrativo(atrativoDetails.getDescricaoAtrativo());
        updateAtrativo.setDiasFuncionamento(atrativoDetails.getDiasFuncionamento());
        updateAtrativo.setHorarioFuncionamento(atrativoDetails.getHorarioFuncionamento());
        updateAtrativo.setRota(atrativoDetails.getRota());
        updateAtrativo.setImgPrincipal(atrativoDetails.getImgPrincipal());
        updateAtrativo.setImgSecundaria(atrativoDetails.getImgSecundaria());

        atrativoRepository.save(updateAtrativo);

        return ResponseEntity.ok(updateAtrativo);
    }

}
