package Recursos;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class AudioClip extends Application implements Runnable{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String archivoAudio = "TemaPrincipal.mp3";
        
        Media media = new Media(getClass().getResource(archivoAudio).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
        mediaPlayer.play();
    }

	@Override
	public void run() {
		this.main(null);
		
	}
}