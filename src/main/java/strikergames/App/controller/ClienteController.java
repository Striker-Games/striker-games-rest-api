package strikergames.App.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import strikergames.App.entities.Cliente;
import strikergames.App.repositories.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @GetMapping
    public List<Cliente> getCliente() {
        List<Cliente> list = clienteRepository.findAll();
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente postCliente(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }


}
