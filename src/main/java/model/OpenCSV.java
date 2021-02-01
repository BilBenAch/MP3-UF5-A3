package model;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class OpenCSV {
    private final List<NomColumnesUFC> fighters;
    static String fileName = "c:\\Users\\bilal\\Desktop\\allUFCfightsclean.csv";

    public OpenCSV() {
        this.fighters = LeerCsv();
    }

    public List<NomColumnesUFC> LeerCsv() {
        BufferedReader in;
        CSVReader reader = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            reader = new CSVReader(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (List<NomColumnesUFC>) new CsvToBeanBuilder(reader)
                .withType(NomColumnesUFC.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .stream()
                .collect(Collectors.toList());
    }

    public List<NomColumnesUFC> lista() {
        return fighters;
    }
}
