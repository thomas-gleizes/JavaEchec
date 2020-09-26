package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece {

    public Pion(Player p, int x, int y) {
        super(p, x, y, 'O');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();

        int numPlayer = player.getNum();
        if (x == 0 || x == 7) return listMovement;

        if (player.getNbCoups() == 0) {
            int tx1;
            int tx2;
            if (numPlayer == 2) {
                tx1 = -2;
                tx2 = -1;
            } else {
                tx1 = 1;
                tx2 = 2;
            }
            listMovement.add(new Movement(this, x, y, x + tx1, y));
            listMovement.add(new Movement(this, x, y, x + tx2, y));
        } else {
            int tx = numPlayer == 2 ? -1 : 1;
            if (y != 7) if (!player.getListPiece().contains(bord[x + tx][y + 1])) {
                if (bord[x + tx][y + 1] != null) {
                    listMovement.add(new Movement(this, x, y, x + tx, y + 1));
                }
            }
            if (y != 0) if (!player.getListPiece().contains(bord[x + tx][y - 1])) {
                if (bord[x + tx][y - 1] != null) {
                    listMovement.add(new Movement(this, x, y, x + tx, y - 1));
                }
            }
            if (!player.getListPiece().contains(bord[x + tx][y])) {
                listMovement.add(new Movement(this, x, y, x + tx, y));
            }
        }
        return listMovement;
    }

}