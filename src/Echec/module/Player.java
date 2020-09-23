package Echec.module;

import Echec.module.Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int num;
    private String name;
    private int nbCoups;
    private String color;
    private List<Piece> pionJouable;
    private List<Piece> pionPerdu;

    public Player(int num, String name) {
        this.num = num;
        this.name = name;
        nbCoups = 0;
        pionJouable = new ArrayList<>();

        if (num == 1){
            color = "\u001B[31m";
            for (int i = 0; i < 8; i++) {
                pionJouable.add(new Pion(this, 1, i));
            }
            pionJouable.add(new Cavalier(this, 0, 1));
            pionJouable.add(new Cavalier(this, 0, 6));
            pionJouable.add(new Tour(this, 0, 0));
            pionJouable.add(new Tour(this, 0, 7));
            pionJouable.add(new Fou(this, 0, 2));
            pionJouable.add(new Fou(this, 0, 5));
            pionJouable.add(new Reine(this, 0, 3));
            pionJouable.add(new Roi(this, 0, 4));
        } else {
            color = "\u001B[32m";
            for (int i = 0; i < 8; i++) {
                pionJouable.add(new Pion(this, 6, i));
            }
            pionJouable.add(new Cavalier(this,7, 1));
            pionJouable.add(new Cavalier(this, 7, 6));
            pionJouable.add(new Tour(this, 7, 0));
            pionJouable.add(new Tour(this, 7, 7));
            pionJouable.add(new Fou(this, 7, 2));
            pionJouable.add(new Fou(this, 7, 5));
            pionJouable.add(new Reine(this, 7, 3));
            pionJouable.add(new Roi(this, 7, 4));
        }

        pionPerdu = new ArrayList<>();
    }

    public List<Piece> getPionJouable (){
        return pionJouable;
    }

    public String getColor (){
        return color;
    }

    public String toString(){
        return color + "\nPlayer : " + num + "\n" +
                "Name : " + name + "\n" +
                "Nombre de coup(s) : " +  nbCoups + "\n" +
                "Nombre de pion(s) perdu(s) : " + pionPerdu.size() +
                "\u001B[0m \n";
    }
}
