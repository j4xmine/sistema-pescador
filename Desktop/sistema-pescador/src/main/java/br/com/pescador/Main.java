package br.com.pescador;

import org.bson.Document;

import java.util.List;
import java.util.Scanner;

//        String nome = "Victor";
//        String cpf = "010.011.023-23";
//        String senha = "roma12@";
//        String data = "01/01/1991";
//        String telefone = "83 9 8140-1717";
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Service service = new Service();

        while(true) {
            System.out.println("========== SISTEMA - VICTOR ==========");
            System.out.printf(
                    "1 - CADASTRAR PESCADOR%n" +
                    "2 - EDITAR PESCADOR%n" +
                    "3 - DELETAR PESCADOR%n" +
                    "4 - LISTAR PESCADORES%n" +
                    "5 - PROCURAR PESCADOR%n" +
                    "6 - %n" +
                    "11 - SAIR%n");

            System.out.print("Escolha uma opção: ");
            int escolhaMenu = input.nextInt();
            input.nextLine();
            if(escolhaMenu == 1) {
                Pescador pescador;
                Document doc;
                System.out.println("========== CADASTRO DO PESCADOR ==========");
                System.out.print("NOME: ");
                String nome = input.nextLine();
                System.out.print("CPF: ");
                String cpf = input.nextLine();
                System.out.print("SENHA: ");
                String senha = input.nextLine();
                System.out.print("DATA DE NASCIMENTO: ");
                String dataNascimento = input.nextLine();
                System.out.print("TELEFONE: ");
                String telefone = input.nextLine();

                pescador = new Pescador(nome, cpf, senha, dataNascimento, telefone);
                service.salvar(pescador);
            } else if(escolhaMenu == 2) {
                while(true) {
                    System.out.print("Insira o CPF para atualizar: ");
                    String cpf = input.nextLine();
                    Pescador pescador = service.procurarPescador(cpf);
                    if(pescador != null) {
                        Pescador pescadorAtualizado;
                        System.out.println("Pescador encontrado.");
                        System.out.print("NOME: ");
                        String nome = input.nextLine();
                        if(nome.isEmpty()) {
                            nome = pescador.getNome();
                        }
                        System.out.print("SENHA: ");
                        String senha = input.nextLine();
                        if(senha.isEmpty()) {
                            senha = pescador.getSenha();
                        }
                        System.out.print("DATA DE NASCIMENTO: ");
                        String dataNascimento = input.nextLine();
                        if(dataNascimento.isEmpty()) {
                            dataNascimento = pescador.getDataNascimento();
                        }
                        System.out.print("TELEFONE: ");
                        String telefone = input.nextLine();
                        if(telefone.isEmpty()) {
                            telefone = pescador.getTelefone();
                        }
//                        String nome, String cpf, String senha, String dataNascimento, String telefone
                        pescador = new Pescador(nome, cpf, senha, dataNascimento, telefone);
                        service.atualizarDados(pescador);
                        System.out.println("Dados atualizados com sucesso.");
                    }
                }
            } else if(escolhaMenu == 4) {
                System.out.println("========== LISTAR PESCADORES CADASTRADOS ==========");
                List<Pescador> pescadores = service.listarPescadores();
                for(Pescador pescador : pescadores) {
                    System.out.println("ID: " + pescador.getId());
                    System.out.println("CPF: " + pescador.getCpf());
                    System.out.println("Nome: " + pescador.getNome());
                    System.out.println("Senha: " + pescador.getSenha());
                    System.out.println("============================================================");
                }
            } else if(escolhaMenu == 5) {
                System.out.println("========== PROCURAR PESCADOR (VIA CPF) ==========");
                while(true) {
                    System.out.print("Informe o CPF: ");
                    String cpf = input.nextLine();
                    if(cpf.equals("0")) {
                        break;
                    }
                    Pescador pescadorEncontrado = service.procurarPescador(cpf);
                    if(pescadorEncontrado != null) {
                        System.out.println("Pescador encontrado!");
                        System.out.println("NOME: " + pescadorEncontrado.getNome());
                        System.out.println("CPF: " + pescadorEncontrado.getCpf());
                        System.out.println("SENHA: " + pescadorEncontrado.getSenha());
                        System.out.println("DATA DE NASCIMENTO: " + pescadorEncontrado.getDataNascimento());
                        System.out.println("TELEFONE: " + pescadorEncontrado.getTelefone());
                        System.out.println();
                        System.out.println("AÇÕES:");
                        System.out.printf(
                            "1 - ALTERAR DADOS%n" +
                            "2 - DELETAR PESCADOR%n" +
                            "3 - PESQUISAR OUTRO CPF%n");
                    } else {
                        while(pescadorEncontrado == null || !pescadorEncontrado.equals("0")) {
                            System.out.println("Pescador não encontrado! Tente novamente.");
                            System.out.print("CPF: ");
                            cpf = input.nextLine();
                            pescadorEncontrado = service.procurarPescador(cpf);
                        }
                    }
                }

            } else if(escolhaMenu == 11) {
                System.out.println("Saindo do programa...");
                break;
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }










        input.close();
    }
}