package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * Concrete object.
 */
public class DecreaserB implements AbstractDerceaser {
    private int val;

    public DecreaserB(int value) {
        this.val = value;
    }

    @Override
    public int dercease(int value) {
        return val / value;
    }
}
