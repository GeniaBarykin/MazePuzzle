package Assigment3.Labyrinth;

import java.util.ArrayList;

public class Maze {
    public Position getPosition(int id) {
        return positions.get(id - 1);
    }

    protected ArrayList<Position> positions = new ArrayList<>();

    public void build() {
        //Fill with positions
        positions.clear();
        for (int i = 1; i <= 23; i++) {
            Position pos;
            switch (i) {
                case 1:
                    pos = new Position(i, Color.color.PURPLE);
                    break;
                case 2:
                    pos = new Position(i, Color.color.BLACK);
                    break;
                case 3:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 4:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 5:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 6:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 7:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 8:
                    pos = new Position(i, Color.color.PURPLE);
                    break;
                case 9:
                    pos = new Position(i, Color.color.PURPLE);
                    break;
                case 10:
                    pos = new Position(i, Color.color.BLACK);
                    break;
                case 11:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 12:
                    pos = new Position(i, Color.color.PURPLE);
                    break;
                case 13:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 14:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 15:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 16:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 17:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 18:
                    pos = new Position(i, Color.color.BLACK);
                    break;
                case 19:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 20:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 21:
                    pos = new Position(i, Color.color.BLACK);
                    break;
                case 22:
                    pos = new Position(i, Color.color.BLACK);
                    break;
                default:
                    pos = new Position(i, Color.color.BLUE);
            }
            positions.add(pos);

        }
        //Connect positions with arrows
        for (int i = 1; i <= 23; i++) {
            Position pos = positions.get(i - 1);
            switch (i) {
                case 1:
                    pos.addWayOut(getPosition(4), Color.color.PURPLE);
                    pos.addWayOut(getPosition(5), Color.color.BLACK);
                    break;
                case 2:
                    pos.addWayOut(getPosition(6), Color.color.GREEN);
                    pos.addWayOut(getPosition(12), Color.color.PURPLE);
                    break;
                case 3:
                    pos.addWayOut(getPosition(1), Color.color.ORANGE);
                    pos.addWayOut(getPosition(4), Color.color.ORANGE);
                    break;
                case 4:
                    pos.addWayOut(getPosition(13), Color.color.BLACK);
                    break;
                case 5:
                    pos.addWayOut(getPosition(9), Color.color.ORANGE);
                    break;
                case 6:
                    pos.addWayOut(getPosition(9), Color.color.GREEN);
                    pos.addWayOut(getPosition(10), Color.color.PURPLE);
                    break;
                case 7:
                    pos.addWayOut(getPosition(2), Color.color.GREEN);
                    break;
                case 8:
                    pos.addWayOut(getPosition(3), Color.color.PURPLE);
                    break;
                case 9:
                    pos.addWayOut(getPosition(4), Color.color.GREEN);
                    pos.addWayOut(getPosition(14), Color.color.BLACK);
                    break;
                case 10:
                    pos.addWayOut(getPosition(15), Color.color.GREEN);
                    break;
                case 11:
                    pos.addWayOut(getPosition(10), Color.color.PURPLE);
                    pos.addWayOut(getPosition(12), Color.color.GREEN);
                    break;
                case 12:
                    pos.addWayOut(getPosition(7), Color.color.GREEN);
                    break;
                case 13:
                    pos.addWayOut(getPosition(8), Color.color.GREEN);
                    pos.addWayOut(getPosition(18), Color.color.GREEN);
                    break;
                case 14:
                    pos.addWayOut(getPosition(23), Color.color.GREEN);
                    pos.addWayOut(getPosition(20), Color.color.ORANGE);
                    break;
                case 15:
                    pos.addWayOut(getPosition(22), Color.color.GREEN);
                    pos.addWayOut(getPosition(23), Color.color.PURPLE);
                    break;
                case 16:
                    pos.addWayOut(getPosition(15), Color.color.GREEN);
                    break;
                case 17:
                    pos.addWayOut(getPosition(16), Color.color.BLACK);
                    pos.addWayOut(getPosition(11), Color.color.BLACK);
                    pos.addWayOut(getPosition(12), Color.color.PURPLE);
                    break;
                case 18:
                    pos.addWayOut(getPosition(9), Color.color.ORANGE);
                    pos.addWayOut(getPosition(20), Color.color.ORANGE);
                    break;
                case 19:
                    pos.addWayOut(getPosition(18), Color.color.GREEN);
                    break;
                case 20:
                    pos.addWayOut(getPosition(19), Color.color.BLACK);
                    pos.addWayOut(getPosition(21), Color.color.ORANGE);
                    break;
                case 21:
                    pos.addWayOut(getPosition(23), Color.color.BLACK);
                    pos.addWayOut(getPosition(22), Color.color.ORANGE);
                    break;
                case 22:
                    pos.addWayOut(getPosition(17), Color.color.ORANGE);
                    break;
            }
        }
    }
}
