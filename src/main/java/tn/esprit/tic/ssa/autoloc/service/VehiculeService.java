package tn.esprit.tic.ssa.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ssa.autoloc.domain.Vehicule;
import tn.esprit.tic.ssa.autoloc.dto.VehiculeDTO;
import tn.esprit.tic.ssa.autoloc.mapper.VehiculeMapper;
import tn.esprit.tic.ssa.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeService(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public List<VehiculeDTO> retrieveAllVehicules() {
        return vehiculeRepository.findAll()
                .stream()
                .map(vehiculeMapper::toDto)
                .toList();
    }

    @Override
    public VehiculeDTO addVehicule(Vehicule vehicule) {
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(savedVehicule);
    }

    @Override
    public VehiculeDTO updateVehicule(Vehicule vehicule) {
        Vehicule updatedVehicule = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(updatedVehicule);
    }

    @Override
    public VehiculeDTO retrieveVehicule(Long id) {
        return vehiculeRepository.findById(id)
                .map(vehiculeMapper::toDto)
                .orElse(null);
    }

    @Override
    public void removeVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public List<VehiculeDTO> addVehicules(List<Vehicule> vehicules) {
        return vehiculeRepository.saveAll(vehicules)
                .stream()
                .map(vehiculeMapper::toDto)
                .toList();
    }
}
