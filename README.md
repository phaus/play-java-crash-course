# Play/Java

A Crash Course for Play `2.6.1` in `java`.

## Prerequisites

* JDK 8
* sbt
* IDE/Editor

## Setup

```
sbt new playframework/play-java-seed.g8
WARN: No sbt.version set in project/build.properties, base directory: /Users/philipp/GIT/innoQ/play-java-crash-course
[warn] Executing in batch mode.
[warn]   For better performance, hit [ENTER] to switch to interactive mode, or
[warn]   consider launching sbt without any commands, or explicitly passing 'shell'
[info] Set current project to play-java-crash-course (in build file:/Users/philipp/GIT/innoQ/play-java-crash-course/)

This template generates a Play Java project

name [play-java-seed]: contacts
organization [com.example]: com.innoq
scala_version [2.12.2]:
play_version [2.6.1]:

Template applied in ./contacts
```

### Setup IDE (option)

In `~/.sbt/0.13/plugins/plugins.sbt` add 

    addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.1.0")

After that run

    sbt eclipse

in your project.


Please be aware that you might perform

```
sbt update
sbt compile
sbt eclipse
```

whenever you add/change project dependencies.