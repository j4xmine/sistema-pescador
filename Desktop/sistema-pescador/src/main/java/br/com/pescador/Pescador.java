package br.com.pescador;


// ENTIDADE/MODEL
public class Pescador {

    private String id; // esse é gerado pelo próprio Mongo
    private String nome;
    private String cpf;
    private String senha;
    private String dataNascimento;
    private String telefone;

    public Pescador() {}

    public Pescador(String nome, String cpf, String senha, String dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

}
