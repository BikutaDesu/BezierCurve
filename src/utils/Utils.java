package utils;

import java.awt.Graphics;
import java.awt.Point;

import view.Main;

public class Utils {

	public static void quadBesierCurve(float t, Graphics g, Point[] pointList) {

		if (pointList.length < 3) {
			return;
		}

		Point pFinal = new Point();

		pFinal.y = (int) (pointList[1].y + Math.pow((1 - t), 2) * (pointList[0].y - pointList[1].y)
				+ Math.pow(t, 2) * (pointList[2].y - pointList[1].y));

		System.out.printf("t=%f y=%d \n", t, pFinal.y);

		int diference = 0;
		int startX = pointList[0].x;

		if (pointList[0].x >= pointList[2].x) {
			diference = pointList[0].x - pointList[2].x;
			Main.curvePointList.add(new Point((int) (startX - (diference * t)), pFinal.y));
		} else {
			diference = pointList[2].x - pointList[0].x;
			Main.curvePointList.add(new Point((int) (startX + (diference * t)), pFinal.y));
		}
	}

	public static void cubicBesierCurve() {

	}
}
