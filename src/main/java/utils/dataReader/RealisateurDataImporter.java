package utils.dataReader;

import services.RealisateurService;
import entities.Realisateur;
import utils.parser.RealisateurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RealisateurDataImporter {

    private final RealisateurService realisateurService;

    public RealisateurDataImporter(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    public void importRealisateursFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                Realisateur realisateur = RealisateurParser.parse(record);
                if (realisateurService.findById(realisateur.getId()).isEmpty()) {
                    realisateurService.save(realisateur);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

