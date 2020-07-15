package br.com.carlos.restapijparabbitmq.service;

import br.com.carlos.restapijparabbitmq.exception.MessageException;
import br.com.carlos.restapijparabbitmq.model.Cliente;
import br.com.carlos.restapijparabbitmq.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) throws MessageException {
        var opitionalCliente = clienteRepository.findByDocumento(cliente.getDocumento());
        opitionalCliente = opitionalCliente.filter((c) -> cliente.getId() != c.getId());

        if (opitionalCliente.isPresent())
            throw new MessageException(String.format("Já existe um cliente cadastrado com o documento '%s'", cliente.getDocumento()));

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) throws MessageException {
        var opitionalCliente = clienteRepository.findById(cliente.getId());

        if (!opitionalCliente.isPresent())
            throw new MessageException(String.format("Cliente com id '%d' não cadastrado", cliente.getId()));

        opitionalCliente = clienteRepository.findByDocumento(cliente.getDocumento());
        opitionalCliente = opitionalCliente.filter((c) -> cliente.getId() != c.getId());

        if (opitionalCliente.isPresent())
            throw new MessageException(String.format("Já existe um cliente cadastrado com o documento '%s'", cliente.getDocumento()));

        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        var clientes = clienteRepository.findAll();
        return clientes;
    }
}
