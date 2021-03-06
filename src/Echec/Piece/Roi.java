package Echec.Piece;

import Echec.Movement;
import Echec.Player;

import java.util.ArrayList;
import java.util.List;

public class Roi extends Piece {

    public Roi(Player p, int x, int y) {
        super(p, x, y, 'R');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> piecesJouable = player.getListPiece();

        int[][] condition = new int[][] {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

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