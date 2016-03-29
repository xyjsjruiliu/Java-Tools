saveDir=/home/xylr/mylib
gcc -g -Wall -I $JAVA_HOME/include/ -I $JAVA_HOME/include/linux -fPIC -shared -o $saveDir/libchineseInfoXtract4j.so chineseInfoXtract4j.c
