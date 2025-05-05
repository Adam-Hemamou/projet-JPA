package utils.parser;

import entities.Pays;
import services.PaysService;

public class PaysParser {

    private static PaysService paysService;

    public PaysParser(PaysService paysService) {
        PaysParser.paysService = paysService;
    }

    public static void setPaysService(PaysService paysService) {
        PaysParser.paysService = paysService;
    }

    public static Pays parse(String nom) {
        return paysService.findByNom(nom).orElseGet(() -> {
            Pays pays = new Pays();
            pays.setNom(nom.trim());
            return pays;
        });
    }
}