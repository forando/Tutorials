package prototype;

/**
 * Created by forando on 06.07.15.<br/>
 * Concrete prototype.
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
