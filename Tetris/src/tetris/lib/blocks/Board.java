package tetris.lib.blocks;

import tetris.lib.blocks.Block;
import tetris.lib.blocks.BlockMatrix;
import tetris.lib.blocks.Empty;
import tetris.lib.pieces.*;

import java.util.Random;

public class Board extends BlockMatrix {

    private Piece current;

    public Board(Block[][] mat, Piece current) {
        super(mat);
        this.current = current;
    }

    public Board(Board b) {
        this(b.matrix, b.current);
    }

    public Board(int lines, int columns) {
        this.matrix = new Block[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                super.matrix[i][j] = new Empty();
            }
        }
        this.generateRandomPiece();
    }

    public Piece getCurrent() {
        return current;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }

    public void generateRandomPiece() {
        Random rand = new Random();
        int r = rand.nextInt(7);
        switch (r) {
            case 0 ->
                this.setCurrent(new PieceI());
            case 1 ->
                this.setCurrent(new PieceJ());
            case 2 ->
                this.setCurrent(new PieceL());
            case 3 ->
                this.setCurrent(new PieceO());
            case 4 ->
                this.setCurrent(new PieceS());
            case 5 ->
                this.setCurrent(new PieceT());
            case 6 ->
                this.setCurrent(new PieceZ());
        }
        this.current.setX(this.getColumns() / 2 - this.current.getColumns() / 2);
        this.current.setY(0);
    }

    public void freezePiece() {
        for (int i = 0; i < this.current.getLines(); i++) {
            for (int j = 0; j < this.current.getColumns(); j++) {
                if (!(this.current.getMatrix()[i][j] instanceof Empty)) {
                    this.matrix[this.current.getY() + i][this.current.getX() + j] = this.current.getMatrix()[i][j];
                }
            }
        }
       
    }

    public boolean canMovePiece(int dX, int dY) {
        for (int i = 0; i < this.current.getLines(); i++) {
            for (int j = 0; j < this.current.getColumns(); j++) {
                if (!(this.current.getMatrix()[i][j] instanceof Empty)) {
                    int newX = this.current.getX() + j + dY;
                    int newY = this.current.getY() + i + dX;

                    if (newX >= this.getColumns() || newX < 0 || newY >= this.getLines()) {
                        return false;
                    }
                    if (!(this.matrix[newY][newX] instanceof Empty)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canRotatePiece() {
        Piece rotated = current.getClone();
        rotated.rotate();
        Block[][] blocks = rotated.getMatrix();

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if (!(blocks[i][j] instanceof Empty)) {
                    int x = current.getLines() + j;
                    int y = current.getColumns() + i;

                    if (x < 0 || x >= getColumns() || y >= getLines()) {
                        return false;
                    }
                    if (!(getMatrix()[y][x] instanceof Empty)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void moveLeft() {
        if (canMovePiece(0, -1)) {
            current.moveLeft();
        }
    }

    public void moveRight() {
        if (canMovePiece(0, 1)) {
            current.moveRight();
        }
    }

    public void moveDown() {
        if (canMovePiece(1, 0)) {
            current.moveDown();
        }
    }

    public void rotate() {
        if (canRotatePiece()) {
            current.rotate();
        }
    }

    public void fallDown() {
        while (canMovePiece(1, 0)) {
            current.moveDown();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Board bo = new Board(this);
        bo.freezePiece();

        for (int i = 0; i < this.getLines(); ++i) {
            for (int j = 0; j < this.getColumns(); ++j) {
                sb.append(bo.matrix[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

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
}
