/**
 * Created by forando on 13.11.14.
 */
public class Phone extends Product<Phone> {

    public String model;

    public Phone(String name, int price, String model) {
        super(name, price);
        this.model = model;
    }

    @Override
    int subCompare(Phone phone) {
        if(price>phone.price) return 1;
        return 0;
    }
}
