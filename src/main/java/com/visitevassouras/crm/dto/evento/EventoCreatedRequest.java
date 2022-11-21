package com.visitevassouras.crm.dto.evento;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EventoCreatedRequest {

    @NotEmpty(message = "Por favor, informe o título do evento.")
    private String titulo;

    @NotEmpty(message = "Por favor, informe o endereço do evento.")
    private String local;

    @NotEmpty(message = "Por favor, informe o dia de início do evento.")
    private String dataInicio;

    @NotEmpty(message = "Por favor, informe o dia do término do evento.")
    private String dataTermino;

    @NotEmpty(message = "Por favor, informe o horário do evento.")
    private String horario;

    @NotEmpty(message = "Por favor, informe o valor unitário do evento.")
    private String valor;

    @NotEmpty(message = "Por favor, informe o link para venda de ingresso do evento.")
    private String linkIngresso;

    private Boolean ativo;

}
