package prototype;

/**
 * Created by forando on 06.07.15.<br/>
 * This is the prototype
 */
public abstract class Shape implements Cloneable {

    /*
     * All properties are immutable primitives (String). Thus, we don't need to
     * create a new copy of them while cloning the object.
     * Otherwise we would have to.
     */
    private String id;
    protected String type;

    abstract void draw();

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
    By convention, the new object returned by this method should be independent
    of this object (which is being cloned). To achieve this independence,
    it may be necessary to modify one or more mutable fields of the object returned
    by super.clone before returning it. Typically, this means copying any
    mutable objects that comprise the internal "deep structure" of the object
    being cloned and replacing the references to these objects with references
    to the copies. If a class contains only primitive fields or references to
    immutable objects, then it is usually the case that no fields
    in the object returned by super.clone need to be modified.
    See: http://www.javaranch.com/journal/2003/04/immutable.htm
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
