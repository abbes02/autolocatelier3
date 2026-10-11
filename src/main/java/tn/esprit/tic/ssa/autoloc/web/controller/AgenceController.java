package tn.esprit.tic.ssa.autoloc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Agence;
import tn.esprit.tic.ssa.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        Agence value = agenceService.retrieveAgence(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }

    @PostMapping
    public Agence add(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PostMapping("/batch")
    public List<Agence> addAll(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        setId(agence, id);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }

    private void setId(Agence agence, Long id) {
        agence.setIdAgence(id);
    }
}
