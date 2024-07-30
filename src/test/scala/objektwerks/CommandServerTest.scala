package objektwerks

import zio.*
import zio.http.*
import zio.json.*
import zio.test.*

import Command.given
import Event.given

object CommandServerTest extends ZIOSpecDefault:
  def spec = suite("http")(
    test("command server should return ok") {
      val command = Command("test")
      val request = Request.post("http://localhost:6060/command", Body.fromString( command.toJson ) )
      for
        response <- CommandServer.routes.runZIO(request)
      yield
        for
          body  <- response.body.asString.orDie
          event <- ZIO.fromEither( body.fromJson[Event] )
        yield assertTrue( event.name == command.name)
        assertTrue( response.status == Status.Ok )
    }
  )