package objektwerks

import zio.test.*
import zio.test.Assertion.equalTo
import zio.http.*

object NowServerTest extends ZIOSpecDefault:
  def spec = suite("http")(
    test("now server should return ok") {
      val routes = NowServer.routes
      val request = Request.get("http://localhost:7070/now")
      assertZIO(routes.runZIO(request))(equalTo(Response.ok))
    }
  )