package bg.tuplovdiv.cookingrecipes.domain.beans;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.UserRoleModel;

import java.util.List;

public class LoggedUser {
    private Long id;
    private String username;
    private List<UserRoleModel> roleModels;


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

    public List<UserRoleModel> getRoleModels() {
        return roleModels;
    }

    public LoggedUser setRoleModels(List<UserRoleModel> roleModels) {
        this.roleModels = roleModels;
        return this;
    }

    public void clearFields() {
        this.id = null;
        this.username = null;
        this.roleModels = null;
    }
}
