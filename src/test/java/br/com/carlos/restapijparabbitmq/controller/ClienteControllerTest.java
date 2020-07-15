package br.com.carlos.restapijparabbitmq.controller;

import br.com.carlos.restapijparabbitmq.model.Cliente;
import br.com.carlos.restapijparabbitmq.service.IClienteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class ClienteControllerTest {

    @MockBean
    private IClienteService clienteService;
    private ClienteController clienteController;

    @BeforeAll
    public void setup() throws Exception {
        MockMvcBuilders.standaloneSetup(this.clienteController);
    }

    @Test
    public void deveRetornarTodosOsClientesComStatusOK_BuscarTodos() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        var cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Carlos Eduardo");
        cliente.setDocumento("123456789");
        clientes.add(cliente);
        Mockito.when(this.clienteService.buscarTodos()).thenReturn(clientes);

        var result = clienteController.get();

        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
