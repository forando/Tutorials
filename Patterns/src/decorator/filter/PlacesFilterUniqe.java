package decorator.filter;

import java.util.ArrayList;

/**
 * Created by forando on 18.12.14.
 */
public class PlacesFilterUniqe extends PlacesFilterDecorator {

    public PlacesFilterUniqe(PlacesFilter places) {
        super(places);
    }

    @Override
    public ArrayList<Place> filter() {
        ArrayList<Place> placesInput = super.filter();

        ArrayList<Place> placesOutput = new ArrayList<Place>();

        for (Place placeInput : placesInput) {
            boolean keyExist = false;
            String placeInputName = placeInput.getName();
            for (Place placeOutput : placesOutput) {
                if (placeInputName.equals(placeOutput.getName())) {
                    keyExist = true;
                    break;
                }
            }
            if (!keyExist) placesOutput.add(placeInput);
        }
        return placesOutput;
    }
}
