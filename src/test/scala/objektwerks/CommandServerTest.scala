package objektwerks

import zio.http.*
import zio.json.*
import zio.test.*

import Command.given

object CommandServerTest extends ZIOSpecDefault:
  def spec = suite("http")(
    test("command server should return ok") {
      val request = Request.post("http://localhost:6060/command", Body.fromString( Command("test").toJson ) )
      for
        response <- CommandServer.routes.runZIO(request)
      yield assertTrue( response.status == Status.Ok )
    }
  )