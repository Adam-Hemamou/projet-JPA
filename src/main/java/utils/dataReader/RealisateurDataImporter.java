package utils.dataReader;

import services.LieuNaissanceService;
import services.RealisateurService;
import entities.Realisateur;
import utils.parser.RealisateurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RealisateurDataImporter {

    private final RealisateurService realisateurService;
    private final RealisateurParser realisateurParser;

    public RealisateurDataImporter(RealisateurService realisateurService, LieuNaissanceService lieuNaissanceService) {
        this.realisateurService = realisateurService;
        this.realisateurParser = new RealisateurParser(lieuNaissanceService);
    }

    public void importRealisateursFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
                Realisateur realisateur = realisateurParser.parse(record);
                if (realisateurService.findById(realisateur.getId()).isEmpty()) {
                    realisateurService.save(realisateur);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

