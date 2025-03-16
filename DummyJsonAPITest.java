package newAss;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class DummyJsonAPITest {

    private static final String BASE_URL = "https://dummyjson.com/recipes";

    // Task 1: Fetch All Recipes
    @Test
    public void testFetchAllRecipes() {
        Response response = given()
                                .when()
                                .get(BASE_URL)
                                .then()
                                .statusCode(200)
                                .contentType(ContentType.JSON)
                                .extract()
                                .response();

        // Extract first recipe details
        String firstRecipeTitle = response.jsonPath().getString("recipes[0].name");
        String firstRecipeIngredients = response.jsonPath().getString("recipes[0].ingredients");
        String firstRecipeInstructions = response.jsonPath().getString("recipes[0].instructions");

        System.out.println("First Recipe Title: " + firstRecipeTitle);
        System.out.println("Ingredients: " + firstRecipeIngredients);
        System.out.println("Instructions: " + firstRecipeInstructions);
    }

    // Task 2: Fetch a Single Recipe by ID
    @Test
    public void testFetchSingleRecipe() {
        int recipeId = 1;
        
        given()
            .when()
            .get(BASE_URL + "/" + recipeId)
            .then()
            .statusCode(200)
            .body("id", equalTo(recipeId))
            .body("name", notNullValue()); // Validate recipe name exists
    }

    // Task 3: Search Recipes by Name (Keyword: "chicken")
    @Test
    public void testSearchRecipes() {
        given()
            .queryParam("q", "chicken")
            .when()
            .get(BASE_URL + "/search")
            .then()
            .statusCode(200)
            .body("recipes.size()", greaterThan(0))
            .body("recipes[0].name", containsStringIgnoringCase("chicken"));
    }

   
}
