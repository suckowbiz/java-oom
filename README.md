# oom
## What is it?
A Java 8 based Java EE 7 Maven project containing classes to build a .war file that consumes entire HEAP with the goal to provoke OutOfMemoryError.

## How to I use it?
Run `mvn package` and deploy `target/oom.war` into a Java EE 7 compliant application runtime.