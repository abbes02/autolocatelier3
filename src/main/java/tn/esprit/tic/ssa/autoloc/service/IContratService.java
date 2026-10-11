package tn.esprit.tic.ssa.autoloc.service;

import tn.esprit.tic.ssa.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    Contrat retrieveContrat(Long id);
    void removeContrat(Long id);
    List<Contrat> addContrats(List<Contrat> contrats);
}
