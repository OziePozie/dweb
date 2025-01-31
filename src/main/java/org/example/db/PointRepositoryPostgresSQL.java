package org.example.db;

import org.example.db.model.Point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointRepositoryPostgresSQL implements PointRepository {
    private final Connection con;

    public PointRepositoryPostgresSQL(Connection con) {
        this.con = con;
    }

    @Override
    public void save(Point point) {
        String query = "INSERT INTO points (x, y, r, result) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setDouble(1, point.getX());
            preparedStatement.setDouble(2, point.getY());
            preparedStatement.setDouble(3, point.getR());
            preparedStatement.setBoolean(4, point.isHit());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Point findById(int id) {
        String query = "SELECT * FROM points WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getPointFromRS(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Point> findPoint(int offset, int limit) {
        String query = "SELECT * FROM points LIMIT ? OFFSET ?";
        List<Point> points = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                points.add(getPointFromRS(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return points;
    }

    private Point getPointFromRS(ResultSet rs) throws SQLException {
        Point point = new Point();
        point.setX(rs.getDouble("x"));
        point.setY(rs.getDouble("y"));
        point.setR(rs.getDouble("r"));
        point.setIsHit(rs.getBoolean("result"));
        return point;
    }

}
