package Echec.module;

import Echec.module.Piece.*;

import java.util.Scanner;

public class Plateau {

    private Piece[][] bord;
    private Player p1;
    private Player p2;
    private boolean game;

    public Plateau(String namePlayer1, String namePlayer2) {
        bord = new Piece[8][8];
        game = true;
        this.p1 = new Player(1, namePlayer1);
        this.p2 = new Player(2, namePlayer2);

        for (Piece p : p1.getPionJouable()) {
            bord[p.getX()][p.getY()] = p;
        }
        for (Piece p : p2.getPionJouable()) {
            bord[p.getX()][p.getY()] = p;
        }
    }

    public void start() {
        System.out.println(this.toString());
        try (Scanner scan = new Scanner(System.in)){
            while (game){
                System.out.println("Player 1 : Choisisez une Pion :");
                String command = scan.nextLine();

                System.out.println(this.toString());
            }
        }

    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(p1.toString()).append("\n   A   B   C   D   E   F   G   H\n");
        for (int i = 0; i < 8; i++) {
            str.append(i).append(" ");
            for (int j = 0; j < 8; j++) {
                if (bord[i][j] == null) str.append("   ");
                else str.append(" ").append(bord[i][j].getIcon()).append(" ");
                if (j != 7) str.append("|");
            }
            if (i != 7) str.append("\n  -------------------------------\n");
        }
        str.append("\n").append(p2.toString());
        return str.toString();
    }

}
