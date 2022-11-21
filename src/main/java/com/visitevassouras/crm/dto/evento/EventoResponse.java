package com.visitevassouras.crm.dto.evento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventoResponse {

    private Long id;
    private String titulo;
    private String endereco;
    private String dataInicio;
    private String dataTermino;
    private String horarioEvento;
    private String valor;
    private String linkIngresso;
    private Boolean ativo;

}
