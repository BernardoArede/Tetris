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

/**
 * Created on 01/05/2023, 08:20:18
 *
 * @author berna
 
 */
public class PieceO extends Piece {

    public static Block[][] O = {
        {new Block('O',Color.YELLOW), new Block('O',Color.YELLOW)},
        {new Block('O',Color.YELLOW), new Block('O',Color.YELLOW)}
    };
/**
    * Construtor da classe PieceO, passando a matriz O com a poisção y a 0 e x também a 0 
    */
    public PieceO() {
        super(O,0,0);
    }
    
  
}
