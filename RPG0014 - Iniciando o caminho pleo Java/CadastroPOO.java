package model;

public class CadastroPOO {
    public static void main(String[] args) {
        try {
            // Teste para PessoaFisica
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "João Silva", "123.456.789-00", 30));
            repo1.inserir(new PessoaFisica(2, "Maria Oliveira", "987.654.321-00", 25));
            repo1.persistir("pessoas_fisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");
            System.out.println("Pessoas Físicas Recuperadas:");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }

            // Teste para PessoaJuridica
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Empresa A", "12.345.678/0001-90"));
            repo3.inserir(new PessoaJuridica(2, "Empresa B", "98.765.432/0001-00"));
            repo3.persistir("pessoas_juridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");
            System.out.println("Pessoas Jurídicas Recuperadas:");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
