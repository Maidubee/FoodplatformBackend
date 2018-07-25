package controllers

import javax.inject.Inject
import play.api.mvc._

/**
  * A very small controller that renders a home page.
  */
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action { implicit request =>
    Ok("Hello")
  }

  /*  Placeholder functions */

  def test = Action { implicit request =>
    Ok("Can you hear me?")
  }

  def getRecipe = Action { implicit request =>
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
