package br.com.carlos.restapijparabbitmq.controller.dto;


import br.com.carlos.restapijparabbitmq.model.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String documento;

    public static ClienteDTO toDto(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getDocumento());
    }

    public static Cliente toEntity(ClienteDTO cliente) {
        var c = new Cliente();
        c.setId(cliente.getId());
        c.setNome(cliente.getNome());
        c.setDocumento(cliente.getDocumento());
        return c;
    }

    public ClienteDTO(Long id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
