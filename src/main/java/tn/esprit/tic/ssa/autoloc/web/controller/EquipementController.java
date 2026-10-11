package tn.esprit.tic.ssa.autoloc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Equipement;
import tn.esprit.tic.ssa.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @GetMapping
    public List<Equipement> getAll() {
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getById(@PathVariable Long id) {
        Equipement value = equipementService.retrieveEquipement(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }

    @PostMapping
    public Equipement add(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PostMapping("/batch")
    public List<Equipement> addAll(@RequestBody List<Equipement> equipements) {
        return equipementService.addEquipements(equipements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> update(@PathVariable Long id, @RequestBody Equipement equipement) {
        if (equipementService.retrieveEquipement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        setId(equipement, id);
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (equipementService.retrieveEquipement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        equipementService.removeEquipement(id);
        return ResponseEntity.noContent().build();
    }

    private void setId(Equipement equipement, Long id) {
        equipement.setIdEquipement(id);
    }
}
