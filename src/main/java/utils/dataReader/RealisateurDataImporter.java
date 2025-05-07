package utils.dataReader;

import services.LieuNaissanceService;
import services.RealisateurService;
import entities.Realisateur;
import utils.parser.RealisateurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire pour importer des données de réalisateurs à partir d'un fichier CSV.
 */
public class RealisateurDataImporter {

    private final RealisateurService realisateurService;
    private final RealisateurParser realisateurParser;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param realisateurService le service pour gérer les opérations CRUD des réalisateurs
     * @param lieuNaissanceService le service pour gérer les lieux de naissance
     */
    public RealisateurDataImporter(RealisateurService realisateurService, LieuNaissanceService lieuNaissanceService) {
        this.realisateurService = realisateurService;
        this.realisateurParser = new RealisateurParser(lieuNaissanceService);
    }

    /**
     * Importe les réalisateurs à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, analyse les données et enregistre les réalisateurs dans la base de données.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
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

