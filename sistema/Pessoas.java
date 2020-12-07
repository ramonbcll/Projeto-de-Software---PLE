package sistema;

import java.util.Scanner;
import sistema.DadosProjeto;
import sistema.DadosPessoas;
import sistema.Verificador;

public class Pessoas {
    public static int qtdePessoas = 0;
    public static Scanner input = new Scanner(System.in);
    DadosProjeto dadosProjeto = new DadosProjeto();
    DadosPessoas dadosPessoas = new DadosPessoas();
    Verificador verifica = new Verificador();

    public void addColaboradores(int linhas, int colunas, int qtdeColaboradores, int alunos, int professores) {
        String nome, statusV = "Em elaboracao";
        boolean statusPessoa, totalProjetosPessoas;
        System.out.println("Digite o nome de todos os colaboradores:");
        input.nextLine();
        for(int i = 0; i < qtdeColaboradores; i++) {
            nome = input.nextLine();
            statusPessoa = verifica.verificarDados(nome);
            totalProjetosPessoas = verifica.projetosPessoas(dadosProjeto.qtdeProjeto(), nome);
            if(statusPessoa == true && totalProjetosPessoas == true && dadosProjeto.infoProjetos(linhas, 3).equalsIgnoreCase(statusV)) {
                for(int j = 0; j < 20; j++) {
                    if(nome.equalsIgnoreCase(dadosPessoas.infoPessoas(j, 0)) && dadosPessoas.infoPessoas(j, 5).equalsIgnoreCase("professor")) {
                        if(professores < 2) {
                            dadosPessoas.setProjetoPessoa(j, dadosProjeto.infoProjetos(dadosProjeto.qtdeProjeto(), 0));
                            System.out.println("Professor cadastrado no projeto com sucesso.");
                            professores += 1;
                            dadosProjeto.setColaborador(linhas, 7 + professores + alunos, nome);
                            break;
                        }
                    }
                    else if(nome.equalsIgnoreCase(dadosPessoas.infoPessoas(j, 0)) && dadosPessoas.infoPessoas(j, 5).equalsIgnoreCase("aluno") && professores >= 1) {
                        if(alunos < 2) {
                            dadosPessoas.setProjetoPessoa(j, dadosProjeto.infoProjetos(dadosProjeto.qtdeProjeto(), 0));
                            System.out.println("Aluno cadastrado no projeto com sucesso.");                            
                            alunos += 1;
                            dadosProjeto.setColaborador(linhas, 7 + professores + alunos, nome);
                            break;
                        }
                    }
                    else if(nome.equalsIgnoreCase(dadosPessoas.infoPessoas(j, 0)) && dadosPessoas.infoPessoas(j, 5).equalsIgnoreCase("aluno") && professores <= 0) {
                        System.out.println("O colaborador nao e um professor, primeiro cadastre pelo menos um professor no projeto.");
                        i -= 1;
                        break;
                    }
                }
            }
            else if(statusPessoa == true && totalProjetosPessoas == false && dadosProjeto.infoProjetos(linhas, 3).equalsIgnoreCase(statusV)) {
                System.out.println("Esse colaborador nao pode participar de mais projetos.");
                i -= 1;
            }
            else if(statusPessoa == false && dadosProjeto.infoProjetos(linhas, 3).equalsIgnoreCase(statusV)) {
                System.out.println("Colaborador nao encontrado no banco de dados.");
                i -= 1;
            }
            else if(totalProjetosPessoas == true) {
                System.out.println("O colaborador nao pode ser cadastrado em mais projetos.");
            }
            else {
                System.out.println("Nao e possível alocar pessoas nesse projeto pois nao esta mais em elaboracao.");
                i -= 1;
            }

            if(alunos == 2) {
                System.out.println("Voce nao pode adicionar mais alunos ao projeto");
            }
            else if(professores == 2) {
                System.out.println("Voce nao pode adicionar mais professores ao projeto");
            }
        }
    }

    public void pesquisarColaboradores() {
        System.out.println("Bem-vindo a busca de colaboradores, digite o nome do colaborador que deseja procurar no nosso bando de dados");
        String lixo = input.nextLine();
        String busca = input.nextLine();
        for(int linhas = 0; linhas < dadosPessoas.qtdePessoas(); linhas++) {
            if(busca.equalsIgnoreCase(dadosPessoas.infoPessoas(linhas, 0))) {
                System.out.println("Colaborador encontrado. Abaixo, seguem as informacoes cadastradas do colaborador na seguinte sequencia:\nNOME, E-MAIL, PROJETOS QUE PARTICIPOU, PROJETOS EM ANDAMENTO, PRODUCAO ACADEMICA, CARGO:");
                for(int colunas = 0; colunas < 8; colunas++) {
                    if(dadosPessoas.infoPessoas(linhas, colunas) != null) {
                        System.out.println(dadosPessoas.infoPessoas(linhas, colunas));
                    }
                }
            }
        }
        return;
    }

    public void colaboradores() {
        System.out.println("\nDigite o que deseja fazer:\n [1] Cadastrar colaboradores\n [2] Pesquisar colaboradores\n [3] Voltar ao menu principal");
        int option = input.nextInt();
        int colunas = 0;

        if(option == 1) {
            System.out.println("NOME:");
            String lixo = input.nextLine();
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            colunas += 1;
            System.out.println("E-MAIL:");
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            colunas += 1;
            System.out.println("PROJETOS QUE PARTICIPOU:");
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            colunas += 1;
            System.out.println("PROJETOS EM ANDAMENTO:");
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            colunas += 1;
            System.out.println("PRODUCAO ACADEMICA:");
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            colunas += 1;
            System.out.println("TITULO:");
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            colunas += 1;
            dadosPessoas.setPessoas();
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