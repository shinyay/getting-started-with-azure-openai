@echo off
REM This file was added as part of the Gradle Wrapper setup for Windows

set DIR=%~dp0
if "%DIR%" == "" set DIR=.
java -Dorg.gradle.appname=%~n0 -classpath "%DIR%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
