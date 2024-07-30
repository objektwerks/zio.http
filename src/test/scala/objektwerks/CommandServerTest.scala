package objektwerks

import zio.http.*
import zio.test.*

object CommandServerTest extends ZIOSpecDefault:
  def spec = suite("http")(
    test("command server should return ok") {
      val routes = CommandServer.routes
      val request = Request.get("http://localhost:6060/command")
      val app = routes.toHttpApp
      for
        response <- app.runZIO(request)
      yield assertTrue( response.status == Status.Ok )
    }
  )