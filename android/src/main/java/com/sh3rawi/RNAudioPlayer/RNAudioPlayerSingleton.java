package com.sh3rawi.RNAudioPlayer;

import android.media.MediaPlayer;

public class RNAudioPlayerSingleton {
   private static RNAudioPlayerSingleton instance = null;

   private MediaPlayer mp=null;

   protected RNAudioPlayerSingleton() {
      // Exists only to defeat instantiation.
   }
   public static RNAudioPlayerSingleton getInstance() {
      if(instance == null) {
         instance = new RNAudioPlayerSingleton();
      }
      return instance;
   }

   public void resetIfNeedAudio(){
      if(mp != null){
        mp.stop();
        mp.reset();
        mp = null;
      }
   }
   public void setAudioPlayer(MediaPlayer mp){
     this.mp = mp;
   }
}
