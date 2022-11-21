package com.visitevassouras.crm.dto.evento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventoResponse {

    private Long id;
    private String titulo;
    private String local;
    private String dataInicio;
    private String dataTermino;
    private String horario;
    private String valor;
    private String linkIngresso;
    private Boolean ativo;

}
