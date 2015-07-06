package state;

/**
 * Created by forando on 01.12.14.
 */
class StateLowerCase implements Statelike {

    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toLowerCase());
        context.setState(new StateMultipleUpperCase());
    }

}
