package sistema;

import java.util.Scanner;
import sistema.DadosProjeto;
import sistema.DadosPessoas;
import sistema.Verificador;
import sistema.Professor;
import sistema.Aluno;

public class Pessoas {
    public static int qtdePessoas = 0;
    public static Scanner input = new Scanner(System.in);
    DadosProjeto dadosProjeto = new DadosProjeto();
    DadosPessoas dadosPessoas = new DadosPessoas();
    Verificador verifica = new Verificador();
    Professor professor = new Professor();
    Aluno aluno = new Aluno();

    public void addColaboradores(int linhas, int colunas, int qtdeColaboradores, int alunos, int professores) {
        String nome, statusV = "Em elaboracao";
        boolean statusPessoa, totalProjetosPessoas;
        System.out.println("Digite o nome de todos os colaboradores:");
        input.nextLine();
        for(int i = 0; i < qtdeColaboradores; i++) {
            nome = input.nextLine();
            statusPessoa = verifica.verificarDados(nome);
            totalProjetosPessoas = verifica.projetosPessoas(dadosProjeto.qtdeProjeto(), nome);
            if(statusPessoa == true && totalProjetosPessoas == true && dadosProjeto.getInfo(linhas, 3).equalsIgnoreCase(statusV)) {
                for(int j = 0; j < 20; j++) {
                    if(nome.equalsIgnoreCase(dadosPessoas.getInfo(j, 0)) && dadosPessoas.getInfo(j, 2).equalsIgnoreCase("professor")) {
                        if(professores < 2) {
                            dadosPessoas.setProjetoPessoa(j, dadosProjeto.getInfo(dadosProjeto.qtdeProjeto(), 0));
                            System.out.println("Professor cadastrado no projeto com sucesso.");
                            professores += 1;
                            dadosProjeto.setColaborador(linhas, 7 + professores + alunos, nome);
                            break;
                        }
                    }
                    else if(nome.equalsIgnoreCase(dadosPessoas.getInfo(j, 0)) && dadosPessoas.getInfo(j, 2).equalsIgnoreCase("aluno") && professores >= 1) {
                        if(alunos < 2) {
                            dadosPessoas.setProjetoPessoa(j, dadosProjeto.getInfo(dadosProjeto.qtdeProjeto(), 0));
                            System.out.println("Aluno cadastrado no projeto com sucesso.");                            
                            alunos += 1;
                            dadosProjeto.setColaborador(linhas, 7 + professores + alunos, nome);
                            break;
                        }
                    }
                    else if(nome.equalsIgnoreCase(dadosPessoas.getInfo(j, 0)) && dadosPessoas.getInfo(j, 2).equalsIgnoreCase("aluno") && professores <= 0) {
                        System.out.println("O colaborador nao e um professor, primeiro cadastre pelo menos um professor no projeto.");
                        i -= 1;
                        break;
                    }
                }
            }
            else if(statusPessoa == true && totalProjetosPessoas == false && dadosProjeto.getInfo(linhas, 3).equalsIgnoreCase(statusV)) {
                System.out.println("Esse colaborador nao pode participar de mais projetos.");
                i -= 1;
            }
            else if(statusPessoa == false && dadosProjeto.getInfo(linhas, 3).equalsIgnoreCase(statusV)) {
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
            if(busca.equalsIgnoreCase(dadosPessoas.getInfo(linhas, 0))) {
                System.out.println("Colaborador encontrado. Abaixo, seguem todas as informacoes cadastradas do colaborador:");
                for(int colunas = 0; colunas < 5; colunas++) {
                    if(dadosPessoas.getInfo(linhas, colunas) != null) {
                        System.out.println(dadosPessoas.getInfo(linhas, colunas));
                    }
                }
                if(dadosPessoas.getInfo(linhas, 2).equalsIgnoreCase("professor")) {
                    System.out.println(professor.siape);
                }
                else if(dadosPessoas.getInfo(linhas, 2).equalsIgnoreCase("aluno")) {
                    System.out.println(aluno.matricula);
                }
            }
        }
        return;
    }

    public void colaboradores() {
        System.out.println("Digite o que deseja fazer:\n [1] Cadastrar colaboradores\n [2] Pesquisar colaboradores\n [3] Voltar ao menu principal");
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
            System.out.println("TITULO:");
            dadosPessoas.setInfo(dadosPessoas.qtdePessoas(), colunas);
            if(dadosPessoas.getInfo(dadosPessoas.qtdePessoas(), colunas).equalsIgnoreCase("professor")) {
                System.out.println("SIAPE:");
                Professor.siape = input.nextInt();
            }
            else {
                System.out.println("MATRICULA:");
                Aluno.matricula = input.nextInt();
            }
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