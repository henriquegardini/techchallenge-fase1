package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoRequestDTO;
import br.com.fiap.techchallenge.dto.acesso.LiberacaoAcessoResponseDTO;
import br.com.fiap.techchallenge.service.LiberacaoAcessoService;
import br.com.fiap.techchallenge.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/liberar")
public class LiberacaoAcessoController {
    private VisitanteService visitanteService;

    @Autowired
    private LiberacaoAcessoService liberacaoAcessoService;

    @PostMapping
    public ResponseEntity<LiberacaoAcessoResponseDTO> solicitarAcesso(@RequestBody LiberacaoAcessoRequestDTO liberacaoAcessoResquestDTO) {
        LiberacaoAcessoResponseDTO liberacaoDTO = liberacaoAcessoService.liberar(liberacaoAcessoResquestDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(liberacaoDTO);
    }
}
