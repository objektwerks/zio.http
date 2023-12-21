package objektwerks

import zio.*
import zio.http.*
import zio.json.*

import Event.given

object CommandServer extends ZIOAppDefault:
  val handler = Handler.fromFunction[Command] { case Command(name) => Event(name) }

  val routes = Routes(
    Method.POST / "command" -> handler
      .contramap[Request](request => Command(request.path.encode))
      .map(event => Response.json(event.toJson))
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))