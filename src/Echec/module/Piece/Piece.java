package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.List;

public abstract class Piece {

    private String type;
    protected Player player;
    protected int x;
    protected int y;
    private char icon;

    public Piece(Player p, int x, int y, char icon, String type) {
        this.player = p;
        this.x = x;
        this.y = y;
        this.icon = icon;
        this.type = type;
    }

    public void moveTo(Movement m, Piece[][] bord, Player playerAdverse){
        player.addCoup();
        if (bord[m.getTx()][m.getTy()] != null) playerAdverse.getPieceJouable().remove(bord[m.getTx()][m.getTy()]);
        bord[x][y] = null;
        x = m.getTx();
        y = m.getTy();
        bord[m.getTx()][m.getTy()] = this;
    }

    public abstract List<Movement> getMovePossible(Piece[][] bord);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIcon() {
        return player.getColor() + icon + "\u001B[0m";
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }

    public String toString() {
        return "Player" + this.player.getNum() + " : " + this.player.getName() + "\n" +
                "X : " + this.x + "\nY : " + this.y;
    }
}
