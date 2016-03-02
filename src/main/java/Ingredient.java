import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Ingredient {
  private int id;
  private String name;

  //CONSTRUCTOR
  public Ingredient(String name) {
    this.name = name;
  }

  //OVERRIDE FOR EQUALS METHOD
  @Override
  public boolean equals(Object otherIngredient){
    if (!(otherIngredient instanceof Ingredient)) {
      return false;
    } else {
      Ingredient newIngredient = (Ingredient) otherIngredient;
      return this.getName().equals(newIngredient.getName());
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
    String sql = "INSERT INTO ingredients(name) VALUES (:name)";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql,true)
      .addParameter("name", name)
      .executeUpdate()
      .getKey();
    }
  }

  //READ
  public static List<Ingredient> all() {
    String sql = "SELECT id, name FROM ingredients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Ingredient.class);
    }
  }
  //UPDATE
  //DELETE
}
