package sistema;

import java.util.Scanner;
import sistema.Pessoas;
import sistema.DadosProjeto;
import sistema.DadosPessoas;

public class Laboratorio {
    public static Scanner input = new Scanner(System.in);
    Pessoas pessoas = new Pessoas();
    DadosProjeto dadosProjeto = new DadosProjeto();
    DadosPessoas dadosPessoas = new DadosPessoas();

    public void publicacoesProjeto() {
        System.out.println("Digite o nome do projeto que deseja adicionar publicacoes:");
        input.nextLine();
        String projeto = input.nextLine();
        System.out.printf("%s\n", projeto);
        for(int i = 0; i < dadosProjeto.qtdeProjeto(); i++) {
            if(projeto.equalsIgnoreCase(dadosProjeto.getInfo(i, 0))) {
                System.out.println("Projeto encontrado!");
                if(dadosProjeto.getPublicacoes(i) != null) {
                    System.out.println("O projeto ja possui publicacoes associadas a ele.");
                }
                else {
                    System.out.println("Digite as informacoes sobre a publicacao que deseja adicionar ao projeto:");
                    dadosProjeto.setPublicacoes(i);
                    System.out.printf("Publicacao adicionada ao %s\n", projeto);
                }
            }
            else if(i == dadosProjeto.qtdeProjeto() - 1) {
                System.out.println("Projeto nao encontrado.");
            }
        }
    }

    public void verificarProjeto(int n) {
        if(dadosProjeto.getInfo(n, 0).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o TITULO:");
            dadosProjeto.setInfo(n, 0);
        }
        if(dadosProjeto.getInfo(n, 1).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a DATA DE INICIO (SOMENTE NUMEROS):");
            dadosProjeto.setInfo(n, 1);
        }
        if(dadosProjeto.getInfo(n, 2).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a DATA DE TERMINO (SOMENTE NUMEROS):");
            dadosProjeto.setInfo(n, 2);
        }
        if(dadosProjeto.getInfo(n, 3).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o STATUS:");
            dadosProjeto.setInfo(n, 3);
        }
        if(dadosProjeto.getInfo(n, 3).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a AGENCIA FINANCIADORA:");
            dadosProjeto.setInfo(n, 4);
        }
        if(dadosProjeto.getInfo(n, 5).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o VALOR FINANCIADO:");
            dadosProjeto.setInfo(n, 5);
        }
        if(dadosProjeto.getInfo(n, 6).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo o OBJETIVO:");
            dadosProjeto.setInfo(n, 6);
        }
        if(dadosProjeto.getInfo(n, 7).equalsIgnoreCase("x")) {
            System.out.println("O projeto nao possui todos os dados basicos para alterar o status.");
            System.out.println("Digite a baixo a DESCRICAO:");
            dadosProjeto.setInfo(n, 7);
        }
        for(int i = 0; i < 8; i++) {
            if(dadosProjeto.getInfo(n, i).equalsIgnoreCase("x")) {
                verificarProjeto(n);
            }
        }
        return;
    }

    public void alterarStatusProjetos() {
        System.out.println("Digite o nome COMPLETO do projeto que desejar realizar alteracoes no status");
        String status = "Em elaboracao", status2 = "Em andamento";
        String lixo = input.nextLine();
        String busca = input.nextLine();
        for(int i = 0; i < dadosProjeto.qtdeProjeto(); i++) {
            if(busca.equalsIgnoreCase(dadosProjeto.getInfo(i, 0))) {
                System.out.println("Projeto encontrado!");
                verificarProjeto(i);
                if(status.equalsIgnoreCase(dadosProjeto.getInfo(i, 3))) {
                    System.out.println("Voce pode apenas mudar o status desse projeto para EM ANDAMENTO\n [1] Para alterar\n [2] Para nao alterar\n [3] Sair para o menu");
                    int option = input.nextInt();
                    if(option == 1) {
                        dadosProjeto.alterarStatus(i, 3, 1);
                        System.out.println("Alteracao feita com sucesso.");
                    }
                    else if(option == 2){
                        alterarStatusProjetos();
                    }
                    else if(option == 3) {
                        return;
                    }
                }
                else if(status2.equalsIgnoreCase(dadosProjeto.getInfo(i, 3))) {
                    if(dadosProjeto.getInfo(i, 13) == null) {
                        System.out.println("O projeto nao possui publicacoes, nao e possivel alterar o status, adicione publicacoes a ele.");
                        return;
                    }
                    else {
                        System.out.println("Voce pode apenas mudar o status desse projeto para CONCLUIDO\n [1] Para alterar\n [2] Para nao alterar\n [3] Sair para o menu");
                        int option = input.nextInt();
                        if(option == 1) {
                            dadosProjeto.alterarStatus(i, 3, 2);
                            System.out.println("Alteracao feita com sucesso.");
                        }
                        else if(option == 2){
                            alterarStatusProjetos();
                        }
                        else if(option == 3) {
                            return;
                        }
                    }
                }
                else if(i == dadosProjeto.qtdeProjeto() - 1) {
                    System.out.println("Projeto nao encontrado.");
                }
            }
        }
    }

    public void projetos () {
        String status = "Em elaboracao";
        System.out.println("Digite a opcao que deseja acessar\n [1] Cadastrar Projetos\n [2] Alterar Projetos\n [3] Adicionar publicacoes a um projeto\n [4] Voltar ao menu principal");
        int option = input.nextInt();

        if(option == 1) {
            System.out.println("Digite quantos colaboradores o projeto tera:");
            int colaboradores = input.nextInt();
            dadosProjeto.totalColaboradores(dadosProjeto.qtdeProjeto(), colaboradores);
            String lixo = input.nextLine();
            System.out.println("Digite os dados na seguinte ordem: ");
            System.out.printf("TITULO, DATA DE INICIO E TERMINO (SOMENTE NUMEROS), STATUS, AGENCIA FINANCIADORA, VALOR FINANCIADO, OBJETIVO, DESCRICAO, NOME DO(S) %d COLABORADOR(ES)\n", colaboradores);
            System.out.println("Se desejar preencher alguma informacao futuramente, preencha com um X.");

            for(int colunas = 0; colunas <= 8; colunas++) {
                if(colunas == 8) {
                    int linhas = dadosProjeto.qtdeProjeto();
                    pessoas.addColaboradores(linhas, colunas, colaboradores, 0, 0);
                    dadosProjeto.addProjeto();
                }
                else if(colunas < 8) {
                    dadosProjeto.setInfo(dadosProjeto.qtdeProjeto(), colunas);
                    if(colunas == 3) {
                        if(status.equalsIgnoreCase(dadosProjeto.getInfo(dadosProjeto.qtdeProjeto(), 3))) {
                            System.out.println("Status aprovado.");
                        }
                        else {
                            System.out.println("Status incorreto.\nSo podera continuar com o status EM ELABORACAO.");
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
            publicacoesProjeto();
            projetos();
        }
        else if(option == 4) {
            return;
        }
    }
}