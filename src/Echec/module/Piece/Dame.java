package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.ArrayList;
import java.util.List;

public class Dame extends Piece {

    public Dame(Player p, int x, int y) {
        super(p, x, y, 'D', "Dame");
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> pieceJouable = player.getPieceJouable();

        //TODO Ajouter la partie du Fou

        for (int i = x + 1; i < 8; i++) {
            if (!pieceJouable.contains(bord[i][y])) {
                listMovement.add(new Movement(this, getX(), getY(), i, y));
                if (bord[i][y] != null){
                    break;
                }
            } else break;
        }

        for (int i = y + 1; i < 8; i++) {
            if (!pieceJouable.contains(bord[x][i])) {
                listMovement.add(new Movement(this, getX(), getY(), x, i));
                if (bord[x][i] != null) break;
            } else break;
        }

        for (int i = x - 1; i >= 0; i--) {
            if (!pieceJouable.contains(bord[i][y])) {
                listMovement.add(new Movement(this, getX(), getY(), i, y));
                if (bord[i][y] != null) break;
            } else break;
        }

        for (int i = y - 1; i >= 0; i--) {
            if (!pieceJouable.contains(bord[x][i])) {
                listMovement.add(new Movement(this, getX(), getY(), x, i));
                if (bord[x][i] != null) break;
            } else break;
        }

        return listMovement;
    }
}
