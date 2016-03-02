import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/recipe_collection_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String recipesDeleteQuery = "DELETE FROM recipes *";
      String recipeIngredientsDeleteQuery = "DELETE FROM recipe_ingredients *";
      String recipeTagsDeleteQuery = "DELETE FROM recipe_tags *";
      String ingredientsDeleteQuery = "DELETE FROM ingredients *";
      String tagsDeleteQuery = "DELETE FROM tags *";
      con.createQuery(recipesDeleteQuery).executeUpdate();
      con.createQuery(recipeIngredientsDeleteQuery).executeUpdate();
      con.createQuery(recipeTagsDeleteQuery).executeUpdate();
      con.createQuery(ingredientsDeleteQuery).executeUpdate();
      con.createQuery(tagsDeleteQuery).executeUpdate();
    }
  }
}
