LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := test
LOCAL_SRC_FILES := TestStatic.c
LOCAL_LDLIBS := -lm -llog

include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := test2
LOCAL_SRC_FILES := test2.cpp
LOCAL_LDLIBS := -lm -llog

include $(BUILD_SHARED_LIBRARY)