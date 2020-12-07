package sistema;

import java.util.Scanner;

public class DadosProjeto {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosProjetos = new String[20][14];
    public static int total = 0;

    public String infoProjetos(int x, int y) {
        return dadosProjetos[x][y];
    }
    public void setInfo(int x, int y) {
        dadosProjetos[x][y] = input.nextLine();
        return;
    }
    public void alterarStatus(int x, int y, int estado) {
        if(estado == 1) {
            dadosProjetos[x][y] = "Em andamento";
        }
        else {
            dadosProjetos[x][y] = "Concluido";
        }
        return;
    }
    public void setColaborador(int x, int y, String nome) {
        dadosProjetos[x][y] = nome;
        return;
    }
    public int qtdeProjeto() {
        return total;
    }
    public void addProjeto() {
        total += 1;
        return;
    }
    public void totalColaboradores(int x, int n) {
        dadosProjetos[x][12] = String.valueOf(n);
        return;
    }
    public String qtdeColaboradores(int x) {
        return dadosProjetos[x][12];
    }
    public String getPublicacoes(int x) {
        return dadosProjetos[x][13];
    }
    public void setPublicacoes(int x) {
        dadosProjetos[x][13] = input.nextLine();
        return;
    }
}
