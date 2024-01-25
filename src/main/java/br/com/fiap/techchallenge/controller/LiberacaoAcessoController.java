package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoResponseDTO;
import br.com.fiap.techchallenge.service.LiberacaoAcessoService;
import br.com.fiap.techchallenge.service.VisitanteService;
import br.com.fiap.techchallenge.util.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/liberar")
public class LiberacaoAcessoController {
    private VisitanteService visitanteService;

    @Autowired
    private LiberacaoAcessoService liberacaoAcessoService;

    @PostMapping("/{documento}")
    public ResponseEntity<LiberacaoAcessoResponseDTO> solicitarAcesso(@PathVariable String documento) {
        LiberacaoAcessoResponseDTO liberacaoDTO = liberacaoAcessoService.liberar(documento);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(liberacaoDTO);
    }
}
