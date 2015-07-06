package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * <b>Abstract Factory Pattern</b><br/>
 * Example of using object abstractions instead of concrete objects.<br/>
 * These object abstractions are provided via abstracted factory methods.
 */
public class Main {
    public static void main(String[] args) {

        /*
        Getting abstracted factory instead of concrete one
         */
        AbstractMathOperationsFactory factory = new MathFactoryA();
        testFactory(factory);

        /*
        Getting abstracted factory instead of concrete one
         */
        factory = new MathFactoryB();
        testFactory(factory);
    }

    /**
     * This code is not supposed to be changed. <br/> In order to change functionality
     * completely, it's enough just to change abstracted <b>factory</b> implementation
     * and then pass this abstraction in here as the method param.
     * @param factory This object is the only thing in the code that is changed.
     */
    private static void testFactory(AbstractMathOperationsFactory factory){
        int initParam = 6;
        int val = 2;
        System.out.println("initParam = " + initParam);
        System.out.println("--------------------");

        /*
        Getting abstracted objects instead of concrete ones
         */
        AbstractIncreaser increaser = factory.createIncreaser(initParam);
        AbstractDerceaser derceaser = factory.createDecreaser(initParam);

        System.out.println("increaser type " + factory.getFactoryType() + " with param = " + val + " -> " + increaser.increase(val));
        System.out.println("derceaser type " + factory.getFactoryType() + " with param = " + val + " -> " + derceaser.dercease(val));
        System.out.println("=====================================");
    }
}
