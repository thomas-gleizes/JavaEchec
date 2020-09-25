package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.ArrayList;
import java.util.List;

public class Dame extends Piece {

    public Dame(Player p, int x, int y) {
        super(p, x, y, 'D');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> piecesJouable = player.getPieceJouable();

        int i, j;

        for (i = x + 1; i < 8; i++) {
            if (!piecesJouable.contains(bord[i][y])) {
                listMovement.add(new Movement(this, getX(), getY(), i, y));
                if (bord[i][y] != null){
                    break;
                }
            } else break;
        }

        for (i = y + 1; i < 8; i++) {
            if (!piecesJouable.contains(bord[x][i])) {
                listMovement.add(new Movement(this, getX(), getY(), x, i));
                if (bord[x][i] != null) break;
            } else break;
        }

        for (i = x - 1; i >= 0; i--) {
            if (!piecesJouable.contains(bord[i][y])) {
                listMovement.add(new Movement(this, getX(), getY(), i, y));
                if (bord[i][y] != null) break;
            } else break;
        }

        for (i = y - 1; i >= 0; i--) {
            if (!piecesJouable.contains(bord[x][i])) {
                listMovement.add(new Movement(this, getX(), getY(), x, i));
                if (bord[x][i] != null) break;
            } else break;
        }

        for (i = x + 1, j = y + 1; i < 8; i++, j++){
            if (j >= 8) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            }
        }

        for (i = x + 1, j = y - 1; i < 8; i++, j--){
            if (j < 0) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            }
        }

        for (i = x - 1, j = y - 1; i >= 0; i--, j--){
            if (j < 0) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            }
        }

        for (i = x - 1, j = y + 1; i >= 0; i--, j++){
            if (j >= 8) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            }
        }

        return listMovement;
    }
}
