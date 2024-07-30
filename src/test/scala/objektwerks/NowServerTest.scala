package objektwerks

import zio.http.*
import zio.test.*

object NowServerTest extends ZIOSpecDefault:
  def spec = suite("now")(
    test("now server should return ok") {
      val request = Request.get("http://localhost:7070/now")
      for
        response <- NowServer.routes.runZIO(request)
      yield assertTrue( response.status == Status.Ok )
    }
  )