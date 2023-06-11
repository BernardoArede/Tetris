
package tetris.lib.pieces;

import tetris.lib.blocks.Block;
import tetris.lib.blocks.BlockMatrix;

/**
 * Created on 01/05/2023, 08:20:18
 * moveable Piece in the tetris game
 * 
 * @author IPT - computer
 * @version 1.0
 */
public class Piece extends BlockMatrix {

    //position in the tetris board
    protected int positionX;
    protected int positionY;

    /**
     * Construtor
     * @param mat Matriz de blocos
     * @param y posição Y-linhas
     * @param x  *osição X- colunas
     */
    public Piece(Block[][] mat, int y, int x) {
        super(mat); // call constructor of superclasse
        this.positionX = x;
        this.positionY = y;
    }
   /**
    * 
    * Construtor Copia
    * @param p piece to clone
    */
    public Piece(Piece p) {
        this(p.matrix, p.positionY, p.positionX);
    }

    /**
     * MOve a peça para a esquerda
     */
    public void moveLeft() {
        positionX--;
    }

    /**
     * MOve a peça para a direita
     */
    public void moveRight() {
        positionX++;
    }

    /**
     * MOve a peça para a baixo
     */
    
    public void moveDown() {
        positionY++;
    }

    /**
     * Clona a peça
     * @return piece clone
     */
    
    @Override
    public Piece getClone() {
        return new Piece(this);
    }
    //encapsulation of atributes

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
/**
 * 
 * @return Retorna uma representação em forma de string da peça
 */
    @Override
    public String toString() {
        return "(" + positionY + "," + positionX + ")\n" + super.toString();
    }
    
}
