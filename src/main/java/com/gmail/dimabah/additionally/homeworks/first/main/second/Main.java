package com.gmail.dimabah.additionally.homeworks.first.main.second;

/**
 * Описать класс Треугольник. В качестве свойств возьмите длины сторон треугольника.
 * Реализуйте метод, который будет возвращать площадь этого треугольника. Создайте
 * несколько объектов этого класса и протестируйте их.
 */

public class Main {
    public static void main(String[] args) {
        Triangle triangleFirst = new Triangle(10, 12, 14);
        Triangle triangleSecond = new Triangle(15, 8, 10);

        System.out.printf("Area of the first triangle: %.2f"+ System.lineSeparator(),
                triangleFirst.calcAreaOfTriangle());
        System.out.printf("Area of the second triangle: %.2f"+ System.lineSeparator(),
                + triangleSecond.calcAreaOfTriangle());
    }
}
