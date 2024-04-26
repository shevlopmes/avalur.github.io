interface MediaPlayer {
    void play(String audioType, String fileName);
}

class SimpleMediaPlayer implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            System.out.println("Playing mp4 file: " + fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }

    public static void main(String[] args) {
        SimpleMediaPlayer player = new SimpleMediaPlayer();
        player.play("mp3", "beyond the horizon.mp3");
        player.play("mp4", "alone in the dark.mp4");
    }
}
