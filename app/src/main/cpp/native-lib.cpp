#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_go_shopping_jni_Test_getString(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";

}