package objektwerks

import zio.http.*
import zio.test.*

object NowServerTest extends ZIOSpecDefault:
  def spec = suite("http")(
    test("now server should return ok") {
      val routes = NowServer.routes
      val request = Request.get("http://localhost:7070/now")
      for
        response <- routes.runZIO(request)
      yield assertTrue( response.status == Status.Ok )
    }
  )