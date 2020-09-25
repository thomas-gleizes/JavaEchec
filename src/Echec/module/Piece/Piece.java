package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.List;
import java.util.Objects;

public abstract class Piece {

    protected Player player;
    protected int x;
    protected int y;
    private final char icon;

    public Piece(Player p, int x, int y, char icon) {
        this.player = p;
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

    public void moveTo(Movement m, Piece[][] bord, Player playerAdverse){
        player.addCoup();
        if (bord[m.getDx()][m.getDy()] != null) playerAdverse.getPieceJouable().remove(bord[m.getDx()][m.getDy()]);
        bord[x][y] = null;
        x = m.getDx();
        y = m.getDy();
        bord[m.getDx()][m.getDy()] = this;
    }

    public abstract List<Movement> getMovePossible(Piece[][] bord);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getIcon() {
        return player.getColor() + icon + "\u001B[0m";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return x == piece.x &&
                y == piece.y &&
                icon == piece.icon &&
                Objects.equals(player, piece.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, x, y, icon);
    }

    public String toString() {
        return "Player" + this.player.getNum() + " : " + this.player.getName() + "\n" +
                "X : " + this.x + "\nY : " + this.y;
    }

}