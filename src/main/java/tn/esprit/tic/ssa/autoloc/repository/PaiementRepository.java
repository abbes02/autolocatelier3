package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.ssa.autoloc.domain.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {

}
