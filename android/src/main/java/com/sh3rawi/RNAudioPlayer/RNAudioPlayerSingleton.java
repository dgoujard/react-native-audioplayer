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
       try {
           if(mp != null){
               if(mp.isPlaying())
                 mp.stop();
                 mp.reset();
                 mp.release();
              mp = null;
           }
       } catch (Exception e) {
           mp = null;
        }
   }
   public void setAudioPlayer(MediaPlayer mp){
     this.mp = mp;
   }
}
