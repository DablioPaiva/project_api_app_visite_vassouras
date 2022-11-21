package com.visitevassouras.crm.service;

import com.visitevassouras.crm.entity.Evento;
import com.visitevassouras.crm.dto.evento.EventoCreatedRequest;
import com.visitevassouras.crm.dto.evento.EventoResponse;
import com.visitevassouras.crm.dto.evento.EventoUpdateRequest;
import com.visitevassouras.crm.exception.ResourceNotFoundException;
import com.visitevassouras.crm.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {
    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public List<EventoResponse> listAll() {
        var result = repository.findAll();

        return result.stream().map(evento -> new EventoResponse(
                evento.getId(),
                evento.getTitulo(),
                evento.getLocal(),
                evento.getDataInicio(),
                evento.getDataTermino(),
                evento.getHorario(),
                evento.getValor(),
                evento.getLinkIngresso(),
                evento.getAtivo()
        )).collect(Collectors.toList());
    }

    public EventoResponse createEvento(EventoCreatedRequest request) {
        var newEvento = new Evento();
        newEvento.setTitulo(request.getTitulo());
        newEvento.setLocal(request.getLocal());
        newEvento.setDataInicio(request.getDataInicio());
        newEvento.setDataTermino(request.getDataTermino());
        newEvento.setValor(request.getValor());
        newEvento.setLinkIngresso(request.getLinkIngresso());
        newEvento.setAtivo(request.getAtivo());

        var saveEvento = repository.save(newEvento);

        return new EventoResponse(
                saveEvento.getId(),
                saveEvento.getTitulo(),
                saveEvento.getLocal(),
                saveEvento.getDataInicio(),
                saveEvento.getDataTermino(),
                saveEvento.getHorario(),
                saveEvento.getValor(),
                saveEvento.getLinkIngresso(),
                saveEvento.getAtivo()
        );
    }

    public EventoResponse updateEvento(Long id, EventoUpdateRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var evento = result.get();
        evento.setTitulo(request.getTitulo());
        evento.setLocal(request.getLocal());
        evento.setDataInicio(request.getDataInicio());
        evento.setDataTermino(request.getDataTermino());
        evento.setHorario(request.getHorario());
        evento.setValor(request.getValor());
        evento.setLinkIngresso(request.getLinkIngresso());
        evento.setAtivo(request.getAtivo());

        var saveEvento = repository.save(evento);
        return new EventoResponse(
                saveEvento.getId(),
                saveEvento.getTitulo(),
                saveEvento.getLocal(),
                saveEvento.getDataInicio(),
                saveEvento.getDataTermino(),
                saveEvento.getHorario(),
                saveEvento.getValor(),
                saveEvento.getLinkIngresso(),
                saveEvento.getAtivo()
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
                evento.getTitulo(),
                evento.getLocal(),
                evento.getDataInicio(),
                evento.getDataTermino(),
                evento.getLinkIngresso(),
                evento.getValor(),
                evento.getHorario(),
                evento.getAtivo()
        );
    }
}
