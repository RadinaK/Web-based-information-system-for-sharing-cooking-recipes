<script>
    function addIngredient() {
        var form = document.getElementById("recipeIngredientAddForm");
        var formData = new FormData(form);
        formData.append("recipeIngredientList", "");

        fetch("/addRecipeIngredient", {
            method: "POST",
            body: formData,
        })
            .then((response) => response.text())
            .then((data) => {
                document.getElementById("recipes_ingredients").innerHTML = data;
            });
    }

    // This code assumes you're using AJAX to update the ingredients table.
    // You can also use Thymeleaf fragments for a non-AJAX approach.
</script>