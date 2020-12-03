package sistema;

import java.util.Scanner;

public class DadosProjeto {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosProjetos = new String[20][11];

    public String infoProjetos(int x, int y) {
        return dadosProjetos[x][y];
    }
    public void addInfo(int x, int y) {
        dadosProjetos[x][y] = input.nextLine();
        return;
    }
    public void alterarStatus(int x, int y) {
        dadosProjetos[x][y] = "Em andamento";
        return;
    }
    public void addColaborador(int x, int y, String nome) {
        dadosProjetos[x][y] = nome;
    }
}
