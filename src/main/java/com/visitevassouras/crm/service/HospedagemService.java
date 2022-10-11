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
                hospedagem.getNomeHospedagem(),
                hospedagem.getUrlHospedagem(),
                hospedagem.getImagemHospedagem()
        )).collect(Collectors.toList());
    }
    public HospedagemResponse createHospedagem(HospedagemCreatedRequest request) {
        var newHospedagem = new Hospedagem();
        newHospedagem.setNomeHospedagem(request.getNomeHospedagem());
        newHospedagem.setImagemHospedagem(request.getImagemHospedagem());
        newHospedagem.setUrlHospedagem(request.getUrlHospedagem());
        var saveHospedagem = repository.save(newHospedagem);

        return new HospedagemResponse(
                saveHospedagem.getId(),
                saveHospedagem.getNomeHospedagem(),
                saveHospedagem.getImagemHospedagem(),
                saveHospedagem.getUrlHospedagem()
        );
    }

    public HospedagemResponse updateHospedagem(Long id, HospedagemUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var hospedagem = result.get();
        hospedagem.setNomeHospedagem(request.getNomeHospedagem());
        hospedagem.setUrlHospedagem(request.getUrlHospedagem());
        hospedagem.setImagemHospedagem(request.getImagemHospedagem());

        var saveHospedagem = repository.save(hospedagem);

        return new HospedagemResponse(
                saveHospedagem.getId(),
                saveHospedagem.getNomeHospedagem(),
                saveHospedagem.getImagemHospedagem(),
                saveHospedagem.getUrlHospedagem()
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
                hospedagem.getNomeHospedagem(),
                hospedagem.getImagemHospedagem(),
                hospedagem.getUrlHospedagem()
        );
    }

}
