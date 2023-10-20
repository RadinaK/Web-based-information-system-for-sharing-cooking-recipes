package bg.tuplovdiv.cookingrecipes.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

//    @Column(name = "order_number")
//    private Integer orderNumber;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    private Recipe recipe;

    public Picture() {
    }

//    public int getOrder() {
//        return orderNumber;
//    }
//
//    public Picture setOrder(int orderNumber) {
//        this.orderNumber = orderNumber;
//        return this;
//    }

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Picture setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }
}

