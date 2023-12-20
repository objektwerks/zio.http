Zio-Http
--------
>Zio-Http feature tests using Scala 3.

Build
-----
1. sbt clean compile

Test
----
>NowServerTest is correct; yet still fails! See test output.
1. sbt clean test

Server
------
1. sbt clean compile run

Client
------
1. curl -v http://localhost:7070/now

Resources
---------
* [Zio-Http Github](https://github.com/zio/zio-http)
* [Zio-Http Getting Started]https://zio.dev/zio-http/getting-started/)