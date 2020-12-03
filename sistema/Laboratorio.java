package sistema;

import java.util.Scanner;
import sistema.Pessoas;
import sistema.DadosProjeto;

public class Laboratorio {
    public static Scanner input = new Scanner(System.in);
    //public static String[][] dadosProjetos = new String[20][11];
    public static int qtdeProjeto = 0;
    Pessoas add = new Pessoas();
    DadosProjeto dadosProjeto = new DadosProjeto();

    public void verificarProjeto(int n) {
        if(dadosProjeto.infoProjetos(n, 0).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o TITULO:");
            dadosProjeto.addInfo(n, 0);
        }
        if(dadosProjeto.infoProjetos(n, 1).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a DATA DE INICIO (SOMENTE NUMEROS):");
            dadosProjeto.addInfo(n, 1);
        }
        if(dadosProjeto.infoProjetos(n, 2).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a DATA DE TERMINO (SOMENTE NUMEROS):");
            dadosProjeto.addInfo(n, 2);
        }
        if(dadosProjeto.infoProjetos(n, 3).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o STATUS:");
            dadosProjeto.addInfo(n, 3);
        }
        if(dadosProjeto.infoProjetos(n, 3).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a AGENCIA FINANCIADORA:");
            dadosProjeto.addInfo(n, 4);
        }
        if(dadosProjeto.infoProjetos(n, 5).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o VALOR FINANCIADO:");
            dadosProjeto.addInfo(n, 5);
        }
        if(dadosProjeto.infoProjetos(n, 6).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o OBJETIVO:");
            dadosProjeto.addInfo(n, 6);
        }
        if(dadosProjeto.infoProjetos(n, 7).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a DESCRICAO:");
            dadosProjeto.addInfo(n, 7);
        }
        for(int i = 0; i < 8; i++) {
            if(dadosProjeto.infoProjetos(n, i).equalsIgnoreCase("x")) {
                verificarProjeto(n);
            }
        }
        return;
    }

    public void alterarStatusProjetos() {
        System.out.println("Digite o nome COMPLETO do projeto que desejar realizar alteracoes no status");
        String status = "Em elaboracao";
        String lixo = input.nextLine();
        String busca = input.nextLine();
        for(int i = 0; i < qtdeProjeto; i++) {
            if(busca.equalsIgnoreCase(dadosProjeto.infoProjetos(i, 0))) {
                System.out.println("Projeto encontrado!");
                verificarProjeto(i);
                if(status.equalsIgnoreCase(dadosProjeto.infoProjetos(i, 3))) {
                    System.out.println("Voce pode apenas mudar o status desse projeto para EM ANDAMENTO\n [1] Para alterar\n [2] Para nao alterar\n [3] Sair");
                    int option = input.nextInt();
                    if(option == 1) {
                        dadosProjeto.alterarStatus(i, 3);
                        System.out.println("Alteracao feita com sucesso.");
                    }
                    else if(option == 2){
                        alterarStatusProjetos();
                    }
                    else if(option == 3) {
                        return;
                    }
                }
                else if(i == qtdeProjeto - 1) {
                    System.out.println("Projeto nao encontrado.");
                }
            }
        }
    }

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
            System.out.println("Se desejar preencher alguma informacao futuramente, preencha com um X.");

            for(int colunas = 0; colunas <= 8; colunas++) {
                if(colunas == 8) {
                    int linhas = qtdeProjeto;
                    add.addColaboradores(linhas, colunas, colaboradores, 0, 0);
                    System.out.println("Colaboradores cadastrados com sucesso.");
                    qtdeProjeto += 1;
                }
                else if(colunas < 8) {
                    dadosProjeto.addInfo(qtdeProjeto, colunas);
                    if(colunas == 3) {
                        if(status.equalsIgnoreCase(dadosProjeto.infoProjetos(qtdeProjeto, 3))) {
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
            alterarStatusProjetos();
            projetos();
        }
        else if(option == 3) {
            return;
        }
    }
}
