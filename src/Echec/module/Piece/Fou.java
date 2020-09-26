package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece {

    public Fou(Player p, int x, int y) {
        super(p, x, y, 'F');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> piecesJouable = player.getPieceJouable();

        int i, j;

        for (i = x, j = y; i < 8; i++, j++){
            if (j >= 8) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }

        for (i = x, j = y; i < 8; i++, j--){
            if (j < 0) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }

        for (i = x, j = y; i >= 0; i--, j--){
            if (j < 0) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }

        for (i = x, j = y; i >= 0; i--, j++){
            if (j >= 8) break;
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }

        return listMovement;
    }

}