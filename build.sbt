name := "rifs-web"

lazy val `rifs-web` = (project in file("."))
  .enablePlugins(GitVersioning)
  .enablePlugins(GitBranchPrompt)

scalaVersion := "2.11.8"

val SPRING_BOOT_VERSION = "1.4.1.RELEASE"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % SPRING_BOOT_VERSION,
  "org.springframework.boot" % "spring-boot-starter-thymeleaf" % SPRING_BOOT_VERSION,
  "org.springframework.boot" % "spring-boot-devtools" % SPRING_BOOT_VERSION,
  "org.springframework" % "spring-web" % SPRING_BOOT_VERSION,
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.3",
  "org.apache.commons" % "commons-lang3" % "3.0",
  "org.springframework.boot" % "spring-boot-starter-test" % SPRING_BOOT_VERSION % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)