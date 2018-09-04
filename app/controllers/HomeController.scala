package controllers

import awscala._
import awscala.dynamodbv2._
import javax.inject.Inject
import play.api.mvc._

import scala.util.{Failure, Success, Try}

/**
  * A very small controller that renders a home page.
  */
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  implicit val dynamoDB: DynamoDB = DynamoDB.at(Region.Ireland)
  def index = Action { implicit request =>
    Ok("Hello, this is the index page")
  }

  def getRecipe(id: Int) = Action { implicit request =>
    id match{
      case -1 => getAllRecipes
      case _ => getSingleRecipe(id)
    }

    Ok("This is the GET")
  }


  /*  Placeholder functions */

  def postRecipe = Action { implicit request =>
    Ok("This is the POST")
  }

  def deleteRecipe = Action { implicit request =>
    Ok("This is the DELETE")
  }

  def putRecipe = Action { implicit request =>
    Ok("This is the PUT")
  }

  /* Helper functions (to be moved later) */
  def getTable(name: String) = {
    dynamoDB.table(name).get
  }

  // The .getS gets the String value, there is also getM to get a map, getL to get a list, etc.
  def getSingleRecipe(id: Int) = {
    val table = getTable("recipes")

    println(table.scan(Seq("recipeID" -> cond.eq(id))).)

    Try(table.getItem(id).get) match {
//      case Success(recipe) => recipe.attributes.foreach(item => println(item.name + " " + item.value.getS))
      case Success(recipe) => println(recipe.attributes.map(item => item.name + " " + item.value.getS))
      case Failure(_) => println(s"No recipe found with id $id.")
    }
  }

  def getAllRecipes: Unit = {
    println("Placeholder to get ALL recipes")
  }

}
