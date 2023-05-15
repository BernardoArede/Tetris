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
public class PieceT extends Piece {
    private static final Block[][] T = {
            {new Block('T'), new Block('T'), new Block('T')},
            {new Empty(), new Block('T'), new Empty()}
    
};
    
    public PieceT(){
        super(T,0,0);
    }
}
