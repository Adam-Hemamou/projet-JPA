package utils.dataReader;

import services.ActeurService;
import entities.Acteur;
import services.LieuNaissanceService;
import utils.parser.ActeurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire pour importer des données d'acteurs à partir d'un fichier CSV.
 */
public class ActeurDataImporter {

    private final ActeurService acteurService;
    private final ActeurParser acteurParser;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param acteurService le service pour gérer les opérations CRUD des acteurs
     * @param lieuNaissanceService le service pour gérer les lieux de naissance
     */
    public ActeurDataImporter(ActeurService acteurService, LieuNaissanceService lieuNaissanceService) {
        this.acteurService = acteurService;
        this.acteurParser = new ActeurParser(acteurService, lieuNaissanceService);
    }

    /**
     * Importe les acteurs à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, analyse les données et enregistre les acteurs dans la base de données.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
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

