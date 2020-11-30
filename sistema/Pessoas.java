package sistema;

import java.util.Scanner;

public class Pessoas {
    public static int qtdePessoas = 0;
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosPessoas = new String[20][7];

    public boolean verificarDados(String nome) {
        int j = 0;
    	int k = 0;
    	for(int i = 0; i < qtdePessoas; i++) {
    		if(nome.equalsIgnoreCase(dadosPessoas[i][0]) && dadosPessoas[i][5].equalsIgnoreCase("aluno")) {
    			j++;
    		}
    		else if(nome.equalsIgnoreCase(dadosPessoas[i][0]) && dadosPessoas[i][5].equalsIgnoreCase("professor")) {
    			k++;
    		}
    	}
    	if (j > 0 || k > 0 ) {
    		return true;
    	}
    	else {
    		return false;
        }
    }

    public void addColaboradores(int linhas, int colunas, int qtdeColaboradores, int alunos, int professores, String statusProjeto[][]) {
        String nome, statusV = "Em elaboracao";
        boolean statusPessoa;
        System.out.printf("Digite o nome de %d colaborador(es): \n", qtdeColaboradores);
        for(int i = 0; i < qtdeColaboradores; i++) {
            input.nextLine();
            nome = input.nextLine();
            statusPessoa = verificarDados(nome);
            if(statusPessoa == true && statusProjeto[linhas][3].equalsIgnoreCase(statusV)) {
                for(int j = 0; j < 20; j++) {
                    if(nome.equalsIgnoreCase(dadosPessoas[j][0]) && dadosPessoas[j][5].equalsIgnoreCase("professor")) {
                        if(professores < 2) {
                            System.out.println("Professor cadastrado no projeto com sucesso.");
                            professores += 1;
                            statusProjeto[linhas][7+professores] = nome;
                            break;
                        }
                    }
                    else if(nome.equalsIgnoreCase(dadosPessoas[j][0]) && dadosPessoas[j][5].equalsIgnoreCase("aluno") && professores >= 1) {
                        if(alunos < 2) {
                            System.out.println("Aluno cadastrado no projeto com sucesso.");                            
                            alunos += 1;
                            break;
                        }
                    }
                    else if(nome.equalsIgnoreCase(dadosPessoas[j][0]) && dadosPessoas[j][5].equalsIgnoreCase("aluno") && professores <= 0) {
                        System.out.println("O colaborador não é um professor, primeiro cadastre pelo menos um professor no projeto.");
                        i -= 1;
                        break;
                    }
                }
                //System.out.printf("%d %d\n", alunos, professores);
            }
            else {
                System.out.println("Colaborador nao encontrado no banco de dados.");
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
        for(int linhas = 0; linhas < qtdePessoas; linhas++) {
            if(busca.equalsIgnoreCase(dadosPessoas[linhas][0])) {
                System.out.println("Colaborador encontrado. Abaixo, seguem as informações cadastradas do colaborador na seguinte sequencia: NOME, E-MAIL, PROJETOS QUE PARTICIPOU, PROJETOS EM ANDAMENTO, PRODUCAO ACADEMICA, CARGO:");
                for(int colunas = 0; colunas < 6; colunas++) {
                    System.out.println(dadosPessoas[linhas][colunas]);
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
            dadosPessoas[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("E-MAIL:");
            dadosPessoas[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PROJETOS QUE PARTICIPOU:");
            dadosPessoas[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PROJETOS EM ANDAMENTO:");
            dadosPessoas[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("PRODUCAO ACADEMICA:");
            dadosPessoas[qtdePessoas][colunas] = input.nextLine();
            colunas += 1;
            System.out.println("TITULO:");
            dadosPessoas[qtdePessoas][colunas] = input.nextLine();
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
