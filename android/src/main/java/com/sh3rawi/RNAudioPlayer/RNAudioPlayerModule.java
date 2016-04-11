package com.sh3rawi.RNAudioPlayer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class RNAudioPlayerModule extends ReactContextBaseJavaModule {
  ReactApplicationContext reactContext;
  MediaPlayer mp;

  public RNAudioPlayerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAudioPlayer";
  }

  private void sendEvent(
          String eventName
  ) {
    this.reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName,null);
  }

  @ReactMethod
  public void play(String audio) {
    RNAudioPlayerSingleton singleton = RNAudioPlayerSingleton.getInstance();
    singleton.resetIfNeedAudio();
    String fname = audio.toLowerCase();
    int resID = this.reactContext.getResources().getIdentifier(fname, "raw", this.reactContext.getPackageName());
    mp = MediaPlayer.create(this.reactContext, resID);
    mp.start();


  mp.setOnCompletionListener(new OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
    sendEvent("AudioPlayerDidFinishPlaying");

    mp.reset();
    mp.release();
    mp = null;
    }
  });

  singleton.setAudioPlayer(mp);
  }

  @ReactMethod
  public void pause() {
    if(mp != null)
      mp.pause();

  }

  @ReactMethod
  public void resume() {
    if(mp != null)
      mp.start();

  }
}
