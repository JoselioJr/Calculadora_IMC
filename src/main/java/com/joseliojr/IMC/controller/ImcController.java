package com.joseliojr.IMC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joseliojr.IMC.dto.ImcResponseDTO;
import com.joseliojr.IMC.service.ImcService;

@RestController
@RequestMapping("/imc")
public class ImcController {
    @Autowired
    private ImcService imcService;

    @GetMapping
    public ImcResponseDTO getImc(@RequestParam double peso, @RequestParam double altura) {
        return imcService.calcularEClassificarImc(peso, altura);
    }

    @GetMapping("/classificacao")
    public ImcResponseDTO getClassificacao(@RequestParam double peso, @RequestParam double altura) {
        return imcService.calcularEClassificarImc(peso, altura);
    }
}
