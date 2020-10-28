package Echec;

import Echec.Piece.Piece;

import java.util.Objects;

public class Movement {

    private final Piece currentPiece;
    private final Piece pieceEat;
    private final int x;
    private final int y;
    private final int dx;
    private final int dy;

    public Movement(Piece currentPiece, int x, int y, int dx, int dy, Piece pieceEat) {
        this.currentPiece = currentPiece;
        this.pieceEat = pieceEat;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Movement(Piece currentPiece, int x, int y, int dx, int dy) {
        this(currentPiece, x, y, dx, dy, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Piece getCurrentPiece(){
        return currentPiece;
    }

    public Piece getPieceEat (){
        return pieceEat;
    }

    public String displayForList(){
        String str = "{" + Character.toString(y + 65) + x +  " => " + Character.toString(dy + 65) + dx;
        if (pieceEat != null)
            str += pieceEat.getPlayer().getColor() + "(" + pieceEat.getIcon() + ")" + currentPiece.getPlayer().getColor();
        return str + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return x == movement.x &&
                y == movement.y &&
                dx == movement.dx &&
                dy == movement.dy &&
                currentPiece.equals(movement.currentPiece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPiece, x, y, dx, dy);
    }

    @Override
    public String toString() {
        return Character.toString(dy + 65) + dx;
    }

}