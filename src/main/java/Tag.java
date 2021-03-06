import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Tag {
  private int id;
  private String name;

  //CONSTRUCTOR
  public Tag(String name) {
    this.name = name;
  }

  //OVERRIDE FOR EQUALS METHOD
  @Override
  public boolean equals(Object otherTag){
    if (!(otherTag instanceof Tag)) {
      return false;
    } else {
      Tag newTag = (Tag) otherTag;
      return this.getName().equals(newTag.getName());
    }
  }

  //GETTER METHODS
  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  //CREATE
  public void save() {
    String sql = "INSERT INTO tags(name) VALUES (:name)";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql,true)
      .addParameter("name", name)
      .executeUpdate()
      .getKey();
    }
  }

  //READ
  public static List<Tag> all() {
    String sql = "SELECT id, name FROM tags";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Tag.class);
    }
  }

  public static Tag find(int id) {
    String sql = "SELECT * FROM tags WHERE id=:id;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Tag.class);
    }
  }
  //UPDATE
  //DELETE
  public void delete() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM tags WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();

    String enrollmentsQuery = "DELETE FROM recipe_tags WHERE tag_id = :tagId";
    con.createQuery(enrollmentsQuery)
      .addParameter("tagId", id)
      .executeUpdate();
    }
  }
}
