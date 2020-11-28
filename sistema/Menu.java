package sistema;

import java.util.Scanner;
import sistema.Pessoas;

public class Menu {
    public Scanner input = new Scanner(System.in);
    Pessoas colabora = new Pessoas();

    public void start() {
        System.out.println("Digite a opção que deseja para navegar no laboratório:\n 1- Colaboradores\n 2- Projetos\n 3- Relatórios dos laboratórios\n 4- Sair");
        int option = input.nextInt();
        switch(option) {
            case 1:
                colabora.colaboradores();
                start();
            //case 2:

            //case 3:

            case 4:
                System.exit(0);
        }
    }
}
