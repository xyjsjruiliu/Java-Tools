#include <stdio.h>
#include <stdlib.h>
#include "com_xy_lr_java_jni_ChineseInfoXtract4j.h"

/*
 * Class:     com_xy_lr_java_jni_ChineseInfoXtract4j
 * Method:    ChineseProcessor
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_xy_lr_java_jni_ChineseInfoXtract4j_ChineseProcessor
  (JNIEnv *env, jobject job, jstring str) {

    const char *nativeString = (*env)->GetStringUTFChars(env, str, 0);
    system(nativeString);
}