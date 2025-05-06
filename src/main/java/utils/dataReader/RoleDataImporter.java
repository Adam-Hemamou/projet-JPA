package utils.dataReader;

import entities.RoleId;
import services.RoleService;
import entities.Role;
import utils.parser.RoleParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoleDataImporter {

    private final RoleService roleService;

    public RoleDataImporter(RoleService roleService) {
        this.roleService = roleService;
    }

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

