package utils;

import java.awt.Graphics;
import java.awt.Point;

import view.Main;

public class Utils {

//	public static void quadBesierCurve(float t, Graphics g, Point[] pointList) {
//
//		if (pointList.length < 3) {
//			return;
//		} else if (pointList.length == 4) {
//			cubicBesierCurve(t, g, pointList);
//			return;
//		} else if (pointList.length > 4) {
//			testBesierMethod(t, g, pointList);
//			return;
//		}
//
//		Point pFinal = new Point();
//
//		pFinal.y = (int) (pointList[1].y + Math.pow((1 - t), 2) * (pointList[0].y - pointList[1].y)
//				+ Math.pow(t, 2) * (pointList[2].y - pointList[1].y));
//
//		pFinal.x = (int) (Math.pow((1 - t), 2) * pointList[0].x + 2 * t * (1 - t) * pointList[1].x
//				+ Math.pow(t, 2) * pointList[2].x);
//
//		Main.curvePointList.add(new Point(pFinal.x, pFinal.y));
//
//	}
//
//	public static void cubicBesierCurve(float t, Graphics g, Point[] pointList) {
//
//		Point pFinal = new Point();
//
//		pFinal.y = (int) (int) (Math.pow((1 - t), 3) * pointList[0].y + 3 * t * Math.pow((1 - t), 2) * pointList[1].y
//				+ 3 * Math.pow(t, 2) * (1 - t) * pointList[2].y + Math.pow(t, 3) * pointList[3].y);
//
//		pFinal.x = (int) (Math.pow((1 - t), 3) * pointList[0].x + 3 * t * Math.pow((1 - t), 2) * pointList[1].x
//				+ 3 * Math.pow(t, 2) * (1 - t) * pointList[2].x + Math.pow(t, 3) * pointList[3].x);
//
//		Main.curvePointList.add(new Point(pFinal.x, pFinal.y));
//
//	}

	public static void besier(float t, Graphics g, Point[] pointList) {
		Point pFinal = new Point();

		int n = pointList.length-1;
		System.out.printf("t = %.2f\n", t);
		for (int i = 0; i <= n; i++) {
			pFinal.x += (int) (binomialCoefficient(n, i) * Math.pow((1 - t), n - i) * Math.pow(t, i) * pointList[i].x);
			pFinal.y += (int) (binomialCoefficient(n, i) * Math.pow((1 - t), n - i) * Math.pow(t, i) * pointList[i].y);
			System.out.printf("\ti = %d / x = %d y = %d\n", i, pFinal.x, pFinal.y);
		}

		Main.curvePointList.add(new Point(pFinal.x, pFinal.y));
	}

	private static float binomialCoefficient(int n, int i) {
		int c = 0;
		c = factorialNumber(n) / (factorialNumber(i) * factorialNumber(n - i));
		return c;
	}

	private static int factorialNumber(int n) {
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}
