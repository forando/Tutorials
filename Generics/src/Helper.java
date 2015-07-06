/**
 * Created by forando on 13.11.14.
 */
public class Helper extends Product<Helper> {
    public String name;
    public int price;

    public Helper(String name, int price) {
        super(name, price);
        this.name = name;
        this.price = price;
    }

    @Override
    int subCompare(Helper p) {
        return 0;
    }
}
