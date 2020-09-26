package Echec.module;

import Echec.module.Piece.Piece;

import java.util.Objects;

public class Movement {

    private final Piece p;
    private final int x;
    private final int y;
    private final int dx;
    private final int dy;

    public Movement(Piece p, int x, int y, int tx, int ty) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.dx = tx;
        this.dy = ty;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
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
                p.equals(movement.p);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, x, y, dx, dy);
    }

    @Override
    public String toString() {
        return Character.toString(dy + 65) + dx;
    }

}