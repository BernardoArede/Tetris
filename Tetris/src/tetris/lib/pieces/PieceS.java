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
public class PieceS extends Piece {
    private static Block[][] S =  {{new Empty(), new Block('S'), new Block('S')},
            {new Block('S'), new Block('S'), new Empty()}
        };
    
    public PieceS(){
        super(S,0,0);
    }
}
