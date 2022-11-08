package com.visitevassouras.crm.dto.evento;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EventoResponse {

    private Long id;
    private String titulo;
    private String endereco;
    private String descricao;
    private String diasInicio;
    private String diasTermino;
    private String horarioEvento;
    private Float valor;
    private String linkIngresso;

}
