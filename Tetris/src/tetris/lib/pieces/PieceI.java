/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.pieces;

import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 *
 * @author berna
 */
public class PieceI extends Piece {
    private static Block[][] I = {
            {new Block('I'), new Block('I'), new Block('I')},
            {new Empty(), new Empty(), new Empty()}
    
};
    
    public PieceI(){
        super(I,0,0);
    }
    
}
