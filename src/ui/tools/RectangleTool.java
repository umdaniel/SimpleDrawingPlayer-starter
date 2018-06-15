package ui.tools;

import model.Rectangle;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class RectangleTool extends ShapeTool {

    public RectangleTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
        shape = null;
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton( "Rectangle");
        button = customizeButton(button);
    }

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new RectangleTool.RectangleToolClickHandler());
    }

    @Override
    //EFFECTS: Constructs and returns the new shape
    protected void makeShape(MouseEvent e) {
        shape = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }

    private class RectangleToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            editor.setActiveTool(RectangleTool.this);
        }
    }
}
