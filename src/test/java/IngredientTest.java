import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class IngredientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void ingredient_instantiatesCorrectly_true() {
    Ingredient testIngredient = new Ingredient("Love");
    assertEquals(true, testIngredient instanceof Ingredient);
    assertEquals("Love", testIngredient.getName());
    assertEquals(Ingredient.all().size(), testIngredient.getId());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Ingredient.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    Ingredient firstIngredient = new Ingredient("Onions");
    Ingredient secondIngredient = new Ingredient("Onions");
    assertTrue(firstIngredient.equals(secondIngredient));
  }

  @Test
  public void equals_returnsTrueIfSavedIngredientsAretheSame() {
    Ingredient testIngredient = new Ingredient("Love");
    testIngredient.save();
    assertTrue(Ingredient.all().get(0).equals(testIngredient));
  }

  @Test
  public void save_assignsIdToObject() {
    Ingredient testIngredient = new Ingredient("Love");
    testIngredient.save();
    Ingredient savedIngredient = Ingredient.all().get(0);
    assertEquals(testIngredient.getId(), savedIngredient.getId());
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Ingredient testIngredient = new Ingredient("Love");
    testIngredient.save();
    assertEquals(Ingredient.all().get(0).getName(), "Love");
  }

  @Test
  public void find_findsIngredientInDatabase_true() {
    Ingredient testIngredient = new Ingredient("Love");
    testIngredient.save();
    Ingredient savedIngredient = Ingredient.find(testIngredient.getId());
    assertEquals(savedIngredient.getName(), "Love");
  }

  @Test
  public void all_returnsAllInstancesOfIngredient_true() {
    Ingredient firstIngredient = new Ingredient("Love");
    Ingredient secondIngredient = new Ingredient("Chili Powder");
    firstIngredient.save();
    secondIngredient.save();
    assertTrue(Ingredient.all().contains(firstIngredient));
    assertTrue(Ingredient.all().contains(secondIngredient));
  }

  @Test
  public void find_returnsIngredientWithSameId_secondIngredient() {
    Ingredient firstIngredient = new Ingredient("Love");
    Ingredient secondIngredient = new Ingredient("Chili Powder");
    firstIngredient.save();
    secondIngredient.save();
    assertEquals(Ingredient.find(secondIngredient.getId()), secondIngredient);
  }

  @Test
  public void find_returnsNullWhenNoIngredientFound_null() {
    assertTrue(Ingredient.find(999) == null);
  }

  @Test
  public void delete_deleteDeletesIngredient() {
    Ingredient myIngredient = new Ingredient("Love");
    myIngredient.save();
    myIngredient.delete();
    assertEquals(Ingredient.all().size(), 0);
  }
  //TESTS TO BE USED AFTER RECIPE CLASS IS SET UP
  // @Test
  // public void addRecipe_addsRecipeForIngredient() {
  //   Recipe myRecipe = new Recipe(????);
  //   myRecipe.save();
  //
  //   Ingredient myIngredient = new Ingredient("Love");
  //   myIngredient.save();
  //
  //   myIngredient.addRecipe(myRecipe);

  //   Recipe savedRecipe = myIngredient.getRecipes().get(0);
  //   assertTrue(myRecipe.equals(savedRecipe));
  // }
  //
  // @Test
  // public void getRecipes_returnsRecipesThatUseIngredient_List() {
  //   Recipe myRecipe = new Recipe(????);
  //   myRecipe.save();
  //
  //   Ingredient myIngredient = new Ingredient("Love");
  //   myIngredient.save();
  //
  //   myIngredient.addRecipe(myRecipe);

  //   List<Recipe> savedRecipes = myIngredient.getRecipes();
  //   assertEquals(savedRecipe.size(), 1);
  // }
}
