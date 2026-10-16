package tn.esprit.tic.ssa.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Agence;
import tn.esprit.tic.ssa.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@Tag(name = "Agences")
public class AgenceController {

    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    @Operation(summary = "Recuperer toutes les agences")
    @ApiResponse(responseCode = "200", description = "Liste des agences recuperee")
    public ResponseEntity<List<Agence>> getAll() {
        return ResponseEntity.ok(agenceService.retrieveAllAgences());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recuperer une agence par son identifiant")
    @ApiResponse(responseCode = "200", description = "Agence trouvee")
    @ApiResponse(responseCode = "404", description = "Agence introuvable")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        Agence agence = agenceService.retrieveAgence(id);
        return agence == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(agence);
    }

    @PostMapping
    @Operation(summary = "Ajouter une agence")
    @ApiResponse(responseCode = "201", description = "Agence creee")
    public ResponseEntity<Agence> add(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.addAgence(agence));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une agence")
    @ApiResponse(responseCode = "200", description = "Agence modifiee")
    @ApiResponse(responseCode = "404", description = "Agence introuvable")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une agence")
    @ApiResponse(responseCode = "204", description = "Agence supprimee")
    @ApiResponse(responseCode = "404", description = "Agence introuvable")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}
