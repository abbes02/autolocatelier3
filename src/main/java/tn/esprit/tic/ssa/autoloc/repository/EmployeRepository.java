package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.ssa.autoloc.domain.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

}
