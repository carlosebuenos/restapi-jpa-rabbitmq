package br.com.carlos.restapijparabbitmq.repository;

import br.com.carlos.restapijparabbitmq.model.Cliente;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Sql(value = "/load-db.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
@ExtendWith(SpringExtension.class)
public class ClienteRepositoryTest {

    @Autowired
    private IClienteRepository clienteRepository;

    @Test
    public void deveRetornarClienteCadastrado_QuandoBuscarPorDocumento(){
        var optional = clienteRepository.findByDocumento("123456789");

        Assertions.assertThat(optional.isPresent()).isTrue();

        Cliente cliente = optional.get();
        Assertions.assertThat(cliente.getNome()).isEqualTo("Carlos Eduardo");
        Assertions.assertThat(cliente.getDocumento()).isEqualTo("123456789");
    }

    @Test
    public void naoDeveRetornarClienteNaoCadastrado_QuandoBuscarPorDocumento(){
        var optional = clienteRepository.findByDocumento("000000000");

        Assertions.assertThat(optional.isPresent()).isFalse();
    }
}
