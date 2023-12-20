package objektwerks

import zio.test.*
import zio.test.Assertion.equalTo
import zio.http.*

object NowServerTest extends ZIOSpecDefault {

  def spec = suite("http")(
    test("now server should return ok") {
      val routes = NowServer.routes
      val request = Request.get(URL(Root))
      assertZIO(routes.runZIO(request))(equalTo(Response.ok))
    }
  )
}