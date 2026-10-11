package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.ssa.autoloc.domain.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {

}
