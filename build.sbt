// import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT",
      javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
      // For project with only Java sources. In order to compile Scala sources, remove the following two lines.
      crossPaths := false,
      autoScalaLibrary := false
    )),
    name := "s4n-java-training",
    libraryDependencies ++= Seq(
      "io.vavr" % "vavr" % "0.9.2",
      "junit" % "junit" % "4.12" % "test",
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.projectlombok" % "lombok" % "1.16.16",
      "org.mockito" % "mockito-core" % "1.8.5" % Test,
      "org.powermock" % "powermock-api-mockito2" % "1.7.3" % "test"
    )
  )
