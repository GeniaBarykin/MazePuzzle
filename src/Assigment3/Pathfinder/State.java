package Assigment3.Pathfinder;

import Assigment3.Labyrinth.Color;
import Assigment3.Labyrinth.Position;

public class State {
    public Position getPos1() {
        return pos1;
    }

    public Position getPos2() {
        return pos2;
    }

    private Position pos1, pos2;

    public State(Position p1Pos, Position p2Pos) {
        this.pos1 = p1Pos;
        this.pos2 = p2Pos;
    }

    @Override
    public String toString() {
        return "(" + pos1.getId() + "," + pos2.getId() + ")";
    }

    public boolean compare(State anotherState) {
        if ((pos1.equals(anotherState.getPos1())
                && pos2.equals(anotherState.getPos2()))
                || (pos1.equals(anotherState.getPos2())
                        && pos2.equals(anotherState.getPos1()))
        ) {
            return true;
        }
        return false;
    }

    public boolean isOnFinish() {
        if (pos1.getColor().equals(Color.color.BLUE)
                || pos2.getColor().equals(Color.color.BLUE)) {
            return true;
        }
        return false;
    }
}
