package bg.tuplovdiv.cookingrecipes.helpers;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.UserRoleModel;
import bg.tuplovdiv.cookingrecipes.domain.enums.Role;

import java.util.Set;

public class LoggedUser {
    private Long id;
    private String username;
    private Set<UserRoleModel> roleModels;


    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<UserRoleModel> getRoleModels() {
        return roleModels;
    }

    public LoggedUser setRoleModels(Set<UserRoleModel> roleModels) {
        this.roleModels = roleModels;
        return this;
    }

    public void clearFields() {
        this.id = null;
        this.username = null;
        this.roleModels = null;
    }

    public Boolean isAdmin() {
        return roleModels.stream().anyMatch(roleModel -> roleModel.getRole().equals(Role.ADMIN));
    }
}
