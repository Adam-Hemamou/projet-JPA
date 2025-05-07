package utils.dataReader;

import services.PaysService;
import entities.Pays;
import utils.parser.PaysParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire pour importer des données de pays à partir d'un fichier CSV.
 */
public class PaysDataImporter {

    private final PaysService paysService;

    /**
     * Constructeur pour initialiser le service nécessaire.
     *
     * @param paysService le service pour gérer les opérations CRUD des pays
     */
    public PaysDataImporter(PaysService paysService) {
        this.paysService = paysService;
    }

    /**
     * Importe les pays à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, analyse les données et enregistre les pays dans la base de données.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
    public void importPaysFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
                Pays pays = PaysParser.parseFromCSV(record);
                if (paysService.findByNom(pays.getNom()).isEmpty()) {
                    paysService.save(pays);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
