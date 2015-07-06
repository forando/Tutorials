package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * A factory abstraction.
 */
public interface AbstractMathOperationsFactory {
    String getFactoryType();
    AbstractIncreaser createIncreaser(int param);
    AbstractDerceaser createDecreaser(int param);
}
