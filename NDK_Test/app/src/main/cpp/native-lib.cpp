#include <jni.h>
#include <string>
#include "bubble_sort.c"

extern "C"
JNIEXPORT void JNICALL
Java_ndk_1test_app_alexis_com_ndk_1test_MainActivity_bubbleSort(JNIEnv *env, jobject instance) {

  run_bubble_sort();

}

extern "C"
JNIEXPORT void JNICALL
Java_ndk_1test_app_alexis_com_ndk_1test_MainActivity_memoryAllocation(JNIEnv *env,
                                                                      jobject instance) {

  int user_input = 5;
  char* c = (char*)malloc(sizeof(char)*4000*user_input);

}