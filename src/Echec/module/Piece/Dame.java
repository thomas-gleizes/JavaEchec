package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.List;

public class Dame extends Piece {

    public Dame(Player p, int x, int y) {
        super(p, x, y, 'D');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        return null;
    }
}
