package Assigment3.Labyrinth;

public class Arrow {
    private Position leadTo;
    private Color.color color;

    public Arrow(Position leadTo, Color.color color) {
        this.color = color;
        this.leadTo = leadTo;
    }

    public Position getLeadTo() {
        return leadTo;
    }

    public Color.color getColor() {
        return color;
    }
}


