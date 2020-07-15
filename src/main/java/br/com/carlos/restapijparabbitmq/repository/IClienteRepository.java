package br.com.carlos.restapijparabbitmq.repository;

import br.com.carlos.restapijparabbitmq.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente save(Cliente cliente);

    Optional<Cliente> findByDocumento(String documento);
}
