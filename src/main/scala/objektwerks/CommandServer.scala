package objektwerks

import zio.*
import zio.http.*

object CommandServer extends ZIOAppDefault:
  val routes = Routes(
    Method.POST / "command" -> handler( Response.json("") )
  ).toHttpApp

  override val run = Server
    .serve(routes)
    .provide(Server.defaultWithPort(7070))