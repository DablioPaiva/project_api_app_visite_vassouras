package com.visitevassouras.crm.dto.hospedagem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class HospedagemResponse {
    private Long id;
    private String nomeHospedagem;
    private String imagemHospedagem;
    private String urlHospedagem;
}
