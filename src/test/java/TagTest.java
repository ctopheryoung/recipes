import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class TagTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Tag.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    Tag firstTag = new Tag("Spicy");
    Tag secondTag = new Tag("Spicy");
    assertTrue(firstTag.equals(secondTag));
  }

  @Test
  public void equals_returnsTrueIfSavedTagsAretheSame() {
    Tag testTag = new Tag("Spicy");
    testTag.save();
    assertTrue(Tag.all().get(0).equals(testTag));
  }

  @Test
  public void save_assignsIdToObject() {
    Tag testTag = new Tag("Spicy");
    testTag.save();
    Tag savedTag = Tag.all().get(0);
    assertEquals(testTag.getId(), savedTag.getId());
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Tag myTag = new Tag("Spicy");
    myTag.save();
    assertEquals(Tag.all().get(0).getName(), "Spicy");
  }
}
