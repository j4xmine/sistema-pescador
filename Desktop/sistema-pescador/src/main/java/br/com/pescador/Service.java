package br.com.pescador;

import java.util.List;

public class Service {

    private Repository repository = new Repository();

    public void salvar(Pescador pescador) {
        repository.salvar(pescador);
    }

    public List<Pescador> listarPescadores() {
        return repository.listarPescadores();
    }

    public Pescador procurarPescador(String cpf) {
        return repository.procurarPescador(cpf);
    }

    public void atualizarDados(Pescador pescador) {
        repository.atualizarDados(pescador);
    }
}
