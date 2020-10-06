package Echec.Piece;

import Echec.Movement;
import Echec.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoiTest {

    private int x;
    private int y;
    private Player currentPlayer;
    private Player otherPlayer;
    private Piece[][] bord;
    private Piece roi;
    private List<Movement> listMovement;

    @BeforeEach
    void setUp() {
        currentPlayer = new Player(1, "Kalat");
        otherPlayer = new Player(2, "Talak");
        bord = new Piece[8][8];
        listMovement = new ArrayList<>();
    }

    @Test
    void getMovePossibleC3Empty() {
        x = 3;
        y = 2;
        roi = new Roi(currentPlayer, x, y);
        bord[x][y] = roi;
        currentPlayer.getListPiece().add(roi);

        listMovement.add(new Movement(roi, x, y, 4, 2));//C4
        listMovement.add(new Movement(roi, x, y, 4, 3));//D4
        listMovement.add(new Movement(roi, x, y, 3, 3));//D3
        listMovement.add(new Movement(roi, x, y, 2, 3));//D2
        listMovement.add(new Movement(roi, x, y, 2, 2));//C2
        listMovement.add(new Movement(roi, x, y, 2, 1));//B2
        listMovement.add(new Movement(roi, x, y, 3, 1));//B3
        listMovement.add(new Movement(roi, x, y, 4, 1));//B4

        assertEquals(roi.getMovePossible(bord), listMovement);
    }

    @Test
    void getMovePossibleB0Empty(){
        x = 0;
        y = 0;
        roi = new Roi(currentPlayer, x, y);
        bord[x][y] = roi;
        currentPlayer.getListPiece().add(roi);

        listMovement.add(new Movement(roi, x, y, 1, 0));//A1
        listMovement.add(new Movement(roi, x, y, 1, 1));//B1
        listMovement.add(new Movement(roi, x, y, 0, 1));//B0

        assertEquals(roi.getMovePossible(bord), listMovement);
    }

    @Test
    void getMovePossibleA3EnemyAlly(){
        x = 0;
        y = 3;
        roi = new Roi(currentPlayer, x, y);

        Piece tourEnemy = new Tour(otherPlayer, 1, 3);
        Piece pionAlly = new Pion(currentPlayer, 0, 2);

        currentPlayer.getListPiece().add(pionAlly);
        otherPlayer.getListPiece().add(tourEnemy);

        bord[1][3] = tourEnemy;
        bord[0][2] = pionAlly;

        listMovement.add(new Movement(roi, x, y, 1, 3, tourEnemy));
        listMovement.add(new Movement(roi, x, y, 1, 4));
        listMovement.add(new Movement(roi, x, y, 0, 4));
        listMovement.add(new Movement(roi, x, y, 1, 2));

        assertEquals(roi.getMovePossible(bord), listMovement);
    }


}