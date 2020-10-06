package Echec.Piece;

import Echec.Movement;
import Echec.Player;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece {

    public Fou(Player p, int x, int y) {
        super(p, x, y, 'F');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> piecesJouable = player.getListPiece();

        int i, j;

        for (i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j, bord[i][j]));
                if (bord[i][j] != null) break;
            } else break;
        }

        for (i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j, bord[i][j]));
                if (bord[i][j] != null) break;
            } else break;
        }

        for (i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j, bord[i][j]));
                if (bord[i][j] != null) break;
            } else break;
        }

        for (i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j, bord[i][j]));
                if (bord[i][j] != null) break;
            } else break;
        }

        return listMovement;
    }

}