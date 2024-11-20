package org.example.util;

import org.example.db.model.Point;

public class PointValidator {

    public void isValidPoint(Point p) throws Exception {
        RestrictionsHelper helper = new RestrictionsHelper();
        helper.isGreaterOrLesser(3, -3, p.getX());
        helper.isGreaterOrLesser(2, -2, p.getY());
        helper.isGreaterOrLesser(3, 1, p.getR());
    }

}
