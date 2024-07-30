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

  def run = Server
    .serve(routes.toHttpApp)
    .provide(Server.defaultWithPort(7070))