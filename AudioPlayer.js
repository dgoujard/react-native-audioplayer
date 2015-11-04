'use strict';

var RNAudioPlayer = require('react-native').NativeModules.RNAudioPlayer;
var NativeAppEventEmitter = require('react-native').NativeAppEventEmitter;

module.exports = class AudioPlayer {
  play(fileName: string) {
    RNAudioPlayer.play(fileName);
  }

  pause() {
    RNAudioPlayer.pause();
  }
  resume() {
    RNAudioPlayer.resume();
  }
  stop() {
    RNAudioPlayer.stop();
  }
};