/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tetris.gui;

import java.util.EventListener;
import tetris.lib.game.TetrisGame;

/**
 *
 * @author berna
 */
public interface Listener extends EventListener {
    
    /**
     *
     * @param score
     */
    public void score(TetrisGame score);
   
    
    
}
