package sistema;

import java.util.Scanner;
import sistema.Pessoas;

public class Laboratorio {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosProjetos = new String[20][20];
    public static int qtdeProjeto = 0;
    Pessoas add = new Pessoas();

    public String getValor_dadosProjetos(int x, int y) {
        return dadosProjetos[x][y];
    }

    public void projetos () {
        String status = "Em elaboração";
        System.out.println("Digite a opção que deseja acessar\n [1] Cadastrar Projetos\n [2] Alterar Projetos\n [3] Voltar ao menu principal");
        int option = input.nextInt();

        if(option == 1) {
            System.out.println("Digite quantos colaboradores o projeto terá");
            int colaboradores = input.nextInt();
            System.out.println("Digite os dados na seguinte ordem: ");
            System.out.printf("TITULO, DATA DE INICIO E TÉRMINO (SOMENTE NÚMEROS), STATUS, AGÊNCIA FINANCIADORA, VALOR FINANCIADO, OBJETIVO, DESCRIÇÃO, NOME DO(S) %d COLABORADOR(ES)\n", colaboradores);

            for(int colunas = 0; colunas <= 9; colunas++) {
                if(colunas == 4) {
                    if(status.equalsIgnoreCase(dadosProjetos[qtdeProjeto][3])) {
                        System.out.println("Status aprovado.");
                    }
                    else {
                        System.out.println("Status incorrreto.\nSó poderá continuar com o status EM ELABORACAO.");
                        projetos();
                    }
                }
                else if(colunas == 9) {
                    int linhas = qtdeProjeto;
                    add.addColaboradores(linhas, colunas, colaboradores, 0, 0, dadosProjetos);
                    System.out.println("Colaboradores cadastrados com sucesso.");
                    qtdeProjeto += 1;
                }
                else if(colunas < 9) {
                    dadosProjetos[qtdeProjeto][colunas] = input.nextLine();
                }
            }
        }
        else if(option == 2) {

        }
        else if(option == 3) {
            return;
        }
    }
}
