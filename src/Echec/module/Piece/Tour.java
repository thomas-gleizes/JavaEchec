package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.List;

public class Tour extends Piece {

    public Tour(Player p, int x, int y) {
        super(p, x, y, 'T');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        return null;
    }
}
