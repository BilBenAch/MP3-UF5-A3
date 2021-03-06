package model;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import control.RegistreUFCControl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class OpenCSV {
    CsvToBean<NomColumnesUFC> nomColumnesUFCS;
    static String fileName = "c:\\Users\\bilal\\Desktop\\allUFCfightsclean.csv";


    public OpenCSV() {
        this.nomColumnesUFCS = LeerCsv();

    }


    public CsvToBean<NomColumnesUFC> LeerCsv() {
        System.out.println("reading CSV");
        BufferedReader in = null;
        CSVReader reader = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            reader = new CSVReader(in);
            System.out.println("entro");
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<NomColumnesUFC> nomColumnesUFCS = new CsvToBeanBuilder(reader)
                .withType(NomColumnesUFC.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return nomColumnesUFCS;
    }

    public List<NomColumnesUFC> lista() {
        return nomColumnesUFCS.stream().collect(Collectors.toList());
    }
}

