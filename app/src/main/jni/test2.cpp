//
// Created by jack on 2021/1/20.
//
#include <jni.h>
//#include <iostream>

#define LOG_TAG "show infomation"
//#define LOGW(a )  __android_log_write(ANDROID_LOG_WARN,LOG_TAG,a)

//#include <android_runtime/AndroidRuntime.h>

//using namespace std;

static const char* const kClassJniTest2 =
        "com.example.design";

static void
com_example_design_JniTestStatic_hello(JNIEnv * env, jobject thiz)
{
    //cout << " this is a gcx" << endl;
    return;
}

static jstring
com_example_design_JniTestStatic_getHello(JNIEnv *env, jobject thiz)
{
    //cout << " this is a gcx1" << endl;
    return NULL;
}
static jint
com_example_design_JniTestStatic_getA(JNIEnv* env, jobject thiz, jint a, jint b)
{
    //cout << " this is a gcx2" << endl;
    return  a - b;
}

static JNINativeMethod gMethods[] = {

        {"hello" ,"()V",
                (void *)com_example_design_JniTestStatic_hello},
        {"getHello" ,"(Ljava/lang/String;)Ljava/lang/String",
                (void *)com_example_design_JniTestStatic_getHello},
        {"getA" ,"(I;I;)I",
                (void *)com_example_design_JniTestStatic_getA}
};

static int RegisterNativeMethods(JNIEnv* env, const char* className,
                                 JNINativeMethod* gMethods,int numMethods)
{
    jclass clazz;
    clazz = env->FindClass(className);

    if (env->RegisterNatives(clazz, gMethods, numMethods) < 0)
    {
        return JNI_FALSE;
    }

    return JNI_TRUE;
}

static int register_com_example_design(JNIEnv *env)
{
    return RegisterNativeMethods(env, kClassJniTest2, gMethods, 3);

}


jint JNI_OnLoad(JavaVM* vm, void* /* reserved */)
{
    JNIEnv* env = NULL;
    jint result = -1;

    if (vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
        //ALOGE("ERROR: GetEnv failed\n");
        goto bail;
    }

    if (register_com_example_design(env) != JNI_OK) {
        //cout << ("ERROR: ImageWriter native registration failed") << endl;
        goto bail;
    }
    result = JNI_VERSION_1_4;

    bail:
    return result;

}
