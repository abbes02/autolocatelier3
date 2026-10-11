package tn.esprit.tic.ssa.autoloc.service;

import tn.esprit.tic.ssa.autoloc.domain.Client;

import java.util.List;

public interface IClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client client);
    Client updateClient(Client client);
    Client retrieveClient(Long id);
    void removeClient(Long id);
    List<Client> addClients(List<Client> clients);
}
