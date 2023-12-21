package objektwerks

import zio.json.*

final case class Command(name: String)

given JsonDecoder[Command] = DeriveJsonDecoder.gen[Command]