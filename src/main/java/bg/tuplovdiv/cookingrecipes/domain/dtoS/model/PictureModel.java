package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

public class PictureModel {
    private Long id;
    //    private String title;
    private String url;
    private RecipeModel recipe;

    public PictureModel() {
    }

    public Long getId() {
        return id;
    }

    public PictureModel setId(Long id) {
        this.id = id;
        return this;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public PictureModel setTitle(String title) {
//        this.title = title;
//        return this;
//    }

    public String getUrl() {
        return url;
    }

    public PictureModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public RecipeModel getRecipe() {
        return recipe;
    }

    public PictureModel setRecipe(RecipeModel recipe) {
        this.recipe = recipe;
        return this;
    }
}
