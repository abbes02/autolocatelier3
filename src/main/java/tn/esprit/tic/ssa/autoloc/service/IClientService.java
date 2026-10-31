package tn.esprit.tic.ssa.autoloc.service;

import tn.esprit.tic.ssa.autoloc.domain.Client;
import tn.esprit.tic.ssa.autoloc.dto.ClientDTO;

import java.util.List;

public interface IClientService {

    List<ClientDTO> retrieveAllClients();
    ClientDTO addClient(Client client);
    ClientDTO updateClient(Client client);
    ClientDTO retrieveClient(Long id);
    void removeClient(Long id);
    List<ClientDTO> addClients(List<Client> clients);
}
