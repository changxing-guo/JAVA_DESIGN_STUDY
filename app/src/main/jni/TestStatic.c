//
// Created by jack on 2021/1/19.
//静态jni注册测试
//#include "TestStatic.h"
#include <jni.h>
#include <stdio.h>

JNIEXPORT void JNICALL
Java_com_example_design_JniTestStatic_hello(JNIEnv * env, jobject thiz)
{
// TODO: implement hello()
    printf("this is a test hello\n");
}

JNIEXPORT jstring JNICALL
Java_com_example_design_JniTestStatic_getHello(JNIEnv *env, jobject thiz)
{
    // TODO: implement getHello()
    return NULL;
}

JNIEXPORT jint JNICALL
Java_com_example_design_JniTestStatic_getA(JNIEnv* env, jobject thiz, jint a, jint b)
{
// TODO: implement getA()
    return a + b;
}

