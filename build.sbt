/** Project */
name := "sbt script generation plugin"

version := "0.1"

organization := "net.tupari"

scalaVersion := "2.9.1"

sbtPlugin := true

/** Shell */
shellPrompt := { state => System.getProperty("user.name") + "> " }

shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

maxErrors := 20

pollInterval := 1000

