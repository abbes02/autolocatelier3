package tn.esprit.tic.ssa.autoloc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Employe;
import tn.esprit.tic.ssa.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable Long id) {
        Employe value = employeService.retrieveEmploye(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }

    @PostMapping
    public Employe add(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PostMapping("/batch")
    public List<Employe> addAll(@RequestBody List<Employe> employes) {
        return employeService.addEmployes(employes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        if (employeService.retrieveEmploye(id) == null) {
            return ResponseEntity.notFound().build();
        }
        setId(employe, id);
        return ResponseEntity.ok(employeService.updateEmploye(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (employeService.retrieveEmploye(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeService.removeEmploye(id);
        return ResponseEntity.noContent().build();
    }

    private void setId(Employe employe, Long id) {
        employe.setIdEmploye(id);
    }
}
