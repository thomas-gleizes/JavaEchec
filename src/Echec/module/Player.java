package Echec.module;

import Echec.module.Piece.Pion;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int num;
    private String name;
    private int nbCoups;
    private List<Pion> pionJouable;
    private List<Pion> pionPerdu;

    public Player(int num, String name) {
        this.num = num;
        this.name = name;
        nbCoups = 0;
        pionJouable = new ArrayList<>();

        int x = num == 1 ? 1 : 6;

        for (int i = 0; i < 8; i++) {
            pionJouable.add(new Pion(x, i));
        }

        pionPerdu = new ArrayList<>();
    }

    public List<Pion> getPionJouable (){
        return pionJouable;
    }

    public String toString(){
        String color = this.num == 1 ? "\u001B[31m" : "\u001B[32m";
        return  color + "\nPlayer : " + num + "\n" +
                "Name : " + name + "\n" +
                "Nombre de coup(s) : " +  nbCoups + "\n" +
                "Nombre de pion(s) perdu(s) : " + pionPerdu.size() +
                "\u001B[0m \n";
    }
}
