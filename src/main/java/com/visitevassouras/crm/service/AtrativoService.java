package com.visitevassouras.crm.service;


import com.visitevassouras.crm.entity.Atrativo;
import com.visitevassouras.crm.dto.atrativo.AtrativoCreatedRequest;
import com.visitevassouras.crm.dto.atrativo.AtrativoResponse;
import com.visitevassouras.crm.dto.atrativo.AtrativoUpdateRequest;
import com.visitevassouras.crm.exception.ResourceNotFoundException;
import com.visitevassouras.crm.repository.AtrativoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtrativoService {
    private final AtrativoRepository repository;

    public AtrativoService(AtrativoRepository repository) {
        this.repository = repository;
    }

    public List<AtrativoResponse> listAll() {
        var result = repository.findAll();

        return result.stream().map(atrativo -> new AtrativoResponse(
                atrativo.getId(),
                atrativo.getNome(),
                atrativo.getEndereco(),
                atrativo.getDescricao(),
                atrativo.getDiasFuncionamento(),
                atrativo.getHorarioFuncionamento(),
                atrativo.getRota(),
                atrativo.getImgPrincipal(),
                atrativo.getImgSecundaria(),
                atrativo.getAtivo()
        )).collect(Collectors.toList());
    }

    public AtrativoResponse createAtrativo(AtrativoCreatedRequest request) {
        var newAtrativo = new Atrativo();
        newAtrativo.setNome(request.getNome());
        newAtrativo.setEndereco(request.getEndereco());
        newAtrativo.setDescricao(request.getDescricao());
        newAtrativo.setRota(request.getRota());
        newAtrativo.setHorarioFuncionamento(request.getHorarioFuncionamento());
        newAtrativo.setDiasFuncionamento(request.getDiasFuncionamento());
        newAtrativo.setImgPrincipal(request.getImgPrincipal());
        newAtrativo.setImgSecundaria(request.getImgSecundaria());
        newAtrativo.setAtivo(request.getAtivo());

        var saveAtrativo = repository.save(newAtrativo);

        return new AtrativoResponse(
                saveAtrativo.getId(),
                saveAtrativo.getNome(),
                saveAtrativo.getEndereco(),
                saveAtrativo.getDescricao(),
                saveAtrativo.getDiasFuncionamento(),
                saveAtrativo.getHorarioFuncionamento(),
                saveAtrativo.getRota(),
                saveAtrativo.getImgPrincipal(),
                saveAtrativo.getImgSecundaria(),
                saveAtrativo.getAtivo()
        );
    }

    public AtrativoResponse updateAtrativo(Long id, AtrativoUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var atrativo = result.get();
        atrativo.setNome(request.getNome());
        atrativo.setEndereco(request.getEndereco());
        atrativo.setDescricao(request.getDescricao());
        atrativo.setRota(request.getRota());
        atrativo.setHorarioFuncionamento(request.getHorarioFuncionamento());
        atrativo.setDiasFuncionamento(request.getDiasFuncionamento());
        atrativo.setImgPrincipal(request.getImgPrincipal());
        atrativo.setImgSecundaria(request.getImgSecundaria());
        atrativo.setAtivo(request.getAtivo());

        var saveAtrativo = repository.save(atrativo);
        return new AtrativoResponse(
                saveAtrativo.getId(),
                saveAtrativo.getNome(),
                saveAtrativo.getEndereco(),
                saveAtrativo.getDescricao(),
                saveAtrativo.getDiasFuncionamento(),
                saveAtrativo.getHorarioFuncionamento(),
                saveAtrativo.getRota(),
                saveAtrativo.getImgPrincipal(),
                saveAtrativo.getImgSecundaria(),
                saveAtrativo.getAtivo()
        );
    }

    public AtrativoResponse delete(Long id) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        Atrativo atrativo = result.get();
        repository.delete(atrativo);

        return new AtrativoResponse(
                atrativo.getId(),
                atrativo.getNome(),
                atrativo.getEndereco(),
                atrativo.getDescricao(),
                atrativo.getDiasFuncionamento(),
                atrativo.getHorarioFuncionamento(),
                atrativo.getRota(),
                atrativo.getImgPrincipal(),
                atrativo.getImgSecundaria(),
                atrativo.getAtivo()
        );
    }
}
