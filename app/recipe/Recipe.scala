package recipe
import com.google.gson.Gson

class Recipe (recipeID: Int, ingredients: Map[String, String], name: String, preparation:List[String], serves: Int, source:String) {
  println("recipe created")

  override def toString(): String = "This is recipe " + name + recipeID + ingredients + preparation + serves + source

  def toJson: String = {
    val gson = new Gson
    gson.toJson(this)

  }

}
