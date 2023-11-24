package bg.tuplovdiv.cookingrecipes.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String mimeType;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picture_bytes",columnDefinition = "LONGBLOB")
    private byte[] pictureBytes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    public Picture() {
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(byte[] pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Picture setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }
}

