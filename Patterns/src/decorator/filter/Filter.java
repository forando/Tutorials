/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator.filter;

import java.util.ArrayList;

/**
 * Created by forando on 18.12.14.
 */
public interface Filter<T> {

    ArrayList<T> filter();
}
