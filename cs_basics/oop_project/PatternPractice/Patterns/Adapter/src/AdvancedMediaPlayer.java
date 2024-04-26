interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    public void playMp4(String fileName) {
        // VLC player does not support MP4
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        // MP4 player does not support VLC
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            this.advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp3") || audioType.equalsIgnoreCase("mp4")) {
            this.advancedMusicPlayer = new Mp4Player();
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
    /* TODO: implement MediaAdapter class */
//    public void play(String audioType, String fileName) {
//        if(audioType.equalsIgnoreCase("mp3")) {
//            System.out.println("Playing mp3 file: " + fileName);
//        } else if(audioType.equalsIgnoreCase("mp4")) {
//            System.out.println("Playing mp4 file: " + fileName);
//        } else {
//            System.out.println("Invalid media. " + audioType + " format not supported");
//        }
//    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            this.advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp3") || audioType.equalsIgnoreCase("mp4")) {
            this.advancedMusicPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file: " + fileName);
        } else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "beyond the horizon.mp3");
        player.play("mp4", "alone in the dark.mp4");
        player.play("vlc", "far far away.vlc");
    }
}
