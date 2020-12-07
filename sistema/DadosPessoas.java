package sistema;

import java.util.Scanner;

public class DadosPessoas {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosPessoas = new String[20][8];
    public static int total = 0;

    public String infoPessoas(int x, int y) {
        return dadosPessoas[x][y];
    }
    public void setInfo(int x, int y) {
        dadosPessoas[x][y] = input.nextLine();
        return;
    }
    public int qtdePessoas() {
        return total;
    }
    public void setPessoas() {
        total += 1;
        return;
    }
    public void setProjetoPessoa(int x, String projeto) {
        if(infoPessoas(x, 6) == null) {
            dadosPessoas[x][6] = projeto;
        }
        else {
            dadosPessoas[x][7] = projeto;
        }
    }
}
