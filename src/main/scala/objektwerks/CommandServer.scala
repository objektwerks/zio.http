package objektwerks

import zio.*
import zio.http.*
import zio.json.*

import Command.given
import Event.given

object CommandServer extends ZIOAppDefault:
  val handler = Handler.fromFunction[Command] { case Command(name) => Event(name) }

  val routes = Routes(
    Method.POST / "command" -> handler
      // Error: Found: objektwerks.Command Required: zio.ZIO[Nothing, Any, Any]
      // Using any ZIO.* constructor method results in the opposite error: objektwerks.Command required
      .contramap[Request](request => request.body.asString.flatMap { json => json.fromJson[Command].getOrElse(Command("error")) } )
      .map(event => Response.json(event.toJson))
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))