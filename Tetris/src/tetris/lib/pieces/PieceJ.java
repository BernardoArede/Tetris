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
public class PieceJ extends Piece {
    private static Block[][] J = {
       {new Block('J'),new Block('J'),new Block('J')},
       {new Empty(),new Empty(),new Block('J')}
    };
    
    public PieceJ(){
        super(J,0,0);
    }
}