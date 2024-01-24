package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateDTO;
import br.com.fiap.techchallenge.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public ResponseEntity<List<VisitanteResponseDTO>> findAll() {
        final List<VisitanteResponseDTO> visitanteResponseDTO = visitanteService.findAll();
        return ResponseEntity.ok(visitanteResponseDTO);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<VisitanteResponseDTO> findByDocumento(@PathVariable String documento) {
        final VisitanteResponseDTO visitanteResponseDTO = visitanteService.findByDocumento(documento);
        return ResponseEntity.ok(visitanteResponseDTO);
    }

    @PostMapping
    public ResponseEntity<VisitanteResponseDTO> save(@RequestBody VisitanteRequestDTO visitanteRequestDTO) {
        VisitanteResponseDTO visitanteDto = visitanteService.save(visitanteRequestDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(visitanteDto);
    }

    @PutMapping("/{documento}")
    public ResponseEntity<VisitanteResponseDTO> updateByDocumento(@PathVariable String documento,
                                                                  @RequestBody VisitanteUpdateDTO visitanteUpdateDTO) {
        final VisitanteResponseDTO visitanteResponseDTO = visitanteService.updateByDocumento(documento, visitanteUpdateDTO);
        return ResponseEntity.ok(visitanteResponseDTO);
    }

    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> deleteByDocumento(@PathVariable String documento) {
        visitanteService.deleteByDocumento(documento);
        return ResponseEntity.noContent().build();
    }

}