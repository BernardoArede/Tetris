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
package tetris.lib.blocks;

import java.awt.Color;

/**
 * Created on 26/04/2023, 04:06:26
 * 
 * Empty Block
 *
 * @author berna
 */
public class Empty extends Block {
    /**
     * Construtor que passa a cor branca para os blocos vazios
     */
    public Empty() {
        super('.',Color.WHITE);
    }
    /**
     * garante a clonagem de blocos vazios 
     * @return um nova instancia do empty
     */
    @Override
    public Block getClone() {
        return new Empty();
    }

}
