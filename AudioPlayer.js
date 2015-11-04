'use strict';

var RNAudioPlayer = require('react-native').NativeModules.RNAudioPlayer;
var NativeAppEventEmitter = require('react-native').NativeAppEventEmitter;
var { Platform } = require('react-native');

module.exports = class AudioPlayer {
  play(fileName: string) {
    fileName = Platform.OS === 'ios' ? fileName : fileName.replace(/\.[^/.]+$/, "");
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