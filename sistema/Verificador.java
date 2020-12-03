package sistema;

public class Verificador {
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
}
