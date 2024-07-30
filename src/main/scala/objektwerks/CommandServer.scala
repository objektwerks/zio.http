package objektwerks

import zio.*
import zio.http.*
import zio.json.*

import Command.given
import Event.given

object CommandServer extends ZIOAppDefault:
  val commandHandler = Handler.fromFunction[Command] { case Command(name) => Event(name) }

  val routes = Routes(
    Method.POST / "command" -> commandHandler
      // Error: Found: objektwerks.Command Required: zio.ZIO[Nothing, Any, Any]
      // Using any ZIO.* constructor method results in the opposite error: objektwerks.Command required
      .contramap[Request](request => request.body.asString.flatMap { json => json.fromJson[Command] } )
      .map(event => Response.json(event.toJson))
  ).toHttpApp

  def run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))