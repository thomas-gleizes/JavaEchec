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




        return listMovement;
    }
}
