#include <jni.h>
#include <string>
#include "vtk_fmt.h"

extern "C" JNIEXPORT jstring JNICALL
Java_tech_xx_a3dlib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}