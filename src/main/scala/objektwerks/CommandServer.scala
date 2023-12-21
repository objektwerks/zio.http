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
    Method.POST / "command" -> Handler
      .fromFunction[Command] { case Command(name) => Event(name) }
      .map(event => Response.json(event.toJson))
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(6060))