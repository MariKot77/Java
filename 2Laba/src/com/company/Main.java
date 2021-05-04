package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point3D A = new Point3D();
        Point3D B = new Point3D();
        Point3D C = new Point3D();
        System.out.println("Для рассчета площади треугольника введите координаты 3 точек.");
        System.out.println("Координаты точки A:");
        A.setX(in.nextDouble());
        A.setY(in.nextDouble());
        A.setZ(in.nextDouble());
        System.out.println("Координаты точки B:");
        B.setX(in.nextDouble());
        B.setY(in.nextDouble());
        B.setZ(in.nextDouble());
        System.out.println("Координаты точки C:");
        C.setX(in.nextDouble());
        C.setY(in.nextDouble());
        C.setZ(in.nextDouble());
        if ((C.getX() - A.getX()) / (B.getX() - A.getX()) == (C.getY() - A.getY()) / (B.getY() - A.getY()) & (C.getY() - A.getY()) / (B.getY() - A.getY()) == (C.getZ() - A.getZ()) / (B.getZ() - A.getZ())) {
            System.out.println("Точки находятся на одной прямой, площадь равна 0");
        } else {
            System.out.println("Площадь треугольника равна " + computeArea(A, B, C));
        }

    }

    public static double computeArea(Point3D A, Point3D B, Point3D C) {
        double p = (A.distanceTo(B) + A.distanceTo(C) + B.distanceTo(C)) * 0.5D;
        double s = Math.sqrt(p * (p - A.distanceTo(B)) * (p - A.distanceTo(C)) * (p - B.distanceTo(C)));
        return Math.ceil(s * 100.0D) / 100.0D;
    }
}
