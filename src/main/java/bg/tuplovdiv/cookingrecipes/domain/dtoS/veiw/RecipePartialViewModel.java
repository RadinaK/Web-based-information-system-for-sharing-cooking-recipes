package bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw;

import bg.tuplovdiv.cookingrecipes.domain.entities.Picture;
import bg.tuplovdiv.cookingrecipes.domain.entities.Recipe;

public class RecipePartialViewModel {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public RecipePartialViewModel() {
    }

    public RecipePartialViewModel(Long id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public RecipePartialViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public RecipePartialViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public RecipePartialViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static RecipePartialViewModel fromRecipe(Recipe recipe) {
        return new RecipePartialViewModel(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                recipe.getPictures()
                        .stream()
                        .findFirst()
                        .orElse(new Picture()
                                .setUrl("http://res.cloudinary.com/ch-cloud/image/upload/v1630584095/aznlgfzoxpuvl5belukb.jpg"))
                        .getUrl());
    }
}
