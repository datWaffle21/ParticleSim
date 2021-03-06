package core.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private LinkedList<GameObject> objects = new LinkedList<>();

    public LinkedList<GameObject> getObjects() {
        return objects;
    }

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public void removeAll() {
        for (int i = 0; i < this.objects.size(); i++) {
            GameObject tempObject = this.objects.get(i);
            this.removeObject(tempObject);
        }
    }
}
