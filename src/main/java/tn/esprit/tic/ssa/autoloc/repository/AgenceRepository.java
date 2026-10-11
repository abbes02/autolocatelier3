package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.tic.ssa.autoloc.domain.Agence;

public interface AgenceRepository extends JpaRepository<Agence,Long> {

}
