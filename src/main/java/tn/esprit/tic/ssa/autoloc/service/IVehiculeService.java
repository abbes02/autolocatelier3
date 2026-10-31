package tn.esprit.tic.ssa.autoloc.service;

import tn.esprit.tic.ssa.autoloc.domain.Vehicule;
import tn.esprit.tic.ssa.autoloc.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {

    List<VehiculeDTO> retrieveAllVehicules();
    VehiculeDTO addVehicule(Vehicule vehicule);
    VehiculeDTO updateVehicule(Vehicule vehicule);
    VehiculeDTO retrieveVehicule(Long id);
    void removeVehicule(Long id);
    List<VehiculeDTO> addVehicules(List<Vehicule> vehicules);
}
