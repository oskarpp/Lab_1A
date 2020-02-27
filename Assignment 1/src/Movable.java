/**
 * Is implemented by classes that should be able to move around
 */
public interface Movable extends IPositionable{

    void move();

    void turnLeft();

    void turnRight();

    boolean intersects(int height, int width);

    void actionCollision(double x, double y);

}
