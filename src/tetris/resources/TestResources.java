/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.resources;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static tetris.resources.ReadResources.playResourceSound;

/**
 *
 * @author maria
 */
public class TestResources {
    public static void main(String[] args) throws IOException, 
            UnsupportedAudioFileException, LineUnavailableException {
        playResourceSound();
    }
}
