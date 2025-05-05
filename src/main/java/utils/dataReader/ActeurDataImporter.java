package utils.dataReader;

import services.ActeurService;
import entities.Acteur;
import utils.parser.ActeurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActeurDataImporter {

    private final ActeurService acteurService;

    public ActeurDataImporter(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    public void importActeursFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                Acteur acteur = ActeurParser.parse(record);
                if (acteurService.findById(acteur.getId()).isEmpty()) {
                    acteurService.save(acteur);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

