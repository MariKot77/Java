package com.company;

public class Point3D {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3D() {
        this.xCoord = 0.0D;
        this.yCoord = 0.0D;
        this.zCoord = 0.0D;
    }

    public Point3D(double x, double y, double z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }

    public double getX() {
        return this.xCoord;
    }

    public double getY() {
        return this.yCoord;
    }

    public double getZ() {
        return this.zCoord;
    }

    public void setX(double x) {
        this.xCoord = x;
    }

    public void setY(double y) {
        this.yCoord = y;
    }

    public void setZ(double z) {
        this.zCoord = z;
    }

    public boolean equalPoints(Point3D a) {
        return this.xCoord == a.xCoord & this.yCoord == a.yCoord & this.zCoord == a.zCoord;
    }

    public Double distanceTo(Point3D a) {
        double dist = Math.sqrt(Math.pow(this.xCoord - a.xCoord, 2.0D) + Math.pow(this.yCoord - a.yCoord, 2.0D) + Math.pow(this.zCoord - a.zCoord, 2.0D));
        return Math.ceil(dist * 100.0D) / 100.0D;
    }
}