package ui.tools;

import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public abstract class ShapeTool extends Tool {
	protected Shape shape;
    public ShapeTool(DrawingEditor editor, JComponent parent) {
		super(editor, parent);
		shape = null;
	}

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
	@Override
	protected abstract void createButton(JComponent parent);

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
	@Override
	protected abstract void addListener();

    // MODIFIES: this
    // EFFECTS:  a shape is instantiate MouseEvent occurs, and played and
    //           added to the editor's drawing
	@Override
	public void mousePressedInDrawingArea(MouseEvent e) {
        makeShape(e);
        shape.selectAndPlay();
        shape.setBounds(e.getPoint());
        editor.addToDrawing(shape);
    }


    // MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
	@Override
	public void mouseReleasedInDrawingArea(MouseEvent e) {
        shape.unselectAndStopPlaying();
        shape = null;
    }

    // MODIFIES: this
    // EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
	@Override
	public void mouseDraggedInDrawingArea(MouseEvent e) {
        shape.setBounds(e.getPoint());
    }

    protected abstract void makeShape(MouseEvent e);

}

