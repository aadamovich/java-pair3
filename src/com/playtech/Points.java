package com.playtech;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Points {

    public static void main(String[] args) throws IOException {
        Circle circle = new Circle(0, 0, 20);

        List<String> points = Files.readAllLines(Paths.get("points.txt"));

        points
                .stream()
                .map(s -> s.split(";"))
                .map(strarr -> new Point(Integer.valueOf(strarr[0]), Integer.valueOf(strarr[1])))
                .filter(circle::contains)
                .forEach(System.out::println);
    }

    private static class Circle {
        private int x;
        private int y;
        private int radius;

        private Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        private boolean contains(Point point) {
            return radius > distance(point);
        }

        private double distance(Point b) {
            return Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
        }
    }
}
