package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.List;

public class Roi extends Piece {
    public Roi(Player p, int x, int y) {
        super(p, x, y, 'R');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        return null;
    }
}
