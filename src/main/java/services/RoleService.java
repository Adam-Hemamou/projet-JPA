package services;

import AbstractClass.GenericService;
import DAO.RoleDAO;
import entities.Role;
import entities.RoleId;

public class RoleService extends GenericService<Role, RoleId> {
    public RoleService(RoleDAO roleDAO) {
        super(roleDAO);
    }
}
