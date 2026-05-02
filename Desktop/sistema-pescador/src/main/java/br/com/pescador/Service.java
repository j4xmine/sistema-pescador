package br.com.pescador;

import java.util.List;


// VALIDA CPFs duplicados, decide regras
public class Service {

    private Repository repository = new Repository();

    public void salvar(Pescador pescador) {
        Pescador pescadorExistente = procurarPescador(pescador.getCpf());
        if(pescadorExistente != null) {
            System.out.println("Pescador já cadastrado.");
            return; // interromper o código/cadastro
        } else {
            repository.salvar(pescador);
            System.out.println("Pescador salvo com sucesso.");
        }
    }

    public List<Pescador> listarPescadores() {
        return repository.listarPescadores();
    }

    public Pescador procurarPescador(String cpf) {
        return repository.procurarPescador(cpf);
    }

    public void atualizarDados(Pescador pescador) {
        Pescador pescadorExistente = procurarPescador(pescador.getCpf());
        if(pescadorExistente == null) {
            System.out.println("Pescador não encontrado.");
            return;
        } else {
            repository.atualizarDados(pescador);
            System.out.println("Cadastro atualizado com sucesso!");
        } // posso retirar o ELSE
    }

    public void deletarPescador(Pescador pescador) {
        Pescador pescadorExistente = procurarPescador(pescador.getCpf());
        if(pescadorExistente == null) {
            System.out.println("Pescador não encontrado.");
            return;
        }
        repository.deletarPescador(pescador);
        System.out.println("Pescador deletado.");
    }
}
