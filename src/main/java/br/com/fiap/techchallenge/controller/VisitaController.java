package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaUpdateDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    /*@Autowired
    private VisitaService visitaService;

    @GetMapping
    public ResponseEntity<List<VisitaResponseDTO>> findAll() {
        final List<VisitaResponseDTO> visitaResponseDTO = visitaService.findAll();
        return ResponseEntity.ok(visitaResponseDTO);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<VisitaResponseDTO> findByDocumento(@PathVariable String documento) {
        final VisitaResponseDTO visitaResponseDTO = visitaService.findByDocumento(documento);
        return ResponseEntity.ok(visitaResponseDTO);
    }

    @PostMapping
    public ResponseEntity<VisitanteResponseDTO> save(@RequestBody VisitanteRequestDTO visitanteRequestDTO) {
        VisitanteResponseDTO visitaDto = visitaService.save(visitanteRequestDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(visitaDto);
    }

    @PutMapping("/{documento}")
    public ResponseEntity<VisitanteResponseDTO> updateByDocumento(@PathVariable String documento,
                                                                  @RequestBody VisitaUpdateDTO visitaUpdateDTO) {
        final VisitanteResponseDTO visitanteResponseDTO = visitaService.updateByDocumento(documento, visitaUpdateDTO);
        return ResponseEntity.ok(visitanteResponseDTO);
    }

    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> deleteByDocumento(@PathVariable String documento) {
        visitaService.deleteByDocumento(documento);
        return ResponseEntity.noContent().build();
    }*/

}