package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece {

    public Fou(Player p, int x, int y) {
        super(p, x, y, 'F', "Fou");
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        List<Movement> listMovement = new ArrayList<>();
        List<Piece> piecesJouable = player.getPieceJouable();
        int i, j;
        j = y + 1;
        for (i = x + 1; i < 8; i++, j++){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }
        i = x + 1;
        for (j = y - 1; j < 8; i++, j--){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }
        j = y + 1;
        for (i = x - 1; i >= 0; i--, j++){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }
        i = x - 1;
        for (j = y - 1; i >= 0; i--, j--){
            if (!piecesJouable.contains(bord[i][j])){
                listMovement.add(new Movement(this, getX(), getY(), i, j));
                if (bord[i][j] != null) break;
            } else break;
        }

        return listMovement;
    }
}
