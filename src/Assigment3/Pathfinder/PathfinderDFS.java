package Assigment3.Pathfinder;

import Assigment3.Labyrinth.Arrow;
import Assigment3.Labyrinth.Position;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinTask;

public class PathfinderDFS extends Pathfinder {
    public PathfinderDFS(State state) {
        super(state);
        System.out.println("\nDFS start:");
    }

    private PathfinderDFS(ArrayList<State> currentRoad, State state) {
        super(currentRoad, state);
    }

    public void compute() {
        Position pos1 = currentState.getPos1();
        Position pos2 = currentState.getPos2();
        currentRoad.add(currentState);
        //Check if this state is on finish
        if (currentState.isOnFinish()) {
            correctRoads.add(currentRoad);
            allRoads.add(currentRoad);
        } else {
            State nextState; //Possible next state
            ArrayList<Arrow> possibleWays1 = getPossibleWays1(currentState); //Get possible moves of the first pawn
            if (possibleWays1.size() > 0) {
                for (Arrow possibleWay1 :
                        possibleWays1) {
                    nextState = new State(possibleWay1.getLeadTo(), pos2); //define next state
                    PathfinderDFS fp = new PathfinderDFS(currentRoad,nextState);
                    ForkJoinTask.invokeAll(fp); //run next state recursive
                }
            }
            ArrayList<Arrow> possibleWays2 = getPossibleWays2(currentState); //Get possible moves of the second pawn
            if (possibleWays2.size() > 0) {
                for (Arrow possibleWay2 :
                        possibleWays2) {
                    nextState = new State(pos1, possibleWay2.getLeadTo()); //define next state
                    PathfinderDFS fp = new PathfinderDFS(currentRoad,nextState);
                    ForkJoinTask.invokeAll(fp);//run next state recursive
                }

            }
            if(possibleWays1.size()+possibleWays2.size()==0) { //save the road that is in the dead end
                allRoads.add(currentRoad);
            }
        }

    }

    @Override
    public String  allRoadsToString(){
        return "\nDFS" + super.allRoadsToString();
    }


    @Override
    public String  correctRoadsToString(){
        return "\nDFS" + super.correctRoadsToString();
    }
}
