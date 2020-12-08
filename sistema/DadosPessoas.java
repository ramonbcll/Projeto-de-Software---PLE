package sistema;

import java.util.Scanner;

public class DadosPessoas {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosPessoas = new String[20][5];
    public static int total = 0;
    public String nome;
    public String email;
    public String cargo;

    public String getInfo(int x, int y) {
        return dadosPessoas[x][y];
    }
    public void setInfo(int x, int y) {
        dadosPessoas[x][y] = input.nextLine();
    }
    public int qtdePessoas() {
        return total;
    }
    public void setPessoas() {
        total += 1;
    }
    public void setProjetoPessoa(int x, String projeto) {
        if(getInfo(x, 3) == null) {
            dadosPessoas[x][3] = projeto;
        }
        else {
            dadosPessoas[x][4] = projeto;
        }
    }
}
