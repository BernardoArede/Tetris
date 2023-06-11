
package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Created on 01/05/2023, 08:20:18
 *
 * @author berna
 */
public class PieceJ extends Piece {

    public static Block[][] J = {
        {new Block('J',Color.BLUE), new Empty()},
        {new Block('J',Color.BLUE), new Empty()},
        {new Block('J',Color.BLUE), new Block('J',Color.BLUE)}
    };
 /**
    * Construtor da classe PieceJ, passando a matriz J com a poisção y a 0 e x também a 0 
    */
    public PieceJ() {
        super(J, 0, 0);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
