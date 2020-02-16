package Assigment3;

import Assigment3.Labyrinth.Maze;
import Assigment3.Labyrinth.Position;
import Assigment3.Pathfinder.PathfinderBFSConcurrent;
import Assigment3.Pathfinder.PathfinderDFS;
import Assigment3.Pathfinder.State;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.build();
        //Pawn 1 position
        Position startPos1 = maze.getPosition(1);
        //Pawn 2 position
        Position startPos2 = maze.getPosition(2);
        //To state
        State initialState = new State(startPos1, startPos2);
        //Set up and run DepthFirst algorithm
        PathfinderDFS findPathDFS = new PathfinderDFS(initialState);
        findPathDFS.compute();
        String allRoadsDFS = findPathDFS.allRoadsToString();
        String correctRoadsDFS = findPathDFS.correctRoadsToString();
        PathfinderBFSConcurrent findPathBFS = new PathfinderBFSConcurrent(initialState);
        findPathBFS.compute();

        //Print all roads from the DepthFirst
        System.out.println(allRoadsDFS);

        //Print all  roads from the BreadthFirst
        System.out.println(findPathBFS.allRoadsToString());

        //Print all correct roads from the DepthFirst (always one)
        System.out.println(correctRoadsDFS);


        //Print all correct roads from the BreadthFirst (always one)
        System.out.println(findPathBFS.correctRoadsToString());
    }
}
