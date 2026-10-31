package tn.esprit.tic.ssa.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ssa.autoloc.domain.Client;
import tn.esprit.tic.ssa.autoloc.dto.ClientDTO;
import tn.esprit.tic.ssa.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary = "Recuperer tous les clients")
    @ApiResponse(responseCode = "200", description = "Liste des clients recuperee")
    public ResponseEntity<List<ClientDTO>> getAll() {
        return ResponseEntity.ok(clientService.retrieveAllClients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recuperer un client par son identifiant")
    @ApiResponse(responseCode = "200", description = "Client trouve")
    @ApiResponse(responseCode = "404", description = "Client introuvable")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
        ClientDTO client = clientService.retrieveClient(id);
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

    @PostMapping
    @Operation(summary = "Ajouter un client")
    @ApiResponse(responseCode = "201", description = "Client cree")
    public ResponseEntity<ClientDTO> add(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(client));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")
    @ApiResponse(responseCode = "200", description = "Client modifie")
    @ApiResponse(responseCode = "404", description = "Client introuvable")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody Client client) {
        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client")
    @ApiResponse(responseCode = "204", description = "Client supprime")
    @ApiResponse(responseCode = "404", description = "Client introuvable")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
