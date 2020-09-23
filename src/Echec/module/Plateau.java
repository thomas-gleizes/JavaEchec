package Echec.module;

import Echec.module.Piece.Pion;

public class Plateau {

    private Pion[][] bord;
    private Player p1;
    private Player p2;

    public Plateau (String namePlayer1, String namePlayer2){
        bord = new Pion[8][8];
        this.p1 = new Player(1, namePlayer1);
        this.p2 = new Player(2, namePlayer2);

        for (Pion p : p1.getPionJouable()){
            bord[p.getX()][p.getY()] = p;
        }


    }




    @Override
    public String toString (){
        StringBuilder str = new StringBuilder();
        str.append(p1.toString()).append("\n");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (bord[i][j] == null) str.append(" ");
                else str.append(bord[i][j].getIcon());
                if (j != 7) str.append("|");
            }
            if (i != 7) str.append("\n---------------\n");
        }
        str.append("\n").append(p2.toString());
        return str.toString();
    }

}
