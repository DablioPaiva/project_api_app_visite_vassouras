package com.visitevassouras.crm.service;

import com.visitevassouras.crm.entity.Hospedagem;
import com.visitevassouras.crm.dto.hospedagem.HospedagemCreatedRequest;
import com.visitevassouras.crm.dto.hospedagem.HospedagemUpdateRequest;
import com.visitevassouras.crm.dto.hospedagem.HospedagemResponse;
import com.visitevassouras.crm.exception.ResourceNotFoundException;
import com.visitevassouras.crm.repository.HospedagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospedagemService {
    private final HospedagemRepository repository;

    public HospedagemService(HospedagemRepository repository) {
        this.repository = repository;
    }

    public List<HospedagemResponse> listAll() {
        var result = repository.findAll();

        return result.stream().map(hospedagem -> new HospedagemResponse(
                hospedagem.getId(),
                hospedagem.getNome(),
                hospedagem.getUrl(),
                hospedagem.getImagem()
        )).collect(Collectors.toList());
    }
    public HospedagemResponse createHospedagem(HospedagemCreatedRequest request) {
        var newHospedagem = new Hospedagem();
        newHospedagem.setNome(request.getNome());
        newHospedagem.setImagem(request.getImagem());
        newHospedagem.setUrl(request.getUrl());
        var saveHospedagem = repository.save(newHospedagem);

        return new HospedagemResponse(
                saveHospedagem.getId(),
                saveHospedagem.getNome(),
                saveHospedagem.getImagem(),
                saveHospedagem.getUrl()
        );
    }

    public HospedagemResponse updateHospedagem(Long id, HospedagemUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var hospedagem = result.get();
        hospedagem.setNome(request.getNome());
        hospedagem.setUrl(request.getUrl());
        hospedagem.setImagem(request.getImagem());

        var saveHospedagem = repository.save(hospedagem);

        return new HospedagemResponse(
                saveHospedagem.getId(),
                saveHospedagem.getNome(),
                saveHospedagem.getImagem(),
                saveHospedagem.getUrl()
        );
    }

    public HospedagemResponse delete(Long id) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        Hospedagem hospedagem = result.get();
        repository.delete(hospedagem);

        return new HospedagemResponse(
                hospedagem.getId(),
                hospedagem.getNome(),
                hospedagem.getImagem(),
                hospedagem.getUrl()
        );
    }

}
