package sistema;

import java.util.Scanner;

public class DadosPessoas {
    public static Scanner input = new Scanner(System.in);
    public static String[][] dadosPessoas = new String[20][7];

    public String infoPessoas(int x, int y) {
        return dadosPessoas[x][y];
    }
    public void addInfo(int x, int y) {
        dadosPessoas[x][y] = input.nextLine();
        return;
    }
}
