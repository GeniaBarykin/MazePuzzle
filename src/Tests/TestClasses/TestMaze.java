package Tests.TestClasses;

import Assigment3.Labyrinth.Color;
import Assigment3.Labyrinth.Maze;
import Assigment3.Labyrinth.Position;

public class TestMaze extends Maze {

    public void build(boolean hasSolution) {
        //Fill with positions
        positions.clear();
        for (int i = 1; i <= 10; i++) {
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
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 5:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 6:
                    pos = new Position(i, Color.color.ORANGE);
                    break;
                case 7:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 8:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                case 10:
                    pos = new Position(i, Color.color.GREEN);
                    break;
                default:
                    pos = new Position(i, Color.color.BLUE);
            }
            super.positions.add(pos);

        }
        //Connect positions with arrows
        for (int i = 1; i <= 10 ; i++) {
            Position pos = super.positions.get(i - 1);
            switch (i) {
                case 1:
                    pos.addWayOut(super.getPosition(3), Color.color.ORANGE);
                    pos.addWayOut(super.getPosition(4), Color.color.BLACK);
                    pos.addWayOut(super.getPosition(5), Color.color.BLACK);
                    break;
                case 2:
                    pos.addWayOut(super.getPosition(6), Color.color.GREEN);
                    pos.addWayOut(super.getPosition(5), Color.color.ORANGE);
                    pos.addWayOut(super.getPosition(10), Color.color.ORANGE);
                    break;
                case 5:
                    pos.addWayOut(super.getPosition(8), Color.color.ORANGE);
                    break;
                case 7:
                    pos.addWayOut(super.getPosition(5), Color.color.ORANGE);
                    break;
                case 8:
                    pos.addWayOut(super.getPosition(7), Color.color.ORANGE);
                    if (hasSolution) {
                        pos.addWayOut(super.getPosition(9), Color.color.ORANGE);
                    }
                    break;
            }
        }
    }
}
