package model;

import java.util.Scanner;

public class CadastroPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    incluir(scanner, repoFisica, repoJuridica);
                    break;
                case 2:
                    alterar(scanner, repoFisica, repoJuridica);
                    break;
                case 3:
                    excluir(scanner, repoFisica, repoJuridica);
                    break;
                case 4:
                    exibirPorId(scanner, repoFisica, repoJuridica);
                    break;
                case 5:
                    exibirTodos(scanner, repoFisica, repoJuridica);
                    break;
                case 6:
                    salvarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 7:
                    recuperarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo == 1) {
            // Incluir Pessoa Física
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
        } else if (tipo == 2) {
            // Incluir Pessoa Jurídica
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();

            repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("ID para alteração: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo == 1) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                System.out.println("Dados atuais: ");
                pf.exibir();
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Nova idade: ");
                int idade = scanner.nextInt();

                pf.setNome(nome);
                pf.setCpf(cpf);
                pf.setIdade(idade);
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                System.out.println("Dados atuais: ");
                pj.exibir();
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CNPJ: ");
                String cnpj = scanner.nextLine();

                pj.setNome(nome);
                pj.setCnpj(cnpj);
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("ID para exclusão: ");
        int id = scanner.nextInt();

        if (tipo == 1) {
            repoFisica.excluir(id);
        } else if (tipo == 2) {
            repoJuridica.excluir(id);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("ID: ");
        int id = scanner.nextInt();

        if (tipo == 1) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                pf.exibir();
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                pj.exibir();
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo == 1) {
            for (PessoaFisica pf : repoFisica.obterTodos()) {
                pf.exibir();
            }
        } else if (tipo == 2) {
            for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                pj.exibir();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void salvarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.persistir(prefixo + ".fisica.bin");
            repoJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.recuperar(prefixo + ".fisica.bin");
            repoJuridica.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
}
