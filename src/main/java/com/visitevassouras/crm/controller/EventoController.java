package com.visitevassouras.crm.controller;

import com.visitevassouras.crm.dto.evento.EventoCreatedRequest;
import com.visitevassouras.crm.dto.evento.EventoResponse;
import com.visitevassouras.crm.dto.evento.EventoUpdateRequest;
import com.visitevassouras.crm.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository; //adiciona instancia

    @GetMapping
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento adicionar(@RequestBody Evento evento) { // @RequestBody: o corpo da requisição json será convertido para o objeto java Atrativo
        return eventoRepository.save(evento);
    }

    @PutMapping("{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable long id, @RequestBody Evento eventoDetails) {
        Evento updateEvento = eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar esse Evento:" + id));

        updateEvento.setTituloEvento(eventoDetails.getTituloEvento());
        updateEvento.setEnderecoEvento(eventoDetails.getEnderecoEvento());
        updateEvento.setDescricaoEvento(eventoDetails.getDescricaoEvento());
        updateEvento.setDiasInicio(eventoDetails.getDiasInicio());
        updateEvento.setDiasTermino(eventoDetails.getDiasTermino());
        updateEvento.setHorarioEvento(eventoDetails.getHorarioEvento());
        updateEvento.setValor(eventoDetails.getValor());
        updateEvento.setLinkIngresso(eventoDetails.getLinkIngresso());

        eventoRepository.save(updateEvento);

        return ResponseEntity.ok(updateEvento);
    }


}
