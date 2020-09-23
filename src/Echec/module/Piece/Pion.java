package Echec.module.Piece;

import Echec.module.Player;

public class Pion extends Piece {

    public Pion(Player p, int x, int y) {
        super(p, x, y, 'O');
    }

    public boolean moveTo(int tx, Piece[][] bord) {
        if (this.player.getNbCoups() == 0 && tx < 3) {
            this.x += tx;
            return true;
        } else if (tx == 1) {
            this.x += 1;
            return true;
        }
        return false;
    }
}
