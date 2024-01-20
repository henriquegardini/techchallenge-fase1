package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.VisitanteRequestDTO;
import br.com.fiap.techchallenge.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public ResponseEntity<Collection<VisitanteRequestDTO>> findAll() {
        var visitanteDTO = visitanteService.findAll();
        return ResponseEntity.ok(visitanteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitanteRequestDTO> findById(@PathVariable Long id) {
        var visitanteDTO = visitanteService.findById(id);
        return ResponseEntity.ok(visitanteDTO);
    }

    @PostMapping
    public ResponseEntity<VisitanteRequestDTO> save(@RequestBody VisitanteRequestDTO visitanteRequestDTO) {
        VisitanteRequestDTO visitanteDto = visitanteService.save(visitanteRequestDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(visitanteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitanteRequestDTO> updateById(@PathVariable Long id, @RequestBody VisitanteRequestDTO visitanteRequestDTO) {
        visitanteRequestDTO = visitanteService.updateById(id, visitanteRequestDTO);
        return ResponseEntity.ok(visitanteRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        visitanteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
