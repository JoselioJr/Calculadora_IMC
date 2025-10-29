package com.joseliojr.IMC.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImcResponseDTO {
    private double imc;
    private String classificacao;
    private String faixaOMS;
}