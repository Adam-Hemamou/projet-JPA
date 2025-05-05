package utils.dataReader;

import services.PaysService;
import entities.Pays;
import utils.parser.PaysParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PaysDataImporter {

    private final PaysService paysService;

    public PaysDataImporter(PaysService paysService) {
        this.paysService = paysService;
    }

    public void importPaysFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                Pays pays = PaysParser.parseFromCSV(record);
                if (paysService.findById(pays.getId()).isEmpty()) {
                    paysService.save(pays);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
