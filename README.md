ZIO-HTTP
--------
>ZIO-HTTP feature tests using ZIO-Json and Scala 3.

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
* [ZIO-HTTP Github](https://github.com/zio/zio-http)
* [ZIO-HTTP Getting Started](https://zio.dev/zio-http/getting-started/)