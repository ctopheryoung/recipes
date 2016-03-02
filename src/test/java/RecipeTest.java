import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class RecipeTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // @Test
  // public void all_emptyAtFirst() {
  //   assertEquals(Recipe.all().size(), 0);
  // }
  //
  // @Test
  // public void equals_returnsTrueIfNamesAreTheSame() {
  //   Recipe firstRecipe = new Recipe("Spicy");
  //   Recipe secondRecipe = new Recipe("Spicy");
  //   assertTrue(firstRecipe.equals(secondRecipe));
  // }
}
