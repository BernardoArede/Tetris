/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.resources;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author maria
 */
public class ReadResources {

    public static Clip loadResourceSound(String resourceName)
            throws IOException, UnsupportedAudioFileException,
            LineUnavailableException {
        //input stream para o recurso
        InputStream in = ClassLoader.getSystemClassLoader().
                getResourceAsStream(resourceName);
           //ler o som
        AudioInputStream ain = AudioSystem.getAudioInputStream(in);
        //obter o objeto para tocar o som
        Clip clip = AudioSystem.getClip();
        //ler o som
        clip.open(ain);
        return clip;
    }

    public static void playResourceSound() throws IOException,
        UnsupportedAudioFileException, LineUnavailableException {
        //ler o som
        Clip sound = loadResourceSound("sound.wav");
        //contruir a janela de visualização
        JFrame window = new JFrame("Resource Sound");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //introduzir a imagem num label
        JButton bt = new JButton("play");
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sound.setMicrosecondPosition(0);
                sound.start();
            }
        });
        //adiconar o label à janela
        window.setLayout(new BorderLayout());
        window.getContentPane().add(bt, BorderLayout.CENTER);
        //redimensiaonar os componentes
        window.setSize(400, 400);
        //mostrar a janela
        window.setVisible(true);
    }
}
