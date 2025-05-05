package services;

import AbstractClass.GenericService;
import DAO.LieuTournageDAO;
import entities.LieuTournage;

public class LieuTournageService extends GenericService<LieuTournage, Long> {
    LieuTournageService(LieuTournageDAO lieuTournageDAO) {
        super(lieuTournageDAO);
    }
}
