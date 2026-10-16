package tn.esprit.tic.ssa.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Vehicule;
import tn.esprit.tic.ssa.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@Tag(name = "Vehicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    @Operation(summary = "Recuperer tous les vehicules")
    @ApiResponse(responseCode = "200", description = "Liste des vehicules recuperee")
    public ResponseEntity<List<Vehicule>> getAll() {
        return ResponseEntity.ok(vehiculeService.retrieveAllVehicules());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recuperer un vehicule par son identifiant")
    @ApiResponse(responseCode = "200", description = "Vehicule trouve")
    @ApiResponse(responseCode = "404", description = "Vehicule introuvable")
    public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.retrieveVehicule(id);
        return vehicule == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(vehicule);
    }

    @PostMapping
    @Operation(summary = "Ajouter un vehicule")
    @ApiResponse(responseCode = "201", description = "Vehicule cree")
    public ResponseEntity<Vehicule> add(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.addVehicule(vehicule));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un vehicule")
    @ApiResponse(responseCode = "200", description = "Vehicule modifie")
    @ApiResponse(responseCode = "404", description = "Vehicule introuvable")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehicule.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.updateVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un vehicule")
    @ApiResponse(responseCode = "204", description = "Vehicule supprime")
    @ApiResponse(responseCode = "404", description = "Vehicule introuvable")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
