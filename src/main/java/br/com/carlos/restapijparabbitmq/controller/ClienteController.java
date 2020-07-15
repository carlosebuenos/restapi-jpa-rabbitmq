package br.com.carlos.restapijparabbitmq.controller;

import br.com.carlos.restapijparabbitmq.controller.dto.ClienteDTO;
import br.com.carlos.restapijparabbitmq.exception.MessageException;
import br.com.carlos.restapijparabbitmq.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> get() {
        var clientes = clienteService.buscarTodos();
        var clientesDto = clientes
                .stream()
                .map(ClienteDTO::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientesDto);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) throws MessageException {
        clienteDTO.setId(null);
        clienteService.salvar(ClienteDTO.toEntity(clienteDTO));
        return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) throws Exception {
        clienteDTO.setId(id);
        clienteService.atualizar(ClienteDTO.toEntity(clienteDTO));
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }
}
