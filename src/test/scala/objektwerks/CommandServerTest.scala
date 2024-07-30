package objektwerks

import zio.http.*
import zio.test.*

object CommandServerTest extends ZIOSpecDefault:
  def spec = suite("http")(
    test("command server should return ok") {
      val request = Request.get("http://localhost:6060/command")
      for
        response <- CommandServer.routes.runZIO(request)
      yield assertTrue( response.status == Status.Ok )
    }
  )