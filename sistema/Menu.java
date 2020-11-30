package sistema;

import java.util.Scanner;
import sistema.Pessoas;
import sistema.Laboratorio;

public class Menu {
    public Scanner input = new Scanner(System.in);
    Pessoas colabora = new Pessoas();
    Laboratorio lab = new Laboratorio();

    public void start() {
        System.out.println("Digite a opcao que deseja para acessar no laboratorio:\n [1] Colaboradores\n [2] Projetos\n [3] Relatorios dos laboratorios\n [4] Sair");
        int option = input.nextInt();
        switch(option) {
            case 1:
                colabora.colaboradores();
                start();
            case 2:
                lab.projetos();
                start();
            //case 3:

            case 4:
                System.exit(0);
        }
    }
}
