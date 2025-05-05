package services;

import AbstractClass.GenericService;
import DAO.LieuNaissanceDAO;
import entities.LieuNaissance;

public class LieuNaissanceService  extends GenericService<LieuNaissance, Long> {
    public LieuNaissanceService(LieuNaissanceDAO lieuNaissanceDAO) {
        super(lieuNaissanceDAO);
    }
}
