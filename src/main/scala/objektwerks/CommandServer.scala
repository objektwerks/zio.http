package objektwerks

import zio.*
import zio.http.*
import zio.json.*

import Command.given
import Event.given

object CommandServer extends ZIOAppDefault:
  val routes = Routes(
    Method.POST / "command" -> handler { (request: Request) =>
      for {
        body    <- request.body.asString.orDie
        command <- ZIO.fromEither( body.fromJson[Command] )
        event   = Event( command.name ).toJson
      } yield Response.json(event)
    }
  ).handleError(_ match
    case _: String => Response.badRequest("Invalid json.")
  )

  val app = routes.toHttpApp

  def run = Server
    .serve(app)
    .provide(Server.defaultWithPort(6060))