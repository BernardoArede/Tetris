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
public class PieceO extends Piece {
    private static Block[][] O = {{new Empty(),new Block('O'),  new Block('O')},
            {new Empty(), new Block('O'), new Block('O')}};
    
    public PieceO(){
        super(O,0,0);
    }
}