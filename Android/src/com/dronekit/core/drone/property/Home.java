package com.dronekit.core.drone.property;

import com.dronekit.core.helpers.coordinates.LatLongAlt;

/**
 * Location from which the drone took off.
 */
public class Home {

    /**
     * Lauch pad 3D coordinate.
     */
    private LatLongAlt mCoordinate;

    public Home() {
    }

    public Home(double latitude, double longitude, double altitude) {
        mCoordinate = new LatLongAlt(latitude, longitude, altitude);
    }

    public Home(LatLongAlt coordinate) {
        mCoordinate = coordinate;
    }

    /**
     * @return the launch pad 3D coordinate.
     */
    public LatLongAlt getCoordinate() {
        return mCoordinate;
    }

    public void setCoordinate(LatLongAlt mCoordinate) {
        this.mCoordinate = mCoordinate;
    }

    public boolean isValid() {
        return mCoordinate != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Home)) return false;

        Home home = (Home) o;

        return !(mCoordinate != null ? !mCoordinate.equals(home.mCoordinate) : home.mCoordinate != null);

    }

    @Override
    public int hashCode() {
        return mCoordinate != null ? mCoordinate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LaunchPad{" +
                "mCoordinate=" + mCoordinate +
                '}';
    }
}
