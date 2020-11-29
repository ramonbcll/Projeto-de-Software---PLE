package sistema;

import java.util.Scanner;

public class Pessoas {
    public static int qtdePessoas = 0;
    public static Scanner input = new Scanner(System.in);
    public static String[][] dados = new String[20][7];

    public boolean verificarDados(String nome) {
        int j = 0;
    	int k = 0;
    	for(int i = 0; i < qtdePessoas; i++) {
    		if(nome.equalsIgnoreCase(dados[i][0]) && dados[i][5].equalsIgnoreCase("aluno")) {
    			j++;
    		}
    		else if(nome.equalsIgnoreCase(dados[i][0]) && dados[i][5].equalsIgnoreCase("professor")) {
    			k++;
    		}
    	}
    	if (j > 0 && k < 0 ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public void addColaboradores(int linhas, int colunas, int qtdeColaboradores, int alunos, int professores, String statusProjeto[][]) {
        String nome, statusV = "Em elaboracao";
        boolean statusPessoa;
        System.out.println("addColaboradores");
        for(int i = 0; i < qtdeColaboradores; i++) {
            System.out.printf("Digite o nome de %d colaborador(es): \n", qtdeColaboradores - i);
            nome = input.nextLine();
            statusPessoa = verificarDados(nome);

            if(statusPessoa == true && statusProjeto[linhas][3].equalsIgnoreCase(statusV)) {
                alunos += 1;
            }
            else if(statusPessoa == false && statusProjeto[linhas][3].equalsIgnoreCase(statusV)) {
                professores += 1;
            }
            else {
            	System.out.println("Colaborador não encontrado no banco de dados.");
            }

            if(alunos > 2) {
            	System.out.println("Voce nao pode adicionar mais alunos ao projeto");
            }
            else if(professores == 0) {
            	System.out.println("Voce precisa de pelo menos 1 professor para projeto");
            }
        	else if(professores >= 2) {
        		System.out.println("Voce nao pode adicionar mais professores ao projeto");
        	}
        }
    }

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
        System.out.println("Digite o que deseja fazer:\n [1] Cadastrar colaboradores\n [2] Pesquisar colaboradores\n [3] Voltar ao menu principal");
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
