package model;

import sound.MidiSynth;

import java.awt.*;

public class Oval extends Shape {
    public Oval(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
    }

    @Override
    public boolean contains(Point p) {

        final double TOL = 1.0e-6;
        double halfWidth = getWidth() / 2.0;
        double halfHeight = getHeight() / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(getXCoord() + halfWidth, p.getX()) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(getXCoord() + halfWidth, p.getX());
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(getYCoord() + halfHeight, p.getY()) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(getYCoord() + halfHeight, p.getY());
        }
        return  diff <= 1.0 + TOL;
    }

    @Override
    public void draw(Graphics g) {

        Color save = g.getColor();
        if (isSelected()) {
            g.setColor(PLAYING_COLOR);
        } else {
            g.setColor(Color.white);
        }
        g.fillOval(getXCoord(), getYCoord(), getWidth(), getHeight());
        g.setColor(save);
        g.drawOval(getXCoord(), getYCoord(), getWidth(), getHeight());

        if (playLineCoord > 0 && playLineCoord < getWidth()) {
            g.setColor(Color.red);
            g.drawLine(getXCoord() + playLineCoord, getYCoord(), getXCoord() + playLineCoord, getYCoord() + getHeight());
            g.setColor(save);
        }
    }

    // Compute square of difference
// EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }
}
