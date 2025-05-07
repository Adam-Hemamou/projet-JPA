package services;

import AbstractClass.GenericService;
import DAO.RoleDAO;
import entities.Role;
import entities.RoleId;

import java.util.Optional;


/**
 * Service pour les opérations CRUD sur les entités Role.
 */
public class RoleService extends GenericService<Role, RoleId> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param roleDAO le DAO à utiliser pour les opérations de base de données de la table Role
     */
    public RoleService(RoleDAO roleDAO) {
        super(roleDAO);
    }

    /**
     * Trouve un rôle par son identifiant composite.
     *
     * @param roleId l'identifiant composite du rôle
     * @return un Optional contenant le rôle trouvé ou vide s'il n'existe pas
     */
    public Optional<Role> findById(RoleId roleId) {
        return super.findById(roleId);
    }
}
