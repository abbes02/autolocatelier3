package tn.esprit.tic.ssa.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.ssa.autoloc.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
