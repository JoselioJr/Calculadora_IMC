package com.joseliojr.IMC.service;

import org.springframework.stereotype.Service;

import com.joseliojr.IMC.dto.ImcResponseDTO;
import com.joseliojr.IMC.exception.DivisionByZeroLikeException;
import com.joseliojr.IMC.exception.InvalidHeightException;
import com.joseliojr.IMC.exception.InvalidWeightException;

@Service
public class ImcService {
    private static final double MIN_HEIGHT = 0.5;
    private static final double MAX_HEIGHT = 2.5;
    private static final double MIN_WEIGHT = 2.0;
    private static final double MAX_WEIGHT = 400.0;

    public ImcResponseDTO calcularEClassificarImc(double peso, double altura) {
        validarParametros(peso, altura);

        double imc = calcularImc(peso, altura);

        String classificacao = classificarImc(imc);

        String faixa = "Faixa de peso normal (18.5 a 24.9)";

        return new ImcResponseDTO(imc, classificacao, faixa);
    }

    private void validarParametros(double peso, double altura) {
        if (peso <= 0.0 || peso < MIN_WEIGHT || peso > MAX_WEIGHT) {
            throw new InvalidWeightException(
                String.format("Peso inválido. O peso deve estar entre %.1f e %.1f kg.", MIN_WEIGHT, MAX_WEIGHT)
            );
        }
        
        if (altura <= 0.0) {
             throw new DivisionByZeroLikeException(
                "Altura não pode ser zero ou negativa, pois causaria divisão por zero."
            );
        }

        if (altura < MIN_HEIGHT || altura > MAX_HEIGHT) {
            throw new InvalidHeightException(
                String.format("Altura inválida. A altura deve estar entre %.2f e %.2f metros.", MIN_HEIGHT, MAX_HEIGHT)
            );
        }
    }

    private double calcularImc(double peso, double altura) {
        return peso / (altura * altura);
    }
    
    private String classificarImc(double imc) {
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc < 24.9) {
            return "Normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else if (imc < 39.9) {
            return "Obesidade";
        } else {
            return "Obesidade Grave";
        }
    }
}
