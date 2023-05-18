/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.blocks;

/**
 *
 * @author berna
 */
public class BlockMatrix {

    protected Block[][] matrix;

    public BlockMatrix(Block[][] matrix) {
        int l = matrix.length;
        int c = matrix[0].length;
        this.matrix = new Block[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                this.matrix[i][j] = matrix[i][j].getClone();
            }
        }
    }

    public BlockMatrix() {
        this(new Block[][]{
            {new Empty()}

        }
        );
    }

    public BlockMatrix(BlockMatrix blockMat) {
        this(blockMat.matrix);
    }

    public Block[][] getMatrix() {
        return matrix;
    }

    public int getLines() {
        return matrix.length;
    }

    public int getColumns() {
        return matrix[0].length;
    }

    public void rotate() {
        Block[][] aux = new Block[getColumns()][getLines()];
        //transposta
        for (int l = 0; l < getLines(); l++) {
            for (int c = 0; c < getColumns(); c++) {
                aux[c][l] = matrix[l][c];
            }
        }
        //Espelhar
        int laux = aux.length;
        int caux = aux[0].length;

        for (int l = 0; l < laux; l++) {
            for (int c = 0; c < caux / 2; c++) {
                Block temp = aux[l][c];
                aux[l][c] = aux[l][caux - c - 1];
                aux[l][caux - c - 1] = temp;
            }
        }
        matrix = aux;

    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<getLines(); i++) {
            for (int j = 0; j < getColumns(); j++) 
                str.append(matrix[i][j]);
            str.append("\n");
        }
        return str.toString();
    }

    public BlockMatrix getClone() {
        return new BlockMatrix(this);
    }

    public static void main(String[] args) {
        Block bl[][] = {
            {new Block('L'), new Empty()},
            {new Block('L'), new Empty()},
            {new Block('L'), new Block('L')},};
        BlockMatrix b1 = new BlockMatrix(bl);
        BlockMatrix b2 = b1.getClone();

        System.out.println("b1\n" + b1);
        System.out.println("b2\n" + b2);

        System.out.println("N. Linhas " + b1.getLines());
        System.out.println("N. colunas " + b1.getColumns());

        b2.rotate();
        System.out.println("Original b1\n" + b1);
        System.out.println("Rotate b2\n" + b2);
    }
}
