package decorator.filter;

import java.util.ArrayList;

/**
 * Created by forando on 18.12.14.
 */
public abstract class PlacesFilterDecorator implements PlacesFilter {
    PlacesFilter placesFilter;


    public PlacesFilterDecorator(PlacesFilter placesFilter) {
        this.placesFilter = placesFilter;
    }

    @Override
    public ArrayList<Place> filter() {
        return placesFilter.filter();
    }
}
