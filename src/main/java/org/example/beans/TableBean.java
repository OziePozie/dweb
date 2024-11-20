package org.example.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import org.example.db.model.Point;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("tableBean")
@ApplicationScoped
public class TableBean {
    private ArrayList<Point> points = new ArrayList<>();

    public TableBean() {
        points = getPoints();
    }

    public ArrayList<Point> getPoints() {
        try (var connection = PostgreSQLJDBC.connect()) {
            PostgreSQLJDBC.createPointsTable(connection);
            points = PostgreSQLJDBC.getLastPoints(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return points;
    }
}