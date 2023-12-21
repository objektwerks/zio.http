package objektwerks

import java.time.Instant

import zio.*
import zio.http.*

object NowServer extends ZIOAppDefault:
  val routes = Routes(
    Method.GET / "now" -> handler( Response.text( s"*** Now: ${Instant.now.toString}" ) ),
    Method.POST / "command" -> handler( Response.json("") )
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(7070))