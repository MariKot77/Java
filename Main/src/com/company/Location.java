package com.company;

import java.util.Objects;

//В этом классе координаты для двумерной плоскости
public class Location
{
    // Координата Х
    public int xCoord;
    //Координата Y
    public int yCoord;

    //Создает новую точку с указанными x и y
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    //Создает точку с координатими (0, 0)
    public Location()
    {
        this(0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return xCoord == location.xCoord && yCoord == location.yCoord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}