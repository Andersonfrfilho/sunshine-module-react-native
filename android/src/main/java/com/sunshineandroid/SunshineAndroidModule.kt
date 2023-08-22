package com.sunshineandroid

import android.app.ProgressDialog.show
import android.content.Intent
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import io.smooch.core.Smooch
import io.smooch.core.SmoochCallback
import io.smooch.core.SmoochCallback.*
import io.smooch.ui.ConversationActivity


class SunshineAndroidModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }
  private var isSmoochInitialized = false

  init {
    val applicationContext = reactApplicationContext.applicationContext
/*
    Smooch.init(applicationContext as Application, Settings("64da85db59892762098dc229"), SmoochCallback {
        response ->
      println("###########################- dentro")
      println(response)
      if (response.getData() == InitializationStatus.SUCCESS) {
        isSmoochInitialized = true
      }
    })*/
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    val applicationContext = reactApplicationContext.applicationContext
    promise.resolve(a + b)
  }

  @ReactMethod
  fun show() {
    var builda = ConversationActivity.builder();
  }

  @ReactMethod
  fun login() {
    println("############### - 1")
    val activity = currentActivity
    if (activity != null) {
      val intent = Intent(activity, ConversationActivity::class.java)
      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
      activity.startActivity(intent)
    }
  }
  companion object {
    const val NAME = "SunshineAndroid"
  }
}
