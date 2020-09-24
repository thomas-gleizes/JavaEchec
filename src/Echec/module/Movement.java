package Echec.module;

import Echec.module.Piece.Piece;

import java.util.Objects;

public class Movement {

    private final Piece p;
    private final int x;
    private final int y;
    private final int tx;
    private final int ty;

    public Movement(Piece p, int x, int y, int tx, int ty) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.tx = tx;
        this.ty = ty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return x == movement.x &&
                y == movement.y &&
                tx == movement.tx &&
                ty == movement.ty &&
                p.equals(movement.p);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, x, y, tx, ty);
    }

    @Override
    public String toString() {
        return "{" + Character.toString(ty + 65) + tx + "}";
    }

    public int getTx() {
        return tx;
    }

    public int getTy() {
        return ty;
    }

}
