package objektwerks

import zio.*
import zio.http.*
import zio.json.*
import zio.test.*

import Command.given

object CommandServerTest extends ZIOSpecDefault:
  def spec = suite("command")(
    test("command server should return ok") {
      val command = Command("test")
      val request = Request.post("http://localhost:6060/command", Body.fromString( command.toJson ) )
      for
        response <- CommandServer.routes.runZIO(request)
      yield assertTrue( response.status == Status.Ok )
    }
  )