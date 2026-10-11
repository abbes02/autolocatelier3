package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.ssa.autoloc.domain.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {

}
