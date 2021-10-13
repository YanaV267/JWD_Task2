package com.development.task2.warehouse;

public class SphereParameter {
    private double surfaceArea;
    private double volume;

    public SphereParameter() {

    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphereParameter that = (SphereParameter) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (result * 31 + surfaceArea);
        result = (int) (result * 31 + volume);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{");
        sb.append("surfaceArea=").append(surfaceArea);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
