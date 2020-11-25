package projeto;

import java.util.Scanner;

public class Pessoas {
    public static int qtdePessoas = 0;
    public static Scanner input = new Scanner(System.in);
    public static String[][] dados = new String[20][7];

    public void colaboradores() {
        System.out.println("Digite o que deseja fazer:\n 1- Cadastrar colaboradores\n 2- Pesquisar colaboradores\n 3- Voltar para o menu anterior");
        int option = input.nextInt();
        int colunas = 0;

        if(option == 1) {
            System.out.println("NOME");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("E-MAIL");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PROJETOS QUE PARTICIPOU");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PROJETOS EM ANDAMENTO");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PRODUÇÃO ACADÊMICA");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("TITULO");
            dados[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            qtdePessoas += 1;   
        }
    }
}
