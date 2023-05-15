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
public class PieceL extends Piece {
    private static Block [][]  L = {
        {new Block('L'),new Block('L'),new Block('L')},
        {new Block('L'),new Empty(),new Empty()}
    };
    
    public PieceL(){
        super(L,0,0);
    }
}
