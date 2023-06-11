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
package tetris.lib.utils;

import java.util.Random;
import tetris.lib.pieces.Piece;
import tetris.lib.pieces.PieceJ;
import tetris.lib.pieces.PieceL;
import tetris.lib.pieces.PieceO;
import tetris.lib.pieces.PieceS;
import tetris.lib.pieces.PieceT;
import tetris.lib.pieces.PieceZ;

/**
 * Created on 01/05/2023, 09:24:11
 *
 *
 * Enumeração com as peças do Tetris
 *
 * @author berna
 * 
 */
public enum TetrisPiece {
    L(new PieceL()),
    O(new PieceO()),
    S(new PieceS()),
    Z(new PieceZ()),
    J(new PieceJ()),
    T(new PieceT()),
    I(new PieceT()),
    
    ;

    Piece piece;

    private TetrisPiece(Piece piece) {
        this.piece = piece;
    }
    //random generator
    private static Random rnd = new Random();

    /**
     * get random piece
     *
     * @return
     */
    public static Piece generateRandom() {
        return switch (rnd.nextInt(0,6)) {
            case 0 ->
                L.piece.getClone();
            case 1 ->
                O.piece.getClone();
            case 2 ->
                S.piece.getClone();
            case 3 ->
                Z.piece.getClone();
            case 4 ->
                J.piece.getClone();
            case 5 ->
                I.piece.getClone();
            case 6 ->
                T.piece.getClone();
            default ->
                I.piece.getClone();
        };
    }

}
