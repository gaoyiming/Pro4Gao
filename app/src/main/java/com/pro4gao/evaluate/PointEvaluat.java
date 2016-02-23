package com.pro4gao.evaluate;

import android.animation.TypeEvaluator;
import com.pro4gao.bean.Point;


/**
 * Created by gaoyiming on 2016/2/23.
 */
public class PointEvaluat implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float x = startValue.getX() + fraction * (endValue.getX() - startValue.getX());
        float y = startValue.getY() + fraction * (endValue.getY() - startValue.getY());
        return new Point(x, y);


    }
}
