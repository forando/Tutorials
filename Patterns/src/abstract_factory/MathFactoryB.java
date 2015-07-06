package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * Concrete factory.
 */
public class MathFactoryB implements AbstractMathOperationsFactory {
    @Override
    public String getFactoryType() {
        return "B";
    }

    @Override
    public AbstractIncreaser createIncreaser(int param) {
        return new IncreaserB(param);
    }

    @Override
    public AbstractDerceaser createDecreaser(int param) {
        return new DecreaserB(param);
    }
}
