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

import tetris.lib.game.Board;

/**
 * Created on 01/05/2023, 08:58:27
 *
 * @author IPT - computer
 * @version 1.0
 */
public class TesteBoard {

    public static void main(String[] args) {
        Board b = new Board(10, 10);
        System.out.println("ORIGINAL \n" + b);
        for (int i = 0; i < 100; i++) {
            b.moveLeft();
        }
        b.moveLeft();
        System.out.println("Left \n" + b);
        for (int i = 0; i < 100; i++) {
            b.moveRight();
        }
        System.out.println("Right \n" + b);
        b.fallDown();
        System.out.println("FALL \n" + b);
        b.freezePiece();
        b.generateRandomPiece();
        System.out.println("Random \n" + b);

    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010858L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
