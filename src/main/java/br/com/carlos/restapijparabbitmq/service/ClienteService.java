package br.com.carlos.restapijparabbitmq.service;

import br.com.carlos.restapijparabbitmq.exception.DuplicatedException;
import br.com.carlos.restapijparabbitmq.model.Cliente;
import br.com.carlos.restapijparabbitmq.repository.IClienteRepository;
import org.glassfish.hk2.api.DuplicateServiceException;

import java.util.Optional;

public class ClienteService implements IClienteService {

    private final IClienteRepository pessoaRepository;

    public ClienteService(IClienteRepository pessoaRepository) {

        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) throws DuplicatedException {
        var opitionalCliente = pessoaRepository.findByDocumento(cliente.getDocumento());

        if (opitionalCliente.isPresent())
            throw new DuplicatedException(String.format("Já existe um cliente cadastrado com o documento '%s'", cliente.getDocumento()));

        return pessoaRepository.save(cliente);
    }
}
