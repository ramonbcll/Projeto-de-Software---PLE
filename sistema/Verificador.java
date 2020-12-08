package sistema;

import sistema.DadosPessoas;
import sistema.DadosProjeto;

public class Verificador {
	DadosPessoas dadosPessoas = new DadosPessoas();
	DadosProjeto dadosProjeto = new DadosProjeto();

	public boolean projetosPessoas(int projeto, String nome) {
        int x = 0;
        for(int i = 0; i < Integer.parseInt(dadosProjeto.qtdeColaboradores(projeto)); i++) {
            for(int j = 0; j < dadosPessoas.qtdePessoas(); j++) {
                if(nome.equalsIgnoreCase(dadosPessoas.getInfo(j, 0))) {
                    if(dadosPessoas.getInfo(j, 3) == null || dadosPessoas.getInfo(j, 4) == null) {
                        x += 1;
                    }
                }
            }
        }
        if(x > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verificarDados(String nome) {
        int j = 0;
    	int k = 0;
    	for(int i = 0; i < dadosPessoas.qtdePessoas(); i++) {
    		if(nome.equalsIgnoreCase(dadosPessoas.getInfo(i, 0)) && dadosPessoas.getInfo(i, 2).equalsIgnoreCase("aluno")) {
    			j++;
    		}
    		else if(nome.equalsIgnoreCase(dadosPessoas.getInfo(i, 0)) && dadosPessoas.getInfo(i, 2).equalsIgnoreCase("professor")) {
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
}
