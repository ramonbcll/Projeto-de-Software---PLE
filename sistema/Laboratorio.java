package sistema;

import java.util.Scanner;
import sistema.Pessoas;

public class Laboratorio {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosProjetos = new String[20][11];
    public static int qtdeProjeto = 0;
    Pessoas add = new Pessoas();

    public void projetos () {
        String status = "Em elaboracao";
        System.out.println("Digite a opcao que deseja acessar\n [1] Cadastrar Projetos\n [2] Alterar Projetos\n [3] Voltar ao menu principal");
        int option = input.nextInt();

        if(option == 1) {
            System.out.println("Digite quantos colaboradores o projeto tera:");
            int colaboradores = input.nextInt();
            String lixo = input.nextLine();
            System.out.println("Digite os dados na seguinte ordem: ");
            System.out.printf("TITULO, DATA DE INICIO E TERMINO (SOMENTE NUMEROS), STATUS, AGENCIA FINANCIADORA, VALOR FINANCIADO, OBJETIVO, DESCRICAO, NOME DO(S) %d COLABORADOR(ES)\n", colaboradores);

            for(int colunas = 0; colunas <= 8; colunas++) {
                //System.out.printf("%d ", colunas);
                if(colunas == 8) {
                    int linhas = qtdeProjeto;
                    add.addColaboradores(linhas, colunas, colaboradores, 0, 0, dadosProjetos);
                    System.out.println("Colaboradores cadastrados com sucesso.");
                    qtdeProjeto += 1;
                }
                else if(colunas < 8) {
                    dadosProjetos[qtdeProjeto][colunas] = input.nextLine();
                    //System.out.printf("-----> %s\n", dadosProjetos[qtdeProjeto][colunas]);
                    if(colunas == 3) {
                        if(status.equalsIgnoreCase(dadosProjetos[qtdeProjeto][3])) {
                            System.out.println("Status aprovado.");
                        }
                        else {
                            System.out.println("Status incorrreto.\nSó poderá continuar com o status EM ELABORACAO.");
                            projetos();
                        }
                    }
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
