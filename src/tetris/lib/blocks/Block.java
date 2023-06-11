//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2023   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package tetris.lib.blocks;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import tetris.gui.Drawable;

/**
 * Created on 26/04/2023, 04:05:22
 *
 * @author berna
 */
public class Block extends JComponent implements Drawable{

    /**
     * Esse método chama o método draw para desenhar o bloco com as dimensões corretas. 
     * @param gr 
     */
    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr); //build component
        draw(gr, 0, 0, getWidth()-1, getHeight()-1);
    }
    
    /**
     * Desenha o bloco usando as dimensões fornecidas e preenchendo-o com a cor especificada.
     * @param gr
     * @param px Obtemos a posição relativamente a x
     * @param py    Obtemos a posição relativamente a x
     * @param width Obtemos a largura
     * @param height Obtemos a altura
     */
     @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
    //color of fill
        gr.setColor(myColor);
        //fill block
        gr.fill3DRect(px, py, width, height,true);    
        //color of line
        gr.setColor(Color.BLACK);
        //draw line
        gr.draw3DRect(px, py, width, height,true);
    }
    
    
    protected char txt;
    protected Color myColor;

    /**
     * 
     * @return Retorna a cor do bloco.  
     */
    public Color getMyColor() {
        return myColor;
    }
    /**
     * 
     * @param myColor Define a cor do bloco
     * 
     */
    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }
    /**
     * Cria um bloco com o caractere e a cor especificados. 
     * @param ch parametro do caracter
     * @param color parametro da cor 
     */
    public Block(char ch,Color color) {
        this.txt = ch;
        this.myColor = color;
    }
    
    /**
     * Cria um bloco vazio com a cor azul. 
     */
     public Block(){
         this(' ', Color.BLUE);
     }
    /**
     * Cria um bloco com o caractere especificado e a cor verde. 
     */
    public Block(char ch) {
        this(ch, Color.GREEN);
    }
    /**
     * Cria um bloco com base em outro bloco existente, copiando seu caractere e cor. 
     */
    public Block(Block b) {
        this(b.txt, b.myColor);
    }
    /**
    * 
    * @return Retorna o caractere associado ao bloco. 
    */
    public char getTxt() {
        return txt;
    }
    /**
     * Define o caracter associado ao bloco
     * @param txt 
     */
    public void setTxt(char txt) {
        this.txt = txt;
    }
    /**
     * Sobrescreve o método toString. 
     * @return  retorna a representação textual do bloco
     */
    @Override
    public String toString() {
        return txt + "";
    }
    /**
     * 
     * @return Retorna uma cópia do bloco atual, criando um novo bloco com o mesmo caractere e cor.
     */
    public Block getClone() {
        return new Block(this);
    }


}
