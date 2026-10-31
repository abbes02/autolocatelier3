package tn.esprit.tic.ssa.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ssa.autoloc.domain.Client;
import tn.esprit.tic.ssa.autoloc.dto.ClientDTO;
import tn.esprit.tic.ssa.autoloc.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> retrieveAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public ClientDTO addClient(Client client) {
        Client savedClient = clientRepository.save(client);
        return convertToDto(savedClient);
    }

    @Override
    public ClientDTO updateClient(Client client) {
        Client updatedClient = clientRepository.save(client);
        return convertToDto(updatedClient);
    }

    @Override
    public ClientDTO retrieveClient(Long id) {
        return clientRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> addClients(List<Client> clients) {
        return clientRepository.saveAll(clients)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private ClientDTO convertToDto(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setIdClient(client.getIdClient());
        dto.setNom(client.getNom());
        dto.setPrenom(client.getPrenom());
        dto.setEmail(client.getEmail());
        dto.setTelephone(client.getTelephone());
        dto.setNumPermis(client.getNumPermis());
        dto.setDateInscription(client.getDateInscription());
        return dto;
    }
}
