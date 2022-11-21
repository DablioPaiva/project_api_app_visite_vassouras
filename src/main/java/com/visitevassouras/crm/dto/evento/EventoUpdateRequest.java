package com.visitevassouras.crm.dto.evento;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EventoUpdateRequest {

    @NotEmpty(message = "Por favor, informe o título do evento.")
    private String titulo;

    @NotEmpty(message = "Por favor, informe o endereço do evento.")
    private String endereco;

    @NotEmpty(message = "Por favor, informe o dia de início do evento.")
    private String dataInicio;

    @NotEmpty(message = "Por favor, informe o dia do término do evento.")
    private String dataTermino;

    @NotEmpty(message = "Por favor, informe o horário do evento.")
    private String horarioEvento;

    @NotEmpty(message = "Por favor, informe o valor unitário do evento.")
    private Float valor;

    @NotEmpty(message = "Por favor, informe o link para venda de ingresso do evento.")
    private String linkIngresso;

    private Boolean ativo;

}
