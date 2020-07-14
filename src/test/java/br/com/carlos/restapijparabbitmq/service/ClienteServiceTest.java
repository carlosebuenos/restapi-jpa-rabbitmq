package br.com.carlos.restapijparabbitmq.service;

import br.com.carlos.restapijparabbitmq.exception.DuplicatedException;
import br.com.carlos.restapijparabbitmq.model.Cliente;
import br.com.carlos.restapijparabbitmq.repository.IClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {
    private static final String NOME = "Carlos Eduardo";
    private static final String DOCUMENTO = "123456789";

    @MockBean
    private IClienteRepository clienteRepository;
    private IClienteService clienteService;
    private Cliente cliente;

    @BeforeEach()
    public void setup() throws Exception {
        clienteService = new ClienteService(clienteRepository);
        cliente = new Cliente();
        cliente.setNome(NOME);
        cliente.setDocumento(DOCUMENTO);

        Mockito.when(clienteRepository.findByDocumento(DOCUMENTO)).thenReturn(Optional.empty());
    }

    @Test
    public void deveSalvarClienteNoRepositorio_QuandoSalvar() throws DuplicatedException {
        clienteService.salvar(cliente);

        Mockito.verify(clienteRepository).save(cliente);
    }

    @Test
    public void naoDeveSalvarClienteComMesmoDocumentoNoRepositorio_QuandoSalvar() throws DuplicatedException {
        Mockito.when(clienteRepository.findByDocumento(DOCUMENTO)).thenReturn(Optional.of(cliente));
        Assertions.assertThrows(DuplicatedException.class, () -> clienteService.salvar(cliente));
    }
}
