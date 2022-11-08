package com.visitevassouras.crm.dto.evento;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EventoCreatedRequest {

    @NotEmpty(message = "Por favor, informe o título do evento.")
    private String titulo;

    @NotEmpty(message = "Por favor, informe o endereço do evento.")
    private String endereco;

    @NotEmpty(message = "Por favor, informe uma descrição para o evento.")
    private String descricao;

    @NotEmpty(message = "Por favor, informe o dia de início do evento.")
    private String diasInicio;

    @NotEmpty(message = "Por favor, informe o dia do término do evento.")
    private String diasTermino;

    @NotEmpty(message = "Por favor, informe o horário do evento.")
    private String horarioEvento;

    @NotEmpty(message = "Por favor, informe o valor unitário do evento.")
    private Float valor;

    @NotEmpty(message = "Por favor, informe o link para venda de ingresso do evento.")
    private String linkIngresso;

}
