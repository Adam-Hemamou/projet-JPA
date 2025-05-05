package utils.parser;

import entities.Pays;

public class PaysParser {

    public static Pays parse(String nom) {
        Pays pays = new Pays();
        pays.setNom(nom.trim());
        return pays;
    }

    public static Pays parseFromCSV(String[] record) {
        Pays pays = new Pays();
        pays.setNom(record[0].trim());
        pays.setUrl(record[1].trim());
        return pays;
    }
}
