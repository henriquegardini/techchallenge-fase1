package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.service.VisitanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LiberacaoAcesso {
    /*private VisitanteService visitanteService;
    private MoradorService moradorService;

    @PostMapping
    public ResponseEntity<LiberacaoAcessoDTO> solicitarAcesso(@RequestParam String documento) {

        var morador = moradorService.findByDocumento(documento);
        if (morador.isPresent()) {
            return new ResponseEntity<LiberacaoAcessoDTO>().ok;
        } else {

            try {
                var visitante = visitanteService.findByDocumento(documento);
                if (!visitante.visitas().isEmpty()) {
                    for (VisitaResponseDTO v : visitante.visitas()) {
                        if (v.expiracao().range())
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);

            }
        }*/
    }
