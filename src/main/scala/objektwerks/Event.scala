package objektwerks

import zio.json.*

final case class Event(name: String)

given JsonDecoder[Event] = DeriveJsonDecoder.gen[Event]