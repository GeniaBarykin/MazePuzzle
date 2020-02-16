package Tests.TestClasses;

import Assigment3.Labyrinth.Arrow;
import Assigment3.Pathfinder.State;
import Assigment3.Pathfinder.Pathfinder;

import java.util.ArrayList;

public class TestPathFinder extends Pathfinder {

    public TestPathFinder(State state) {
        super(state);
    }

    public void compute(){}

    public void setCurrentRoad(ArrayList<State> road) {
        this.currentRoad = road;
    }

    public ArrayList<Arrow> getPossibleWays1(State currentState) {
        return super.getPossibleWays1(currentState);
    }

    public ArrayList<Arrow> getPossibleWays2(State currentState) {
        return super.getPossibleWays2(currentState);
    }
}
