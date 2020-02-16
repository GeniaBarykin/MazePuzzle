package Tests;

import Assigment3.Labyrinth.Arrow;
import Assigment3.Labyrinth.Position;
import Assigment3.Pathfinder.Pathfinder;
import Assigment3.Pathfinder.PathfinderBFSConcurrent;
import Assigment3.Pathfinder.PathfinderDFS;
import Assigment3.Pathfinder.State;
import Tests.TestClasses.TestPathFinder;
import Tests.TestClasses.TestMaze;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    @org.junit.Test
    public void Test1getPossibleWays1() {
        TestMaze maze = new TestMaze();
        maze.build(true);
        Position startPos1 = maze.getPosition(1);
        Position startPos2 = maze.getPosition(2);
        State initialState = new State(startPos1, startPos2);
        TestPathFinder testPathfinder = new TestPathFinder(initialState);
        ArrayList<State> deadEnds = new ArrayList<>();
        ArrayList<Arrow> possibleWays = testPathfinder.getPossibleWays1(initialState);
        assertPossibleWays(possibleWays);
        State nextPossibleState = new State(possibleWays.get(0).getLeadTo(), maze.getPosition(2));
        possibleWays = testPathfinder.getPossibleWays1(nextPossibleState);
        assertEquals("There should be no possible way as it is dead end", 0, possibleWays.size());
        ArrayList<State> road = new ArrayList<>();
        road.add(initialState);
        road.add(new State(maze.getPosition(5), maze.getPosition(2)));
        road.add(new State(maze.getPosition(5), maze.getPosition(6)));
        road.add(new State(maze.getPosition(8), maze.getPosition(6)));
        road.add(new State(maze.getPosition(7), maze.getPosition(6)));
        State lastState = new State(maze.getPosition(5), maze.getPosition(6));
        road.add(lastState);
        testPathfinder.setCurrentRoad(road);
        possibleWays = testPathfinder.getPossibleWays1(lastState);
        assertEquals("There should be no possible way as it will cause loop", 0, possibleWays.size());
    }

    @org.junit.Test
    public void Test2getPossibleWays2() {
        TestMaze maze = new TestMaze();
        maze.build(true);
        Position startPos1 = maze.getPosition(2);
        Position startPos2 = maze.getPosition(1);
        State initialState = new State(startPos1, startPos2);
        TestPathFinder testPathfinder = new TestPathFinder(initialState);
        ArrayList<State> deadEnds = new ArrayList<>();
        ArrayList<Arrow> possibleWays = testPathfinder.getPossibleWays2(initialState);
        assertPossibleWays(possibleWays);
        State nextPossibleState = new State(maze.getPosition(2), possibleWays.get(0).getLeadTo());
        possibleWays = testPathfinder.getPossibleWays2(nextPossibleState);
        assertEquals("There should be no possible way as it is dead end", 0, possibleWays.size());
        ArrayList<State> road = new ArrayList<>();
        road.add(initialState);
        road.add(new State(maze.getPosition(2), maze.getPosition(5)));
        road.add(new State(maze.getPosition(6), maze.getPosition(5)));
        road.add(new State(maze.getPosition(6), maze.getPosition(8)));
        road.add(new State(maze.getPosition(6), maze.getPosition(7)));
        State lastState = new State(maze.getPosition(5), maze.getPosition(6));
        road.add(lastState);
        testPathfinder.setCurrentRoad(road);
        testPathfinder.setCurrentRoad(road);
        possibleWays = testPathfinder.getPossibleWays2(lastState);
        assertEquals("There should be no possible way as it will cause loop", 0, possibleWays.size());
    }

    @org.junit.Test
    public void Test3DFS() {
        TestMaze maze = new TestMaze();
        maze.build(true);
        State initialState = getInitialState(maze);
        testGoodScenario(new PathfinderDFS(initialState));
        maze.build(false);
        initialState = getInitialState(maze);
        testChildBadScenario(new PathfinderDFS(initialState));
    }

    @org.junit.Test
    public void Test4BFS() {
        TestMaze maze = new TestMaze();
        maze.build(true);
        State initialState = getInitialState(maze);
        testGoodScenario(new PathfinderBFSConcurrent(initialState));
        maze.build(false);
        initialState = getInitialState(maze);
        testChildBadScenario(new PathfinderBFSConcurrent(initialState));
    }

    private void assertPossibleWays(ArrayList<Arrow> possibleWays){
        assertEquals("There should be 2 possible ways", 2, possibleWays.size());
        assertEquals("Possible position should have id 4", 4, possibleWays.get(0).getLeadTo().getId());
        assertEquals("Possible position should have id 5", 5, possibleWays.get(1).getLeadTo().getId());
    }

    private void testGoodScenario(Pathfinder pathFinder){
        System.out.print("\nGood scenario");
        pathFinder.compute();
        assertTrue("Solution was found", pathFinder.getCorrectRoads().size() > 0);
        assertLeadsToTheFinish(pathFinder.getCorrectRoads());
        System.out.println(pathFinder.allRoadsToString());
        System.out.println(pathFinder.correctRoadsToString());
    }

    private void testChildBadScenario(Pathfinder pathFinder){
        System.out.print("\nBad scenario");
        pathFinder.compute();
        assertEquals("Solution was not found", 0, pathFinder.getCorrectRoads().size());
        System.out.println(pathFinder.allRoadsToString());
        System.out.println(pathFinder.correctRoadsToString());
    }

    private State getInitialState(TestMaze maze) {
        Position startPos1 = maze.getPosition(1);
        Position startPos2 = maze.getPosition(2);
        return new State(startPos1, startPos2);
    }

    private void assertLeadsToTheFinish(ArrayList<ArrayList<State>> roads) {
        for (ArrayList<State> road :
                roads) {
            State lastCorrectState = road.get(road.size() - 1);
            assertTrue("Solution is correct", lastCorrectState.isOnFinish());
        }
    }

}