package Recursos;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class AudioClip extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String audioFile = "TemaPrincipal.mp3"; // Ubicación del archivo de audio

        // Crear un objeto Media con el archivo de audio
        Media media = new Media(getClass().getResource(audioFile).toString());

        // Crear un reproductor de audio
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Reproducir el audio
        mediaPlayer.play();
    }
}
