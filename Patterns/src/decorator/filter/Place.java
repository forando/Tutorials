/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator.filter;

/**
 * Created by forando on 18.12.14.
 */
public class Place {
    private String name;
    private String description;

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
