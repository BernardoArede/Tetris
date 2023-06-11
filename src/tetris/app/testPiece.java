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
package tetris.app;

import tetris.lib.pieces.Piece;
import tetris.lib.pieces.PieceS;

/**
 * Created on 26/04/2023, 04:26:03
 *
 * @author manso - computer
 */
public class testPiece {

    public static void main(String[] args) {
        Piece l = new PieceS();
        System.out.println("\nOriginal");
        System.out.println(l);
        System.out.println("\nRotate Right");
        l.rotate();
        System.out.println(l);

        for (int i = 0; i < 5; i++) {
            System.out.println("\nRotate");
            l.rotate();
            System.out.println(l);

        }

    }

}
