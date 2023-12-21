package objektwerks

import zio.json.*

final case class Command(name: String)

object Command:
  given JsonDecoder[Command] = DeriveJsonDecoder.gen[Command]