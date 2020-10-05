package Echec.module;

import Echec.module.Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int num;
    private final String name;
    private final String color;
    private final List<Piece> listPiece;
    private List<Movement> listMovement;
    private int nbCoups;

    public Player(int num, String name) {
        this.num = num;
        this.name = name;
        nbCoups = 0;
        listPiece = new ArrayList<>();
        listMovement = new ArrayList<>();

        if (num == 1) {
            color = "\u001B[32m";
            listPiece.add(new Cavalier(this, 0, 1));
            listPiece.add(new Cavalier(this, 0, 6));
            listPiece.add(new Tour(this, 0, 0));
            listPiece.add(new Tour(this, 0, 7));
            listPiece.add(new Fou(this, 0, 2));
            listPiece.add(new Fou(this, 0, 5));
            listPiece.add(new Dame(this, 0, 3));
            listPiece.add(new Roi(this, 0, 4));
            for (int i = 0; i < 8; i++) {
                listPiece.add(new Pion(this, 1, i));
            }
        } else {
            color = "\u001B[31m";
            listPiece.add(new Cavalier(this, 7, 1));
            listPiece.add(new Cavalier(this, 7, 6));
            listPiece.add(new Tour(this, 7, 0));
            listPiece.add(new Tour(this, 7, 7));
            listPiece.add(new Fou(this, 7, 2));
            listPiece.add(new Fou(this, 7, 5));
            listPiece.add(new Dame(this, 7, 3));
            listPiece.add(new Roi(this, 7, 4));
            for (int i = 0; i < 8; i++) {
                listPiece.add(new Pion(this, 6, i));
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

    public List<Piece> getListPiece() {
        return listPiece;
    }

    public String getColor() {
        return color;
    }

    public void addCoup() {
        nbCoups++;
    }

    public boolean haveKing(){
        for (Piece p : listPiece)
            if (p.equals(new Roi(this, p.getX(), p.getY()))) return true;
        return false;
    }

    public void addMovement(Movement m){
        listMovement.add(m);
    }

    public void removeLastMovement(){
        listMovement.remove(listMovement.size() - 1);
    }

    public List<Movement> getListMovement (){
        return listMovement;
    }

    public List<Piece> getPionJouable (Piece[][] bord){
        List<Piece> pionJouable = new ArrayList<>();
        for (Piece p : listPiece){
            if (p.getMovePossible(bord).size() > 0) pionJouable.add(p);
        }
        return pionJouable;
    }

    @Override
    public String toString() {
        return color + "\nPlayer : " + num + "\n" +
                "Name : " + name + "\n" +
                "Nombre de coup(s) : " + nbCoups + "\n" +
                "Nombre de pion(s) perdu(s) : " + (16 - listPiece.size()) + "\n" +
                "Movement précedent : " + displayListLastMovement(5) +
                "\u001B[0m \n";
    }

    public String displayListLastMovement(int n){
        StringBuilder str = new StringBuilder();
        int index, i;
        for (index = listMovement.size() - 1, i = 0; i < n && index >= 0; index--, i++) {
            str.append(listMovement.get(index).displayForList());
            if (index != 0 && i != 1) str.append(", ");
        }
        return str.toString();
    }

}