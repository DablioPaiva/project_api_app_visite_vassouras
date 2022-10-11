package com.visitevassouras.crm.service;

import com.visitevassouras.crm.entity.Evento;
import com.visitevassouras.crm.dto.evento.EventoCreatedRequest;
import com.visitevassouras.crm.dto.evento.EventoResponse;
import com.visitevassouras.crm.dto.evento.EventoUpdateRequest;
import com.visitevassouras.crm.exception.ResourceNotFoundException;
import com.visitevassouras.crm.repository.EventoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EventoService {
    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public List<EventoResponse> listAll() {
        var result = repository.findAll();

        return result.stream().map(evento -> new EventoResponse(
                evento.getId(),
                evento.getTituloEvento(),
                evento.getEnderecoEvento(),
                evento.getDescricaoEvento(),
                evento.getDiasInicio(),
                evento.getDiasTermino(),
                evento.getLinkIngresso(),
                evento.getValor(),
                evento.getHorarioEvento()
        )).collect(Collectors.toList());
    }

    public EventoResponse createEvento(EventoCreatedRequest request) {
        var newEvento = new Evento();
        newEvento.setTituloEvento(request.getTituloEvento());
        newEvento.setEnderecoEvento(request.getEnderecoEvento());
        newEvento.setDescricaoEvento(request.getDescricaoEvento());
        newEvento.setDiasInicio(request.getDiasInicio());
        newEvento.setDiasTermino(request.getDiasTermino());
        newEvento.setValor(request.getValor());
        newEvento.setLinkIngresso(request.getLinkIngresso());

        var saveEvento = repository.save(newEvento);

        return new EventoResponse(
                saveEvento.getId(),
                saveEvento.getTituloEvento(),
                saveEvento.getEnderecoEvento(),
                saveEvento.getDescricaoEvento(),
                saveEvento.getDiasInicio(),
                saveEvento.getDiasTermino(),
                saveEvento.getHorarioEvento(),
                saveEvento.getValor(),
                saveEvento.getLinkIngresso()
        );
    }

    public EventoResponse updateEvento(Long id, EventoUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var evento = result.get();
        evento.setTituloEvento(request.getTituloEvento());
        evento.setEnderecoEvento(request.getEnderecoEvento());
        evento.setDescricaoEvento(request.getDescricaoEvento());
        evento.setValor(request.getValor());
        evento.setDiasInicio(request.getDiasInicio());
        evento.setDiasTermino(request.getDiasTermino());
        evento.setHorarioEvento(request.getHorarioEvento());
        evento.setLinkIngresso(request.getLinkIngresso());

        var saveEvento = repository.save(evento);
        return new EventoResponse(
                saveEvento.getId(),
                saveEvento.getTituloEvento(),
                saveEvento.getEnderecoEvento(),
                saveEvento.getDescricaoEvento(),
                saveEvento.getDiasInicio(),
                saveEvento.getDiasTermino(),
                saveEvento.getTituloEvento(),
                saveEvento.getValor(),
                saveEvento.getHorarioEvento()
        );
    }

    public EventoResponse delete(Long id) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        Evento evento = result.get();
        repository.delete(evento);

        return new EventoResponse(
                evento.getId(),
                evento.getTituloEvento(),
                evento.getEnderecoEvento(),
                evento.getDescricaoEvento(),
                evento.getDiasInicio(),
                evento.getDiasTermino(),
                evento.getTituloEvento(),
                evento.getValor(),
                evento.getHorarioEvento()
        );
    }
}
