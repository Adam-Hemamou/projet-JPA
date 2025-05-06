package utils.dataReader;

import services.ActeurService;
import entities.Acteur;
import services.LieuNaissanceService;
import utils.parser.ActeurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActeurDataImporter {

    private final ActeurService acteurService;
    private final ActeurParser acteurParser;

    public ActeurDataImporter(ActeurService acteurService, LieuNaissanceService lieuNaissanceService) {
        this.acteurService = acteurService;
        this.acteurParser = new ActeurParser(acteurService, lieuNaissanceService);
    }

    public void importActeursFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
                Acteur acteur = acteurParser.parse(record);
                if (acteurService.findById(acteur.getId()).isEmpty()) {
                    acteurService.save(acteur);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

