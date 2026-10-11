package tn.esprit.tic.ssa.autoloc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Maintenance;
import tn.esprit.tic.ssa.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    public MaintenanceController(IMaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getById(@PathVariable Long id) {
        Maintenance value = maintenanceService.retrieveMaintenance(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }

    @PostMapping
    public Maintenance add(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @PostMapping("/batch")
    public List<Maintenance> addAll(@RequestBody List<Maintenance> maintenances) {
        return maintenanceService.addMaintenances(maintenances);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        if (maintenanceService.retrieveMaintenance(id) == null) {
            return ResponseEntity.notFound().build();
        }
        setId(maintenance, id);
        return ResponseEntity.ok(maintenanceService.updateMaintenance(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (maintenanceService.retrieveMaintenance(id) == null) {
            return ResponseEntity.notFound().build();
        }
        maintenanceService.removeMaintenance(id);
        return ResponseEntity.noContent().build();
    }

    private void setId(Maintenance maintenance, Long id) {
        maintenance.setIdMaintenance(id);
    }
}
