package decorator;


/**
 * Created by forando on 18.12.14.
 */
class MainComponent implements InterfaceComponent {

    @Override
    public void doOperation() {
        System.out.print("World!");
    }
}
