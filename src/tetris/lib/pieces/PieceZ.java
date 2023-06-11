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
package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Created on 01/05/2023, 08:20:18
 *
 * @author berna

 */
public class PieceZ extends Piece {

    public static Block[][] Z = {
        {new Block('Z',Color.RED), new Block('Z',Color.RED), new Empty()},
        {new Empty(), new Block('Z',Color.RED), new Block('Z',Color.RED)}

    };
/**
    * Construtor da classe PieceZ, passando a matriz Z com a poisção y a 0 e x também a 0 
    */
    public PieceZ() {
        super(Z, 0, 0);
    }

  
}