package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.VisitanteDTO;
import br.com.fiap.techchallenge.dto.VisitanteForm;
import br.com.fiap.techchallenge.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public ResponseEntity<Collection<VisitanteDTO>> findAll() {
        var visitanteDTO = visitanteService.findAll();
        return ResponseEntity.ok(visitanteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitanteDTO> findById(@PathVariable UUID id) {
        var visitanteDTO = visitanteService.findById(id);
        return ResponseEntity.ok(visitanteDTO);
    }

    @PostMapping
    public ResponseEntity<VisitanteDTO> save(@RequestBody VisitanteForm visitanteForm) {
        VisitanteDTO visitanteDto = visitanteService.save(visitanteForm);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(visitanteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitanteDTO> updateById(@PathVariable UUID id, @RequestBody VisitanteDTO visitanteDTO) {
        visitanteDTO = visitanteService.updateById(id, visitanteDTO);
        return ResponseEntity.ok(visitanteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        visitanteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
