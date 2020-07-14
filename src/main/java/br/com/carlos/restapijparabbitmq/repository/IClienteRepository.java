package br.com.carlos.restapijparabbitmq.repository;

import br.com.carlos.restapijparabbitmq.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente save(Cliente cliente);

    Optional<Cliente> findByDocumento(String documento);
}
