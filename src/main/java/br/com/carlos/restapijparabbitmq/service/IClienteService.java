package br.com.carlos.restapijparabbitmq.service;

import br.com.carlos.restapijparabbitmq.exception.MessageException;
import br.com.carlos.restapijparabbitmq.model.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente salvar(Cliente cliente) throws MessageException;

    Cliente atualizar(Cliente cliente) throws MessageException;

    List<Cliente> buscarTodos();
}
