#include <stdio.h>
#include <stdlib.h>
#include "com_xy_lr_java_jni_ShellDemo.h"

/*
 * Class:     com_xy_lr_java_jni_ShellDemo
 * Method:    getNum
 * Signature: ()I
 */
JNIEXPORT void JNICALL Java_com_xy_lr_java_jni_ShellDemo_execShell
  (JNIEnv *env, jobject job){

    system("/opt/ChineseInfoXtract/bin/ChineseProcessor -i ~/Working/IdeaProjects/Java-Tools/te -o ~/Working/IdeaProjects/Java-Tools/qwe --xmlOut");
}

/*
 * Class:     com_xy_lr_java_jni_ShellDemo
 * Method:    execChineseProcessor
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_xy_lr_java_jni_ShellDemo_execChineseProcessor
  (JNIEnv *env, jobject job, jstring str) {
    const char *nativeString = (*env)->GetStringUTFChars(env, str, 0);
    system(nativeString);
}