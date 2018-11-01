package com.playtech;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Points {

    public static void main(String[] args) throws IOException {
        Rectangle rectangle = new Rectangle(5, 5, 10, 5);
        Shape circle = new Ellipse2D.Double(0, 0, 100, 100);
        List<String> points = Files.readAllLines(Paths.get("points.txt"));

        points
                .stream()
                .map(s -> s.split(";"))
                .map(strarr -> new Point2D.Double(Double.valueOf(strarr[0]), Double.valueOf(strarr[1])))
                .filter()
                .forEach(System.out::println);
    }
}
