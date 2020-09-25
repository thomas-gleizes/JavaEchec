package Echec.module;

import Echec.module.Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int num;
    private final String name;
    private final String color;
    private final List<Piece> pionJouable;
    private List<Movement> listMovement;
    private int nbCoups;

    public Player(int num, String name) {
        this.num = num;
        this.name = name;
        nbCoups = 0;
        pionJouable = new ArrayList<>();
        listMovement = new ArrayList<>();

        if (num == 1) {
            color = "\u001B[32m";
            pionJouable.add(new Cavalier(this, 0, 1));
            pionJouable.add(new Cavalier(this, 0, 6));
            pionJouable.add(new Tour(this, 0, 0));
            pionJouable.add(new Tour(this, 0, 7));
            pionJouable.add(new Fou(this, 0, 2));
            pionJouable.add(new Fou(this, 0, 5));
            pionJouable.add(new Dame(this, 0, 3));
            pionJouable.add(new Roi(this, 0, 4));
            for (int i = 0; i < 8; i++) {
                pionJouable.add(new Pion(this, 1, i));
            }
        } else {
            color = "\u001B[31m";
            pionJouable.add(new Cavalier(this, 7, 1));
            pionJouable.add(new Cavalier(this, 7, 6));
            pionJouable.add(new Tour(this, 7, 0));
            pionJouable.add(new Tour(this, 7, 7));
            pionJouable.add(new Fou(this, 7, 2));
            pionJouable.add(new Fou(this, 7, 5));
            pionJouable.add(new Dame(this, 7, 3));
            pionJouable.add(new Roi(this, 7, 4));
            for (int i = 0; i < 8; i++) {
                pionJouable.add(new Pion(this, 6, i));
            }
        }

    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getNbCoups() {
        return nbCoups;
    }

    public List<Piece> getPieceJouable() {
        return pionJouable;
    }

    public String getColor() {
        return color;
    }

    public void addCoup() {
        nbCoups++;
    }

    public boolean haveKing(){
        for (Piece p : pionJouable)
            if (p.equals(new Roi(this, p.getX(), p.getY()))) return true;
        return false;
    }

    public String toString() {
        return color + "\nPlayer : " + num + "\n" +
                "Name : " + name + "\n" +
                "Nombre de coup(s) : " + nbCoups + "\n" +
                "Nombre de pion(s) perdu(s) : " + (16 - pionJouable.size()) +
                "\u001B[0m \n";
    }

}
