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
package tetris.lib.game;

import java.awt.Graphics;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;
import tetris.lib.blocks.BlockMatrix;
import tetris.lib.pieces.Piece;
import tetris.lib.utils.TetrisPiece;

/**
 * Created on 01/05/2023, 08:48:11
 *
 * represents a tetris board with a floating piece
 *
 * @author  berna
 * @version 1.0
 */
public class Board extends BlockMatrix {

    @Override
    public void paintComponent(Graphics g) {
        draw(g, 0, 0, getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        super.draw(gr, px, py, width, height);
        int sizeX = width / getColmuns();
        int sizeY = height / getLines();       
        current.draw(gr, px + current.getPositionX() * sizeX,
                py + current.getPositionY() * sizeY,
                sizeX * current.getColmuns(),
                sizeY * current.getLines());
    }

    /**
     *  peça  atual na board
     */
    protected Piece current;
    
    /**
     * Cria um tabuleiro e 20 por 10 
     */
    public Board() {
        this(20 , 10);
    }

    /**
     * Constructor
     *
     * @param mat matrix de blocos
     * @param current Peça atual
     */
    public Board(Block[][] mat, Piece current) {
        super(mat); // call constructor of supercalsse
        this.current = current.getClone(); // clone piece
    }

    /**
     * Construtor copia
     *
     * @param b board
     */
    public Board(Board b) {
        this(b.matrix, b.current);
    }

    /**
     * Contrui a board com blocos vazios
     *
     * @param lines number of lines
     * @param columns number of columns
     */
    public Board(int lines, int columns) {
        resize(lines, columns);
    }
    /**
     * Redimensiona o tabuleiro para o número especificado de linhas e colunas.
     * @param lines
     * @param columns 
     */
    public void resize(int lines, int columns) {
        this.matrix = new Block[lines][columns];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {

                matrix[y][x] = new Empty();
            }
        }
        generateRandomPiece();
    }

    /**
     * gera um peça random 
     */
    public void generateRandomPiece() {
        this.current = TetrisPiece.generateRandom();
        //update the position x of piece to the midle of the board
        this.current.setPositionX(getColmuns() / 2 - current.getColmuns() / 2);
        //top of the board
        this.current.setPositionY(0);
        repaint();
    }

    /**
     * Transfere a peça atual para a board tornando imovel
     */
    public void freezePiece() {
        //iterate blocks
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                //if block is not empty
                if (!(current.getMatrix()[y][x] instanceof Empty)) {
                    //freeze block
                    this.matrix[current.getPositionY() + y][current.getPositionX() + x] = current.getMatrix()[y][x];
                }
            }
        }
        repaint();
       
       
       
    }
    /**
        * Sobrescreve o método toString para representar o tabuleiro como uma sequência de caracteres. d
        */

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        //clone board
        Board tmp = new Board(this);
        //freeze the floating piece
        tmp.freezePiece();
        //get the board        
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColmuns(); x++) {
                txt.append(tmp.matrix[y][x]);
            }
            txt.append("\n");
        }
        return txt.toString();
    }

    /**
     * Verifica se a peça atual se pode mover
     *
     * @param dy displacement in y
     * @param dx displacement ix
     * @return
     */
    public boolean canMovePiece(int dy, int dx) {
        //iterate current piece block matrix
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                //if block is empty - continue to next
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                //new position
                int px = current.getPositionX() + x + dx;
                int py = current.getPositionY() + y + dy;

                //is within limits
                if (px >= getColmuns() || px < 0 || py >= getLines() || py < 0
                        //not Empty
                        || !(matrix[py][px] instanceof Empty)) {
                    return false; // NOT MOVE
                }
            }
        }
        return true; //CAN MOVE
    }

    /**
     * Verifica se a peça atual pode rodar
     *
     * @return piece pode rodar
     */
    public boolean canRotatePiece() {
        //clone piece
        Piece clone = current.getClone();
        //rotate clone
        clone.rotate();
        //piece is outside board
        if (clone.getPositionX() + clone.getColmuns() > getColmuns()) {
            return false;
        }
        //verify all the block of the clone
        for (int y = 0; y < clone.getLines(); y++) {
            for (int x = 0; x < clone.getColmuns(); x++) {
                //block is empty - continue to next
                if (clone.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                //is in the limits 
                if (x < getColmuns() && x >= 0 && y < getLines() && y >= 0
                        //is not empty
                        && !(matrix[y][x] instanceof Empty)) {
                    return false; // NOT Rotation avaiable
                }
            }
        }
        return true; // Can Rotate
    }

    /**
     * move a peça para a esquerda
     */
    public void moveLeft() {
        if (canMovePiece(0, -1)) {
            current.moveLeft();
            repaint();
        }
    }

    /**
     * moove a peça para a direita
     */
    public void moveRight() {
        if (canMovePiece(0, 1)) {
            current.moveRight();
            repaint();
        }
    }

    /**
     *move a peça para baixo
     */
    public void moveDown() {
        if (canMovePiece(1, 0)) {
            current.moveDown();            
            repaint();
        }
    }

    /**
     * faz a peça  cair até onde se puder mover
     */
    public void fallDown() {
        while (canMovePiece(1, 0)) {
            current.moveDown();
        }
    }

    /**
     * Rodda a peça
     */
    public void rotate() {
        if (canRotatePiece()) {
            current.rotate();
            repaint();
        }
    }
/**
 * 
 * @return a peça atual
 */
    //encapsulation
    public Piece getCurrent() {
        return current;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }

   
    

}
