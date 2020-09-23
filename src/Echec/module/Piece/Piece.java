package Echec.module.Piece;

import Echec.module.Player;

public abstract class Piece {

    protected Player player;
    protected int x;
    protected int y;
    private char icon;

    public Piece(Player p, int x, int y, char icon) {
        this.player = p;
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

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
