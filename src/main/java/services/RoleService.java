package services;

import AbstractClass.GenericService;
import DAO.RoleDAO;
import entities.Role;
import entities.RoleId;

import java.util.Optional;

public class RoleService extends GenericService<Role, RoleId> {
    public RoleService(RoleDAO roleDAO) {
        super(roleDAO);
    }

    public Optional<Role> findById(RoleId roleId) {
        return super.findById(roleId);
    }
}
