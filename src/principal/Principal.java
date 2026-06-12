package principal;

import model.*;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        try {

            // ======== PESSOAS FISICAS ========

            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            repo1.inserir(new PessoaFisica(
                    1,
                    "Kaio Jorge",
                    "123.456.789-00",
                    25));

            repo1.inserir(new PessoaFisica(
                    2,
                    "Matheus Pereira",
                    "009.876.543-21",
                    28));

            String arqPF = "pessoas_fisicas.dat";

            repo1.persistir(arqPF);

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

            repo2.recuperar(arqPF);

            System.out.println("=== PESSOAS FISICAS RECUPERADAS ===");

            List<PessoaFisica> listaPF = repo2.obterTodos();

            for (PessoaFisica pf : listaPF) {
                pf.exibir();
                System.out.println();
            }

            // ======== PESSOAS JURIDICAS ========

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            repo3.inserir(new PessoaJuridica(
                    1,
                    "Emporio das Tintas",
                    "11.222.333/0001-44"));

            repo3.inserir(new PessoaJuridica(
                    2,
                    "Tech Solucoes",
                    "55.666.777/0001-88"));

            String arqPJ = "pessoas_juridicas.dat";

            repo3.persistir(arqPJ);

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

            repo4.recuperar(arqPJ);

            System.out.println("=== PESSOAS JURIDICAS RECUPERADAS ===");

            List<PessoaJuridica> listaPJ = repo4.obterTodos();

            for (PessoaJuridica pj : listaPJ) {
                pj.exibir();
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}