package br.com.carlos.restapijparabbitmq.repository;

import br.com.carlos.restapijparabbitmq.model.Cliente;

import java.util.Optional;

public interface IClienteRepository {

    Cliente save(Cliente cliente);

    Optional<Cliente> findByDocument(String documento);
}
