package tetris.lib.pieces;

import tetris.lib.blocks.Block;
import tetris.lib.blocks.BlockMatrix;
import tetris.lib.blocks.Empty;

/**
 *
 * @author berna
 */
public class Piece extends BlockMatrix {

    private int linha;
    private int coluna;

    public Piece(Block[][] mat, int linha, int coluna) {
        super(mat);
        this.linha = linha;
        this.coluna = coluna;
    }

    public Piece(Piece p) {
        this(p.matrix, p.linha, p.coluna);
    }

    public void moveLeft() {
        this.coluna--;
    }

    public void moveRight() {
        this.coluna++;
    }

    public void moveDown() {
        this.linha++;
    }

    @Override
    public Piece getClone() {
        return new Piece(this);
    }

    public int getY() {
        return linha;
    }

    public void setY(int linha) {
        this.linha = linha;
    }

    public int getX() {
        return coluna;
    }

    public void setX(int coluna) {
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("(");
        str.append(linha);
        str.append(",");
        str.append(coluna);
        str.append(") \n");
        str.append(super.toString());
        return str.toString();
    }

}


