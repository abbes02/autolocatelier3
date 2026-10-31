package tn.esprit.tic.ssa.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tic.ssa.autoloc.domain.Vehicule;
import tn.esprit.tic.ssa.autoloc.dto.VehiculeDTO;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(target = "agenceId", source = "agence.idAgence")
    @Mapping(target = "agenceNom", source = "agence.nom")
    @Mapping(target = "agenceVille", source = "agence.ville")
    VehiculeDTO toDto(Vehicule vehicule);
}