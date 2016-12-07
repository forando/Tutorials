/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator.filter;

import java.util.ArrayList;

/**
 * Created by forando on 18.12.14.
 */
public class PlacesFilterOut extends PlacesFilterDecorator {

    String[] keys;

    public PlacesFilterOut(PlacesFilter places, String keyInput) {
        super(places);
        keys = keyInput.split("\\|");
    }

    @Override
    public ArrayList<Place> filter() {
        ArrayList<Place> placesInput = super.filter();

        ArrayList<Place> placesOutput = new ArrayList<Place>();

        for (Place placeInput : placesInput) {
            boolean keyExist = false;
            String placeInputName = placeInput.getName();
            for (String key : keys) {
                if (placeInputName.matches("\\b" + key + ".*")) {
                    keyExist = true;
                    break;
                }
            }
            if (!keyExist) placesOutput.add(placeInput);
        }

        return placesOutput;
    }
}
