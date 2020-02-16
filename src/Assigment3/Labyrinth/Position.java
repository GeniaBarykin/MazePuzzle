package Assigment3.Labyrinth;

import java.util.ArrayList;

public class Position {
    private ArrayList<Arrow> wayOut = new ArrayList<>();
    private int id;
    private Color.color color;

    public Position(int id, Color.color color) {
        this.id = id;
        this.color = color;
    }

    public void addWayOut(Position pos, Color.color color) {
        wayOut.add(new Arrow(pos, color));
    }

    public ArrayList<Arrow> getWayOut() {
        return wayOut;
    }

    public int getId() {
        return id;
    }

    public Color.color getColor() {
        return color;
    }
}

