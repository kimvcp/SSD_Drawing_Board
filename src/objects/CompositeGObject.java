package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompositeGObject extends GObject {

	private List<GObject> gObjects;

	public CompositeGObject() {
		super(0, 0, 0, 0);
		gObjects = new ArrayList<GObject>();
	}

	public void add(GObject gObject) {
		gObjects.add(gObject);
	}

	public void remove(GObject gObject) {
		gObjects.remove(gObject);
		}

	@Override
	public void move(int dX, int dY) {
		this.x += dX;
		this.y += dY;
	}
	
	public void recalculateRegion() {
		// TODO: Implement this method.
	}

	@Override
	public void paintObject(Graphics g) {
		for (GObject element: gObjects) {
			element.paintObject(g);
		}
	}

	@Override
	public void paintLabel(Graphics g) {
		for (GObject element: gObjects) {
			element.paintLabel(g);
		}
	}
	
}
