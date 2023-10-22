package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

import java.util.Set;

public class UserModel {
    private Long id; // –  username of the user.
    private String username; // –  username of the user.
    private String password; //– password of the user.
    private String email;
    private String fullName;
    private Set<UserRoleModel> role; //–  user's role (User or Admin).
    private Integer age;

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Set<UserRoleModel> getRole() {
        return role;
    }

    public UserModel setRole(Set<UserRoleModel> role) {
        this.role = role;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public boolean isValid() {
        return this.id != null;
    }
}
