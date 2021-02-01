package control;

import com.opencsv.bean.CsvToBean;
import model.NomColumnesUFC;
import model.OpenCSV;
import org.apache.commons.collections4.MultiSet;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RegistreUFCControl {
    OpenCSV openCSV;
    List<String> nomlluitadors;
    Scanner sc = new Scanner(System.in);

    public RegistreUFCControl(OpenCSV openCSV) {

        this.openCSV = openCSV;
    }

    public void lluitadorsSegonsPes() {
        int opcion;
        boolean trovat = false;
        String valor = null;

        System.out.println("De quin pes vols saber els lluitadors?");
        System.out.println("1- Pes mínim");
        System.out.println("2- Pes mosca");
        System.out.println("3- Pes gall");
        System.out.println("4- Pes ploma");
        System.out.println("5- Pes lleuger");
        System.out.println("6- Pes welter");
        System.out.println("7- Pes mijtà");
        System.out.println("8- Pes semi-pesat");
        System.out.println("9- Pes pesat");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                trovat = true;
                valor = "Strawweight";

                break;
            case 2:
                trovat = true;
                valor = "Flyweight";
                break;
            case 3:
                trovat = true;
                valor = "Bantamweight";
                break;
            case 4:
                trovat = true;
                valor = "Featherweight";
                break;
            case 5:
                trovat = true;
                valor = "Lightweight";
                break;
            case 6:
                trovat = true;
                valor = "Welterweight";
                break;
            case 7:
                trovat = true;
                valor = "Middleweight";
                break;
            case 8:
                trovat = true;
                valor = "Light Heavyweight";
                break;
            case 9:
                trovat = true;
                valor = "Heavyweight";
                break;
            default:
                System.out.println("No existeix aquest pes");
        }
        if (trovat) {

            String finalValor = valor;


            nomlluitadors = openCSV.lista().
                    stream().filter(nomColumnesUFC -> nomColumnesUFC.getWeight().
                    contains(finalValor))
                    .map(fighter -> "W " + fighter
                            .getFighter1() + "VS " + "L " + fighter
                            .getFighter2() + " Resultat ----> " + fighter.getMethod())
                    .sorted()
                    .distinct()
                    .collect(toList());
            nomlluitadors.forEach(System.out::println);

        }

        System.out.println();
    }


    public void registreLluitesLluitador() {
        System.out.println("Introdueix el nom y el cognom del lluitador del cual vols saber el registre de lluites");
        String nom = sc.nextLine();

        nomlluitadors = openCSV.lista().stream().
                filter(row -> row.getFighter1()
                        .equalsIgnoreCase(nom) ||
                        row.getFighter2()
                                .equalsIgnoreCase(nom))
                .map(NomColumnesUFC::toString)
                .sorted(String::lastIndexOf)
                .distinct().collect(toList());
        nomlluitadors.forEach(System.out::println);


    }


    public void numeroVegadesLLuites() {
        System.out.println("Introdueix el nom y el cognom del lluitador del cual vols saber el registre de lluites");
        String nom = sc.nextLine();
        long cunt = openCSV.lista().stream().
                filter(row -> row
                        .getFighter1().equalsIgnoreCase(nom) ||
                        row.getFighter2().equalsIgnoreCase(nom))
                .count();
        System.out.println("El lluitador que has sel.leccionat te un total de " + cunt + " lluites en la UFC");
    }


    public void mesVegades() {


        String mesVegades = openCSV.lista().stream()

                .filter(it -> Objects.nonNull(it.getFighter1()))

                .collect(Collectors.groupingBy(NomColumnesUFC::getFighter2, Collectors.counting()))

                .entrySet().stream().max(Map.Entry.comparingByValue())

                .map(Map.Entry::getKey).orElse(null);

        System.out.println("El lluitador que ha lluitat mes a l'UFC es " + mesVegades);

    }

    public void menysVegades() {

        String menysVegades = openCSV.lista().stream()

                .filter(it -> Objects.nonNull(it.getFighter1()))

                .collect(Collectors.groupingBy(NomColumnesUFC::getFighter2, Collectors.counting()))

                .entrySet().stream().min(Map.Entry.comparingByValue())

                .map(Map.Entry::getKey).orElse(null);

        System.out.println("El lluitador que ha lluitat mes a l'UFC es " + menysVegades);
    }

    public void veureEventsSegonsData() {
        System.out.println("Introdueix la data de l'event format (Apr 7, 2018)");
        String data = sc.nextLine();


        nomlluitadors = openCSV.lista().stream().
                filter(row -> row.getDate().equalsIgnoreCase(data))
                .map(NomColumnesUFC::toString)
                .sorted(String::lastIndexOf)
                .distinct().collect(toList());
        nomlluitadors.forEach(System.out::println);

    }

    public void veureContingutComplet() {

        nomlluitadors = openCSV.lista()
                .stream()
                .map(NomColumnesUFC::toString)
                .collect(toList());
        nomlluitadors.forEach(System.out::println);
    }
}

