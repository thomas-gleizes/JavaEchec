package Echec;

import Echec.Piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plateau {

    private Piece[][] bord;
    private Player p1;
    private Player p2;
    private List<Movement> storyMovement;

    public Plateau(String namePlayer1, String namePlayer2) {
        bord = new Piece[8][8];
        storyMovement = new ArrayList<>();
        this.p1 = new Player(1, namePlayer1);
        this.p2 = new Player(2, namePlayer2);

        for (Piece p : p1.getListPiece()) {
            bord[p.getX()][p.getY()] = p;
        }
        for (Piece p : p2.getListPiece()) {
            bord[p.getX()][p.getY()] = p;
        }
    }

    public void start() {
        System.out.println(this);
        try (Scanner scan = new Scanner(System.in)) {
            int tx, ty;
            boolean game = true;
            Player currentPlayer = p2;
            while (game) {
                currentPlayer = currentPlayer.equals(p2) ? p1 : p2;
                boolean choice = true;
                while (choice) {
                    System.out.print("Choix du" + currentPlayer.getColor() + " Joueur " + currentPlayer.getNum() + "\u001B[0m : ");
                    String command = scan.nextLine() + "";
                    ty = command.charAt(0) - 65;
                    tx = command.charAt(1) - 48;
                    if (tx >= 0 && tx <= 7 && ty >= 0 && ty <= 7 && command.length() == 2) {
                        int index = currentPlayer.getListPiece().indexOf(bord[tx][ty]);
                        if (index != -1) {
                            Piece p = currentPlayer.getListPiece().get(index);
                            List<Movement> listMovementPossible = p.getMovePossible(bord);
                            if (listMovementPossible != null && !listMovementPossible.isEmpty()) {
                                boolean doMove = true;
                                while (doMove) {
                                    System.out.println("Movement Possible : " + listMovementPossible);
                                    command = scan.nextLine();
                                    ty = command.charAt(0) - 65;
                                    tx = command.charAt(1) - 48;
                                    Movement move = new Movement(p, p.getX(), p.getY(), tx, ty);
                                    for (Movement m : listMovementPossible) {
                                        if (m.equals(move)) {
                                            p.moveTo(m, bord);
                                            doMove = false;
                                            choice = false;
                                            addMovement(m);
                                            System.out.println("Mouvement Fait");
                                            System.out.println(this);
                                            game = !isFinish();
                                            break;
                                        }
                                    }
                                }
                            } else System.out.println("Cette piece ne peux pas bougé !");
                        } else System.out.println("Emplacement incorect !");
                    } else if (command.equals("RO")) {
                        if (!storyMovement.isEmpty()) {
                            rollBack();
                            choice = false;
                            System.out.println(this);
                        } else System.out.println("Rollback Impossible");
                    } else System.out.println("Coordonnée invalid");
                }
            }
            System.out.println("Fin de la partie !");
        }
    }

    public boolean isFinish() {
        if (!p1.haveKing()) {
            System.out.println("GG " + p2.getName());
            System.out.println(displayStoryMovement());
            return true;
        } else if (!p2.haveKing()) {
            System.out.println("GG " + p1.getName());
            System.out.println(displayStoryMovement());
            return true;
        }
        return false;
    }

    public void addMovement(Movement move) {
        Player p = move.getCurrentPiece().getPlayer();
        storyMovement.add(move);
        p.addMovement(move);
    }

    public Movement getLastMovement(){
        return storyMovement.get(storyMovement.size() - 1);
    }

    public void rollBack() {
        Movement lastMovement = getLastMovement();
        Player player = lastMovement.getCurrentPiece().getPlayer();
        Movement rollBack = new Movement(lastMovement.getCurrentPiece(), lastMovement.getDx(), lastMovement.getDy(), lastMovement.getX(), lastMovement.getY());
        lastMovement.getCurrentPiece().moveTo(rollBack, bord);
        bord[rollBack.getX()][rollBack.getY()] = lastMovement.getPieceEat();
        storyMovement.remove(lastMovement);
        player.removeLastMovement();
    }

    public String displayStoryMovement() {
        return "Historique des movement : \n" +
                p1.getColor() + "Player 1 [" + p1.displayListLastMovement(p1.getListMovement().size()) + "] \n" +
                p2.getColor() + "Player 2 [" + p2.displayListLastMovement(p1.getListMovement().size()) + "] \u001B[0m \n";
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(p1.toString()).append("\n   A   B   C   D   E   F   G   H\n");
        for (int i = 0; i < 8; i++) {
            str.append(i).append(" ");
            for (int j = 0; j < 8; j++) {
                if (bord[i][j] == null) str.append("   ");
                else str.append(" ").append(bord[i][j].displayIcon()).append(" ");
                if (j != 7) str.append("|");
            }
            str.append(" ").append(i);
            if (i != 7) str.append("\n  -------------------------------\n");
        }
        str.append("\n   A   B   C   D   E   F   G   H\n").append(p2.toString());
        return str.toString();
    }

}