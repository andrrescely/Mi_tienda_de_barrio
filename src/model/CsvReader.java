package model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<String[]> leerArchivoCsv(String rutaArchivo) throws IOException {
        List<String[]> registros = new ArrayList<>();

        try (Reader reader = new FileReader(rutaArchivo);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {
                String[] datos = new String[record.size()];
                for (int i = 0; i < record.size(); i++) {
                    datos[i] = record.get(i);
                }
                registros.add(datos);
            }
        }

        return registros;
    }
}
