package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.tic.ssa.autoloc.domain.Contrat;

public interface ContratRepository extends JpaRepository<Contrat,Long> {

}
