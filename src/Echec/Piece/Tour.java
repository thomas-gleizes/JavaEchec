package Echec.Piece;

import Echec.Movement;
import Echec.Player;

import java.util.ArrayList;
import java.util.List;

public class Tour extends Piece {

    public Tour(Player p, int x, int y) {
        super(p, x, y, 'T');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> pieceJouable = player.getListPiece();

        for (int i = x + 1; i < 8; i++) {
            if (!pieceJouable.contains(bord[i][y])) {
                listMovement.add(new Movement(this, getX(), getY(), i, y, bord[i][y]));
                if (bord[i][y] != null) break;
            } else break;
        }

        for (int i = y + 1; i < 8; i++) {
            if (!pieceJouable.contains(bord[x][i])) {
                listMovement.add(new Movement(this, getX(), getY(), x, i, bord[x][i]));
                if (bord[x][i] != null) break;
            } else break;
        }

        for (int i = x - 1; i >= 0; i--) {
            if (!pieceJouable.contains(bord[i][y])) {
                listMovement.add(new Movement(this, getX(), getY(), i, y, bord[i][y]));
                if (bord[i][y] != null) break;
            } else break;
        }

        for (int i = y - 1; i >= 0; i--) {
            if (!pieceJouable.contains(bord[x][i])) {
                listMovement.add(new Movement(this, getX(), getY(), x, i, bord[x][i]));
                if (bord[x][i] != null) break;
            } else break;
        }

        return listMovement;
    }

}