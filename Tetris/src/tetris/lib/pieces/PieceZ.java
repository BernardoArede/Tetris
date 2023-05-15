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
public class PieceZ extends Piece {
    private static Block [][] Z =  {{new Block('Z'), new Block('Z'), new Empty()},
            {new Empty(), new Block('Z'), new Block('Z')}
        };
    
    public PieceZ(){
        super(Z,0,0);
    }
}
