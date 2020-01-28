@ECHO OFF
DEL ujava.jar
CD src
javac -d . *.java
CD ..
jar cf ujava.jar src\ujava src\*.java LICENSE GPLV3 VERSION "README.md"
DEL src\ujava\*.class
RMDIR src\ujava
