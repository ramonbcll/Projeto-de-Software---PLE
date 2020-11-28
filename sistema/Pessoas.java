package sistema;

import java.util.Scanner;

public class Pessoas {
    public static int qtdePessoas = 0;
    public static Scanner input = new Scanner(System.in);
    public static String[][] dados = new String[20][7];

    public void pesquisarColaboradores() {
        System.out.println("Bem-vindo a busca de colaboradores, digite o nome do colaborador que deseja procurar no nosso bando de dados");
        String lixo = input.nextLine();
        String busca = input.nextLine();
        for(int linhas = 0; linhas < qtdePessoas; linhas++) {
            if(busca.equalsIgnoreCase(dados[linhas][0])) {
                System.out.println("Colaborador encontrado. Abaixo, seguem as informações cadastradas do colaborador na seguinte sequência: NOME, E-MAIL, PROJETOS QUE PARTICIPOU, PROJETOS EM ANDAMENTO, PRODUÇÃO ACADÊMICA, CARGO:");
                for(int colunas = 0; colunas < 6; colunas++) {
                    System.out.println(dados[linhas][colunas]);
                }
            }
        }
        return;
    }

    public void colaboradores() {
        System.out.println("Digite o que deseja fazer:\n 1- Cadastrar colaboradores\n 2- Pesquisar colaboradores\n 3- Voltar ao menu principal");
        int option = input.nextInt();
        int colunas = 0;

        if(option == 1) {
            System.out.println("NOME:");
            String lixo = input.nextLine();
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("E-MAIL:");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PROJETOS QUE PARTICIPOU:");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PROJETOS EM ANDAMENTO:");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PRODUÇÃO ACADÊMICA:");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("TITULO:");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            qtdePessoas += 1;
            System.out.println("Colaborador cadastrado com sucesso.");
            colaboradores();
        }
        else if(option == 2) {
            pesquisarColaboradores();
            colaboradores();
        }
        else if(option == 3) {
            return;
        }
    }
}
