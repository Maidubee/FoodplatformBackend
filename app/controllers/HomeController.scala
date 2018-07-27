package controllers

import awscala._
import awscala.dynamodbv2._
import javax.inject.Inject
import play.api.mvc._

/**
  * A very small controller that renders a home page.
  */
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action { implicit request =>
    Ok("Hello, this is the index page")
  }

  /*  Placeholder functions */

  def getRecipe = Action { implicit request =>
    implicit val dynamoDB = DynamoDB.at(Region.Ireland)
    val table: Table = dynamoDB.table("recipes").get
    // The .getS gets the String value, there is also getM to get a map, getL to get a list, etc.
    table.getItem(1).get.attributes.foreach(item => println(item.name + " " + item.value.getS))

    Ok("This is the GET")
  }

  def postRecipe = Action { implicit request =>
    Ok("This is the POST")
  }

  def deleteRecipe = Action { implicit request =>
    Ok("This is the DELETE")
  }

  def putRecipe = Action { implicit request =>
    Ok("This is the PUT")
  }

}
