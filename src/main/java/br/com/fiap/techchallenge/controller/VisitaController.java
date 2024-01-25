package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaUpdateDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.service.VisitaService;
import br.com.fiap.techchallenge.util.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @Autowired
    private Formatter formatter;

    @GetMapping
    public ResponseEntity<List<VisitaResponseDTO>> findAll() {
        final List<VisitaResponseDTO> visitaResponseDTO = visitaService.findAll();
        return ResponseEntity.ok(visitaResponseDTO);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<List<VisitaResponseDTO>> findByDocumento(@PathVariable String documento) {
        documento = formatter.formatarDocumento(documento);
        final List<VisitaResponseDTO> visitaResponseDTO = visitaService.findByDocumento(documento);
        return ResponseEntity.ok(visitaResponseDTO);
    }

    @PostMapping
    public ResponseEntity<VisitaResponseDTO> save(@RequestBody VisitaRequestDTO visitaRequestDTO) {
        VisitaResponseDTO visitaDto = visitaService.save(visitaRequestDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(visitaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitaResponseDTO> updateByDocumento(@PathVariable Long id,
                                                               @RequestBody VisitaUpdateDTO visitaUpdateDTO) {
        final VisitaResponseDTO visitaResponseDTO = visitaService.updateByDocumento(id, visitaUpdateDTO);
        return ResponseEntity.ok(visitaResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        visitaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}