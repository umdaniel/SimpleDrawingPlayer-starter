package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    public boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }


    // EFFECTS: draws this Shape on the SimpleDrawingPlayer, if the shape is selected, Shape is filled in
    //          else, Shape is unfilled (white)
    public void draw(Graphics g) {
        Color save = g.getColor();
        if (isSelected()) {
            g.setColor(PLAYING_COLOR);
        } else {
            g.setColor(Color.white);
        }
        g.fillRect(getXCoord(), getYCoord(), getWidth(), getHeight());
        g.setColor(save);
        g.drawRect(getXCoord(), getYCoord(), getWidth(), getHeight());

        if (playLineCoord > 0 && playLineCoord < getWidth()) {
            g.setColor(Color.red);
            g.drawLine(getXCoord() + playLineCoord, getYCoord(), getXCoord() + playLineCoord, getYCoord() + getHeight());
            g.setColor(save);
        }
    }
}
