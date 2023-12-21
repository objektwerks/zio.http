package objektwerks

import zio.*
import zio.http.*
import zio.json.*

object CommandServer extends ZIOAppDefault:
  val routes = Routes(
    Method.POST / "command" -> handler { (request: Request) =>
      for
        json <- request.body.asString
        command <- json.fromJson[Command]
        event = Event(name = command.name)
      yield Response.json(event.toJson)
    }
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))