<script>
    function addIngredient() {
        var form = document.getElementById("recipeForm");
        var formData = new FormData(form);
        formData.append("recipeIngredientList", "");

        fetch("/addIngredient", {
            method: "POST",
            body: formData,
        })
            .then((response) => response.text())
            .then((data) => {
                document.getElementById("recipeIngredientsTable").innerHTML = data;
            });
    }

    // This code assumes you're using AJAX to update the ingredients table.
    // You can also use Thymeleaf fragments for a non-AJAX approach.
</script>