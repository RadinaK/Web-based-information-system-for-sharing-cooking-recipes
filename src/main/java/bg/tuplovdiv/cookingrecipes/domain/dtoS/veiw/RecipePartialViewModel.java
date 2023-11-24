package bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw;

import bg.tuplovdiv.cookingrecipes.domain.entities.Picture;
import bg.tuplovdiv.cookingrecipes.domain.entities.Recipe;

import java.io.IOException;
import java.util.Base64;

public class RecipePartialViewModel {
    private Long id;
    private String name;
    private String description;
    private String imageBytes;

    private String imageType;

    public RecipePartialViewModel() {
    }

    public RecipePartialViewModel(Long id, String name, String description, String imageBytes, String imageType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageBytes = imageBytes;
        this.imageType = imageType;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(String imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public static RecipePartialViewModel fromRecipe(Recipe recipe) {

        Picture placeholderPicture = new Picture();
        try {
            placeholderPicture.setPictureBytes(RecipePartialViewModel.class.getClassLoader()
                    .getResourceAsStream("static/images/recipe-placeholder.jpg").readAllBytes());
            placeholderPicture.setMimeType("image/jpeg");
            placeholderPicture.setRecipe(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RecipePartialViewModel(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                Base64.getEncoder().encodeToString(recipe.getPictures()
                        .stream()
                        .findFirst()
                        .orElse(placeholderPicture).getPictureBytes()),
                recipe.getPictures()
                        .stream()
                        .findFirst()
                        .orElse(placeholderPicture).getMimeType()
        );
    }
}
