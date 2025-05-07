package utils.dataReader;

import entities.RoleId;
import services.RoleService;
import entities.Role;
import utils.parser.RoleParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire pour importer des données de rôles à partir d'un fichier CSV.
 */
public class RoleDataImporter {

    private final RoleService roleService;

    /**
     * Constructeur pour initialiser le service nécessaire.
     *
     * @param roleService le service pour gérer les opérations CRUD des rôles
     */
    public RoleDataImporter(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Importe les rôles à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, analyse les données et enregistre les rôles dans la base de données.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
    public void importRolesFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
                Role role = RoleParser.parse(record);

                RoleId roleId = new RoleId(role.getFilm().getId(), role.getActeur().getId());
                if (roleService.findById(roleId).isEmpty()) {
                    roleService.save(role);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

