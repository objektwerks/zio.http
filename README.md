Zio-Http
--------
>Zio-Http feature tests using Scala 3.

Warning
-------
>[2023.12.21] **CommandServer** request-to-Command error: ```Found: objektwerks.Command Required: zio.ZIO[Nothing, Any, Any]```

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