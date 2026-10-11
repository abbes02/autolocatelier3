package tn.esprit.tic.ssa.autoloc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Contrat;
import tn.esprit.tic.ssa.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable Long id) {
        Contrat value = contratService.retrieveContrat(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }

    @PostMapping
    public Contrat add(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PostMapping("/batch")
    public List<Contrat> addAll(@RequestBody List<Contrat> contrats) {
        return contratService.addContrats(contrats);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        if (contratService.retrieveContrat(id) == null) {
            return ResponseEntity.notFound().build();
        }
        setId(contrat, id);
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (contratService.retrieveContrat(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contratService.removeContrat(id);
        return ResponseEntity.noContent().build();
    }

    private void setId(Contrat contrat, Long id) {
        contrat.setIdContrat(id);
    }
}
