package model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class NomColumnesUFC {
    @CsvBindByName
    String id;
    @CsvBindByName
    String fighter1;
    @CsvBindByName
    String fighter2;
    @CsvBindByName
    String method;
    @CsvBindByName
    String date;
    @CsvBindByName
    String event;
    @CsvBindByName
    String weight;



}
