Zio-Http
--------
>Zio-Http feature tests using Zio-Json and Scala 3.

Warning
-------
>ZIO Http is the ideal *poster child* for why Scala is dying --- a massively over-engineered
>library, confusing both compiler and developer. :) Think of trying to change a tire on a moving
>car; and you'll have grasped the insanity of the ZIO ecosystem. :)

Build
-----
1. sbt clean compile

Test
----
1. sbt clean test

Server
------
1. sbt clean test run
```
Multiple main classes detected. Select one to run:
 [1] objektwerks.CommandServer
 [2] objektwerks.NowServer

Enter number:
```

Client
------
1. curl -v http://localhost:7070/now

Resources
---------
* [Zio-Http Github](https://github.com/zio/zio-http)
* [Zio-Http Getting Started](https://zio.dev/zio-http/getting-started/)
