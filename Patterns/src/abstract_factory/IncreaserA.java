package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * Concrete object.
 */
public class IncreaserA implements AbstractIncreaser {

    private int val;

    public IncreaserA(int value) {
        val = value;
    }

    @Override
    public int increase(int value) {
        return val + value;
    }
}
