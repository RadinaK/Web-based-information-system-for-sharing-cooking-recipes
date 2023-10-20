package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.entities.BaseEntity;
import bg.tuplovdiv.cookingrecipes.domain.entities.UserRole;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<UserRole> roles;

    @Column
    private String fullName;

    @Column
    private Integer age;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setRoles(Set<UserRole> roles) {
        this.roles = roles;
        return this;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
