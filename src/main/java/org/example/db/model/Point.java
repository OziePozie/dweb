package org.example.db.model;

public class Point {

    private Double x;
    private Double y;
    private Double r;
    private boolean isHit;

    public Point(Double x, Double y, Double r, boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
    }

    public Point() {
    }

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }
}
