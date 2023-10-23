package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

import bg.tuplovdiv.cookingrecipes.domain.enums.Role;

public class UserRoleModel {
    private Long id;
    private Role role;

    public UserRoleModel() {
    }

    public Long getId() {
        return id;
    }

    public UserRoleModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRoleModel setRole(Role role) {
        this.role = role;
        return this;
    }
}
