package decorator.filter;

import java.util.ArrayList;

/**
 * Created by forando on 18.12.14.
 */
public class PlacesHolder implements PlacesFilter {

    ArrayList<Place>places;

    public PlacesHolder() {
        places = new ArrayList<Place>();
        places.add(new Place("service", "car service"));
        places.add(new Place("food", "fast food"));
        places.add(new Place("food", "restaurant food"));
        places.add(new Place("gas", "gas station"));
        places.add(new Place("beauty", "beauty salon"));
    }

    @Override
    public ArrayList<Place> filter() {
        return places;
    }
}
