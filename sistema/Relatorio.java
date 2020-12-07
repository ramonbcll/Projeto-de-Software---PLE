package sistema;

import java.util.Scanner;
import sistema.DadosProjeto;
import sistema.DadosPessoas;

public class Relatorio {
    public static Scanner input = new Scanner(System.in);
	DadosProjeto dadosProjeto = new DadosProjeto();
	DadosPessoas dadosPessoas = new DadosPessoas();
    
    public void relatorios() {
		int e = 0, a = 0, c = 0;
		System.out.println("Informacoes do laboratorio:");
		System.out.printf("Total de colaboradores: %d", dadosPessoas.qtdePessoas());
		for(int i = 0; i < dadosProjeto.qtdeProjeto(); i++) {
			if(dadosProjeto.infoProjetos(i, 3).equalsIgnoreCase("em elaboracao")) {
				e += 1;
			}
			else if(dadosProjeto.infoProjetos(i, 3).equalsIgnoreCase("em andamento")) {
				a += 1;
			}
			else if(dadosProjeto.infoProjetos(i, 3).equalsIgnoreCase("concluido")) {
				c += 1;
			}
		}
		System.out.printf("Projetos em elaboracao: %d", e);
		System.out.printf("Projetos em andamento: %d", a);
		System.out.printf("Projetos concluidos: %d", c);
		System.out.printf("Total de projetos: %d", dadosProjeto.qtdeProjeto());

        System.out.println("Digite o nome do projeto que deseja obter informacoes:");
		String busca = input.nextLine();
    	for(int i = 0; i < dadosProjeto.qtdeProjeto(); i++) {
    		if(busca.equalsIgnoreCase(dadosProjeto.infoProjetos(i, 0))) {
    			for(int colunas = 0; colunas < 13; colunas++) {
					if(dadosProjeto.infoProjetos(i, colunas) != null) {
    					System.out.println(dadosProjeto.infoProjetos(i, colunas));
					}
				}
            }
            else if(i == dadosProjeto.qtdeProjeto() - 1) {
    			System.out.println("Laboratorio nao Encontrado");
    		}
    	}
    }
}
