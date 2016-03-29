#include <stdio.h>
#include "com_xy_lr_java_jni_FirstDemo.h"

/*
 * Class:     com_xy_lr_java_jni_FirstDemo
 * Method:    getNum
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_xy_lr_java_jni_FirstDemo_getNum
  (JNIEnv *env, jobject obj) {
      return (jint)1;
}

/*
 * Class:     com_xy_lr_java_jni_FirstDemo
 * Method:    getString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_xy_lr_java_jni_FirstDemo_getString
  (JNIEnv *env, jobject ob) {
      jstring jinfo = (*env)->NewStringUTF(env,"the first demo.");
      return jinfo;
}