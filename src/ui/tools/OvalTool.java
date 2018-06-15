package ui.tools;

import model.Oval;

import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class OvalTool extends ShapeTool {

    public OvalTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
        shape = null;
    }

    @Override
    protected void createButton(JComponent parent) {

        button = new JButton( "Oval");
        button = customizeButton(button);
    }

    @Override
    protected void addListener() {

        button.addActionListener(new OvalTool.OvalToolClickHandler());
    }

    @Override
    //EFFECTS: Constructs and returns the new shape
    protected void makeShape(MouseEvent e) {
        shape = new Oval(e.getPoint(), editor.getMidiSynth());
    }

    private class OvalToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            editor.setActiveTool(OvalTool.this);
        }
    }
}
