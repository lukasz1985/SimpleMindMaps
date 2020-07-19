package map;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

abstract public class Widget {


    View view;
    Point     position = new Point(0, 0); // Position of the center of a widget.
    Dimension size     = new Dimension(0, 0); // The size of a widget


    public void setView(View view) {
        this.view = view;
    }

    abstract public void paint(Graphics2D graphics);


    public void setPosition(Point position) {
        this.position = position;
    }


    public Point getPosition() {
        return this.position;
    }

    int getWidth() {
        return this.size.width;
    }


    int getHeight() {
        return this.size.height;
    }


    // Calculate the bounds the widgets occupies on the map view.
    // Keep in mind that the bounds are relative to the widget center.
    // The top-left corner is on the opposite side of the bottom-right corner
    // and the center is exactly between them.
    public Rectangle calcBounds() {
        int x = this.view.map(this.position).x - this.size.width  / 2;
        int y = this.view.map(this.position).y - this.size.height / 2;
        int width = this.size.width;
        int height = this.size.height;
        return new Rectangle(x, y, width, height);
    }


    public boolean containsPoint(Point point) {
        Rectangle bounds = this.calcBounds();
        return
            point.x > bounds.x && point.x < bounds.x + bounds.width &&
            point.y > bounds.y && point.y < bounds.y + bounds.height;
    }


    /// Event handling methods ///
    abstract public void onClick(MouseEvent event);

    abstract public void gainFocus();

    abstract public void loseFocus();

    abstract public void keyPressed(KeyEvent event);

    abstract public void keyReleased(KeyEvent event);

    abstract public void keyTyped(KeyEvent event);

}
