package visitor;

/**
 * Created by forando on 31.07.15.
 */
public interface Visitor {
    void visit ( Point2d p );
    void visit ( Point3d p );
}
