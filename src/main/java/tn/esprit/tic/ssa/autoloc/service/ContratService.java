package tn.esprit.tic.ssa.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ssa.autoloc.domain.Contrat;
import tn.esprit.tic.ssa.autoloc.repository.ContratRepository;

import java.util.List;

@Service
public class ContratService implements IContratService {

    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat retrieveContrat(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void removeContrat(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public List<Contrat> addContrats(List<Contrat> contrats) {
        return contratRepository.saveAll(contrats);
    }
}
