#!/bin/bash
rm ujava.jar
cd src
javac -d . *.java
cd ..
jar cf ujava.jar src/ujava src/*.java LICENSE GPLV3 VERSION README.md
rm src/ujava/*.class
rmdir src/ujava
