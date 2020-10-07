package Echec.Piece;

import Echec.Movement;
import Echec.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private Movement movement;
    private Piece[][] bord;
    private Player currentPlayer;
    private Player otherPlayer;

    @BeforeEach
    void setUp(){
        currentPlayer = new Player(1, "Kalat");
        otherPlayer = new Player(2, "Talak");
        bord = new Piece[8][8];
    }

    @Test
    void moveTo() {
        currentPlayer.addCoup();

        Piece pion = new Pion(currentPlayer, 3, 3);
        Movement movement = new Movement(pion, pion.x, pion.y, 4, 3);

        bord[pion.x][pion.y] = pion;
        currentPlayer.getListPiece().add(pion);
        currentPlayer.addCoup();

        pion.moveTo(movement, bord);

        Piece[][] bordTest = new Piece[8][8];
        Piece pionTest = new Pion(currentPlayer, 4, 3);
        bordTest[4][3] = pionTest;

        assertEquals(bord[4][3], bordTest[4][3]);
    }

    @Test
    void moveToEnnemy(){
         
    }

}