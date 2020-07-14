package br.com.carlos.restapijparabbitmq.service;

import br.com.carlos.restapijparabbitmq.exception.DuplicatedException;
import br.com.carlos.restapijparabbitmq.model.Cliente;

public interface IClienteService {

    Cliente salvar(Cliente cliente) throws DuplicatedException;
}
