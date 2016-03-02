import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class IngredientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

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
    Ingredient myIngredient = new Ingredient("Love");
    myIngredient.save();
    assertEquals(Ingredient.all().get(0).getName(), "Love");
  }

 //  @Test
 //  public void find_findsIngredientInDatabase_true() {
 //    Ingredient myIngredient = new Ingredient("Love");
 //    myIngredient.save();
 //    Ingredient savedIngredient = Ingredient.find(myIngredient.getId());
 //    assertEquals(savedIngredient.getName(), "Love");
 //  }
 //
 //  @Test
 //  public void student_instantiatesCorrectly_true() {
 //    Ingredient myIngredient = new Ingredient("Love");
 //    assertEquals(true, myIngredient instanceof Ingredient);
 //  }
 //
 //  @Test
 // public void student_instantiatesWithName_true() {
 //   Ingredient myIngredient = new Ingredient("Love");
 //   assertEquals("Love", myIngredient.getName());
 // }
 //
 // @Test
 // public void all_returnsAllInstancesOfIngredient_true() {
 //    Ingredient firstIngredient = new Ingredient("Love");
 //    Ingredient secondIngredient = new Ingredient("The Brawler");
 //    firstIngredient.save();
 //    secondIngredient.save();
 //    assertTrue(Ingredient.all().contains(firstIngredient));
 //    assertTrue(Ingredient.all().contains(secondIngredient));
 // }
 //
 // @Test
 //  public void newId_studentInstantiateWithAnID_true() {
 //    Ingredient myIngredient = new Ingredient("Love");
 //    assertEquals(Ingredient.all().size(), myIngredient.getId());
 //  }
 //
 //  @Test
 //  public void find_returnsIngredientWithSameId_secondIngredient() {
 //    Ingredient firstIngredient = new Ingredient("Love");
 //    Ingredient secondIngredient = new Ingredient("The Brawler");
 //    firstIngredient.save();
 //    secondIngredient.save();
 //    assertEquals(Ingredient.find(secondIngredient.getId()), secondIngredient);
 //  }
 //
 //  @Test
 //  public void find_returnsNullWhenNoIngredientFound_null() {
 //    assertTrue(Ingredient.find(999) == null);
 //  }
 //
 //   @Test
 //   public void delete_deleteDeletesIngredient() {
 //     Ingredient myIngredient = new Ingredient("Love");
 //     myIngredient.save();
 //     myIngredient.delete();
 //     assertEquals(Ingredient.all().size(), 0);
 //   }
 //
 //  @Test
 //  public void addCourse_addsCourseForIngredient() {
 //    Course myCourse = new Course("Intro to Brawling", "BRWL101");
 //    myCourse.save();
 //
 //    Ingredient myIngredient = new Ingredient("Love");
 //    myIngredient.save();
 //
 //    myIngredient.addCourse(myCourse);
 //    Course savedCourse = myIngredient.getCourses().get(0);
 //    assertTrue(myCourse.equals(savedCourse));
 //  }
 //
 //  @Test
 //  public void getCourses_returnsAllCourses_ArrayList() {
 //    Course myCourse = new Course("Intro to Brawling", "BRWL101");
 //    myCourse.save();
 //
 //    Ingredient myIngredient = new Ingredient("Love");
 //    myIngredient.save();
 //
 //    myIngredient.addCourse(myCourse);
 //    List<Course> savedCourse = myIngredient.getCourses();
 //    assertEquals(savedCourse.size(), 1);
 //  }

}
