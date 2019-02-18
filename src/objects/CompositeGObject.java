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

		for (GObject element: gObjects) {
			element.move(dX, dY);
		}
	}
	
	public void recalculateRegion() {

		GObject  gObj = gObjects.get(0);

		int x = gObj.x;
		int y = gObj.y;
		int maxX = x + gObj.width;
		int maxY = y + gObj.height;

		for(GObject element : gObjects){
			if(element.x < x) x = element.x;
			if(element.y < x) y = element.y;
			if(element.x + element.width > maxX){
				maxX = element.x + element.width;
			}
			if(element.y + element.height > maxY) {
				maxY = element.y + element.height;
			}
		}

		this.x = x;
		this.y = y;
		this.width = maxX - x;
		this.height = maxY - y;

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
