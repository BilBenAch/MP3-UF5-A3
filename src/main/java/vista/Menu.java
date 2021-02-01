package vista;

import control.RegistreUFCControl;

import java.util.Scanner;

public class Menu {
    RegistreUFCControl registreUFCControl;

    public Menu(RegistreUFCControl registreUFCControl) {
        this.registreUFCControl = registreUFCControl;

    }

    public void startMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 8) {

            System.out.println();
            System.out.println("Benvingut a l'enciclopèdia de la UFC");
            System.out.println("QUE VOLS SABER?");
            System.out.println("1-Históric de lluites amb el resultat segons el segons la seva categoria de pes ordenada");
            System.out.println("2-Veure el registre de lluites d'un lluitador pel seu nom (ordenades per data)");
            System.out.println("3-Numero de vegades que ha lluitat un lluitador");
            System.out.println("4-Lluitador amb més lluites");
            System.out.println("5-Veure lluitador amb menys lluites ");
            System.out.println("6-Veure un event segons la data introduida format exemple (Apr 7, 2018)");
            System.out.println("7-Events amb el resultat d'una categoría de pes en concret");
            System.out.println("8-Soritr");
            System.out.println();

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    registreUFCControl.lluitadorsSegonsPes();
                    break;
                case 2:
                    registreUFCControl.registreLluitesLluitador();
                    break;
                case 3:
                    registreUFCControl.numeroVegadesLLuites();
                    break;
                case 4:
                    registreUFCControl.mesVegades();
                    break;
                case 5:
                    registreUFCControl.menysVegades();
                    break;
                case 6:
                    registreUFCControl.veureEventsSegonsData();
                    break;
                case 7:
                    registreUFCControl.veureContingutComplet();
                    break;
                case 8:
                    System.out.println("Adéu");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }

        }
    }
}
