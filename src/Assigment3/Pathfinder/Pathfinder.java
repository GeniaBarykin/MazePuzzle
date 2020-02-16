package Assigment3.Pathfinder;

import Assigment3.Labyrinth.Arrow;
import Assigment3.Labyrinth.Position;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public abstract class Pathfinder extends RecursiveAction {

    protected State currentState;
    protected ArrayList<State> currentRoad = new ArrayList<>();
    protected static ArrayList<ArrayList<State>> allRoads = new ArrayList<>();
    protected static ArrayList<ArrayList<State>> correctRoads = new ArrayList<>();

    public ArrayList<ArrayList<State>> getCorrectRoads() {
        return correctRoads;
    }
    public ArrayList<ArrayList<State>> getAllRoads() {
        return allRoads;
    }

    /**
     * Initial Constructor
     * @param state  to move in
     */
    public Pathfinder(State state) {
        clear();
        currentState=state;
    }

    /**
     * Constructor For the calculation on a new thread
     * @param currentRoad states we passed
     * @param state  to move in
     */
    protected Pathfinder(ArrayList<State> currentRoad, State state) {
        this.currentRoad.addAll(currentRoad);
        currentState=state;
    }

    public void compute(){}

    /**
     * Gives possible ways for the first pawn depending on a state.
     *
     * @param currentState current state
     * @return ArrayList<Arrow> of arrows that are same color with the position
     * of the second pawn and that do not lead to the dead end
     */
    protected ArrayList<Arrow> getPossibleWays1(State currentState) {
            Position pos1 = currentState.getPos1();
            Position pos2 = currentState.getPos2();
            ArrayList<Arrow> possibleWays1 = new ArrayList<>(); //get all arrows from the 1st pawn position
            for (Arrow wayOut1 :
                    pos1.getWayOut()) {
                if (wayOut1.getColor().equals(pos2.getColor())) { //compare color of an arrow to the color of 2nd pawn position
                    State nextState = new State(wayOut1.getLeadTo(), pos2);
                    if (causeNoLoop(nextState)) { //cycle detection
                        possibleWays1.add(wayOut1);
                    }
                }
            }
            return possibleWays1;
    }

    /**
     * Gives possible ways for the second pawn depending on a state..
     *
     * @param currentState current state
     * @return ArrayList<Arrow> of arrows that are same color with the position
     * of the first pawn and that do not lead to the dead end
     */
    protected ArrayList<Arrow> getPossibleWays2(State currentState) {
        Position pos1 = currentState.getPos1();
        Position pos2 = currentState.getPos2();
        ArrayList<Arrow> possibleWays2 = new ArrayList<>(); //get all arrows from the 2nd pawn position
        for (Arrow wayOut2 :
                pos2.getWayOut()) {
            if (wayOut2.getColor().equals(pos1.getColor())) { //compare color of an arrow to the color of 1st pawn position
                State nextState = new State(pos1, wayOut2.getLeadTo());
                if ( causeNoLoop(nextState)) { //cycle detection
                    possibleWays2.add(wayOut2);
                }
            }
        }
        return possibleWays2;
    }


    /**
     * Cycle detection
     * Checks that if next state was visited before
     *
     * @param nextState
     * @return boolean that the next state was already visited
     */
    private boolean causeNoLoop(State nextState) {
        for (State s :
                currentRoad) {
            if (s.compare(nextState)) {
                return false;
            }
        }
        return true;
    }

    private void clear() {
        currentRoad.clear();
        correctRoads.clear();
        allRoads.clear();
    }

    public String allRoadsToString() {
        String output = " roads with DEAD END (overall: "
                + allRoads.size() + ")";
        for (ArrayList<State> roads :
                allRoads) {
            output += "\n" + roads;
        }
        return output;
    }

    public String correctRoadsToString() {
        String output = " algorithm has found "
                + correctRoads.size()
                + " paths";
        int i = 0;
        for (ArrayList<State> path :
                correctRoads) {
            output += "\nPath #" + ++i + " takes " + path.size() + " stages\n";
            output += path;
        }
        return output;
    }

}
