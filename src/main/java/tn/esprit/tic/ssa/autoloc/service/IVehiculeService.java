package tn.esprit.tic.ssa.autoloc.service;

import tn.esprit.tic.ssa.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {

    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Vehicule vehicule);
    Vehicule retrieveVehicule(Long id);
    void removeVehicule(Long id);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);
}
