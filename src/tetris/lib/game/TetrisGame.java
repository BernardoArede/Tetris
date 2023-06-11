/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.game;

import java.awt.Frame;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.SwingUtilities;
import tetris.gui.Listener;
import tetris.gui.TetrisGameOver;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 *
 * @author berna
 */
public class TetrisGame extends Board  {

    Timer timer;
    Clip clip;
    Clip clip2;
    
   int score=0;
   private int nLinhas = 0;
   private TetrisGameOver gameOverDialog;
   private boolean soundEnabled = true;
    

   
   /**
    * Construtor padrão da super classe board
    */
    public TetrisGame() {
        super();
        timer = new Timer();
        
    }
    
    /**
     * Inicializa os sons se assim for possivel
     */
    
    public void SoundsON() {
        
        if (!soundEnabled) {
        return;
    }
        try {
            File audioFile = new File("C:\\Users\\berna\\OneDrive\\Documentos\\NetBeansProjects\\Tetris2222\\src\\tetris\\resources\\TetrisMusic.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(audioFile));
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = -10.0f;
            volumeControl.setValue(volume);

            File audioFile2 = new File("C:\\Users\\berna\\OneDrive\\Documentos\\NetBeansProjects\\Tetris2222\\src\\tetris\\resources\\20.wav");
            clip2 = AudioSystem.getClip();
            clip2.open(AudioSystem.getAudioInputStream(audioFile2));
        } catch (Exception e) {
            System.err.println("Erro ao carregar a música: " + e.getMessage());
        }
    }
    
    /**
     * Cancela os sons se eles estiverem ativos
     */
    public void SoundsOFF() {
        clip.close();
        clip2.close();
}

   
     /**
      * Inicia o jogo com um determinado delay
      * @param delay 
      */
     
    public void startGame(int delay) {
        timer.schedule(new MoveGame(), 0, delay);
    }

    /**
     * atualiza os pontos no Dialog que irá aparece quando ocorrer gameOver
     */
    public void atualizarPontosNoDialog(){
        getScore();
        if(gameOverDialog !=null){
            String pontuacao = String.valueOf(score);
            String linhas = String.valueOf(nLinhas);
            gameOverDialog.atualizarPontuacao(pontuacao,linhas);
        }
        
    }
    /**
     * Interrompe o jogo, para o timer e exibe a tela do gameOver, GameOverDialog
     */
    public void stopGame() {
       //SoundsOFF();
       timer.cancel();
       
       System.out.println("TIMER CANCELADO");
  
       Frame parentFrame = (Frame) SwingUtilities.getAncestorOfClass(Frame.class,this);
       
       TetrisGameOver gameOverDialog1 = new TetrisGameOver(parentFrame, true);
       setGameOverDialog(gameOverDialog1);
       
        if(gameOverDialog != null){
           atualizarPontosNoDialog();
           gameOverDialog.setVisible(true);
        }
       
    }
/**
 * Verifica se ocorreu gameOver
 * @return verdadeiro se assim tiver ocorrido
 */
    public boolean isGameOver() {    
            return (current.getPositionY() == 0 && !canMovePiece(1, 0)); 
    }
/**
 * Verifica se a linha esta completa 
 * @param line
 * @return Verdadeiro se assim acontecer
 */
    public boolean isLineFull(int line) {
        for (Block item : matrix[line]) {
            if (item instanceof Empty) {
                return false;
            }
        }
        
        return true;

    }
/**
 * Se a linha estiver completa então elimina a linha e move todas a superiores para abaixo que esta completa e acrescenta uma no cimo da board
 * @param line 
 */
    public void eliminateLine(int line) {
        for (int y = line; y > 0; y--) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = matrix[y - 1][x];
            }
        }
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = new Empty();
        } 
        score+=100;
        nLinhas+=1;
        setnLinhas(nLinhas);
    }
/**
 * Elimina a linha preenchida
 */
    public void eliminateLines() {
        for (int i = matrix.length-1; i > 0; i--) {
            while (isLineFull(i)) {
                eliminateLine(i);
            }
        } 
    }
    
    /**
     * Reinicia o jogo limpoando o tabuleiro e definindo o score como zero
     */

  public void RestartGame() {
    // Reinicializa as variáveis ​​de jogo
     nLinhas = 0;
     score = 0;

    // Limpa a matriz do tabuleiro
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = new Empty();
        }
    }
    timer.cancel();
    
    timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            requestFocus();
        if (isGameOver()) {
            stopGame();
            
        } else if (canMovePiece(1, 0)) {    
            moveDown();            
        } else {
            freezePiece();
            score +=10; 
            eliminateLines();
            generateRandomPiece();
           
        }
   
        }
    };
    timer.schedule(timerTask, 0, 500);
    requestFocus();
   }
  
  

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    

    public void setGameOverDialog(TetrisGameOver gameOverDialog) {
        this.gameOverDialog = gameOverDialog;
    }

    public int getnLinhas() {
        return nLinhas;
    }

    public void setnLinhas(int nLinhas) {
        this.nLinhas = nLinhas;
    }

   
   
    /**
     * Classe interna que estendo o TimerTask e implementa a logica de movimentos dentro do jogo
     * Verificando se o jogo acabou, se a peça pode ser movida ou se deve ser congelada e inicia a proxima peça quando necessario
     */
    private class MoveGame extends TimerTask {
        @Override
        public void run() {
        requestFocus();
            if (isGameOver()) {
                stopGame();
            } else if (canMovePiece(1, 0)) {
                moveDown();
            } else {
                freezePiece();
                score+=10;
                eliminateLines();
                generateRandomPiece();
                
                
            }
        }
    }
}
