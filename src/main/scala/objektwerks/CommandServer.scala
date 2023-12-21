package objektwerks

import zio.*
import zio.http.*
import zio.json.*

import Event.given

object CommandServer extends ZIOAppDefault:
  val routes = Routes(
    Method.POST / "command" -> handler { (request: Request) =>
      (
        for
          json    <- request.body.asString
          command <- json.fromJson[Command]
          event    = Event(name = command.name)
        yield Response.json(event.toJson)
      ).recover {
        case NonFatal(error) => s"{error: ${error.getMessage}}"
      }
    }
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))