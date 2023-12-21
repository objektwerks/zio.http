package objektwerks

import zio.*
import zio.http.*
import zio.json.*

import Command.given
import Event.given

object CommandServer extends ZIOAppDefault:
  val commandHandler = Handler
    .fromFunction[Command] { case Command(name) => Event(name) }
    .map(event => Response.json(event.toJson))
    
  val routes = Routes(
    Method.POST / "command" -> handler { (request: Request) =>
      (
        for
          json    <- request.body.asString
          command <- ZIO.succeed( json.fromJson[Command] )
        yield
          val event = Event(name = command.name)
          Response.json(event.toJson)
      ).recover {
        case NonFatal(error) => s"{error: ${error.getMessage}}"
      }
    }
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))