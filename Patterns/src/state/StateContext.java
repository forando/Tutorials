/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package state;

/**
 * Created by forando on 01.12.14.
 */
public class StateContext {
    private State myState;
    StateContext() {
        setState(new StateLowerCase());
    }

    /**
     * Setter method for the state.
     * Normally only called by classes implementing the State interface.
     * @param newState the new state of this context
     */
    void setState(final State newState) {
        myState = newState;
    }

    public void writeName(final String name) {
        myState.writeName(this, name);
    }
}
