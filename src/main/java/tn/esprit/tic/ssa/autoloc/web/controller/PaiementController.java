package tn.esprit.tic.ssa.autoloc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Paiement;
import tn.esprit.tic.ssa.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getById(@PathVariable Long id) {
        Paiement value = paiementService.retrievePaiement(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }

    @PostMapping
    public Paiement add(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PostMapping("/batch")
    public List<Paiement> addAll(@RequestBody List<Paiement> paiements) {
        return paiementService.addPaiements(paiements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement paiement) {
        if (paiementService.retrievePaiement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        setId(paiement, id);
        return ResponseEntity.ok(paiementService.updatePaiement(paiement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (paiementService.retrievePaiement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiementService.removePaiement(id);
        return ResponseEntity.noContent().build();
    }

    private void setId(Paiement paiement, Long id) {
        paiement.setIdPaiement(id);
    }
}
