package objektwerks

import java.time.Instant

import zio.*
import zio.http.*

object NowServer extends ZIOAppDefault:
  val routes = Routes(
    Method.GET / "now" -> handler { (_: Request) =>
      Response.text( s"*** Now: ${Instant.now.toString}" )
    }
  )

  val app = routes.toHttpApp

  def run = Server
    .serve(app)
    .provide(Server.defaultWithPort(7070))