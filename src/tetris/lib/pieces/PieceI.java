
package tetris.lib.pieces;

import tetris.lib.blocks.Block;
import java.awt.Color;
import java.awt.Graphics;
import tetris.lib.blocks.Empty;


public class PieceI extends Piece {

    
    public static Block[][] I = {
       {new Block('I',Color.CYAN), new Block('T',Color.CYAN), new Block('T',Color.CYAN)},
        {new Empty(),new Empty(), new Empty()
       }};
    /**
    * Construtor da classe PieceI, passando a matriz M, com a poisção y a 0 e x também a 0 
    */
    public PieceI() {
        super(I, 0, 0);
    }
    
    

  
    
}
