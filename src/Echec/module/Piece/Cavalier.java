package Echec.module.Piece;

import Echec.module.Movement;
import Echec.module.Player;

import java.util.List;

public class Cavalier extends Piece {

    public Cavalier(Player p, int x, int y) {
        super(p, x, y, 'C');
    }

    @Override
    public List<Movement> getMovePossible(Piece[][] bord) {
        return null;
    }
}
