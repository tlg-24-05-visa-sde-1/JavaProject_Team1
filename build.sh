javac -d classes -classpath "lib/*" src/com/rumprogram/*.java src/com/rumprogram/bartender/*.java src/com/rumprogram/client/*.java
jar --create --file rumprogram-1.0.jar -C classes .