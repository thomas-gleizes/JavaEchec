package Echec.Piece;

import Echec.Movement;
import Echec.Player;

import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece {

    public Cavalier(Player p, int x, int y) {
        super(p, x, y, 'C');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> piecesJouable = player.getListPiece();

        int[][] condition = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}, {2, -1}};

        for (int[] c : condition){
            int dx = c[0] + x;
            int dy = c[1] + y;
            if (((dx >= 0) && (dx <= 7)) && ((dy >= 0) && (dy <= 7))){
                if (!piecesJouable.contains(bord[dx][dy])){
                    listMovement.add(new Movement(this, x, y, dx, dy, bord[dx][dy]));
                }
            }
        }
        return listMovement;
    }

}