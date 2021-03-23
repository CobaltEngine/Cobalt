package io.github.cobalt.core;

public class Mouse {
    private static double x, y;
    public static double X() {return x;}
    public static double Y() {return y;}

    private static void OnMouseMoved(double x, double y) {
        Mouse.x = x;
        Mouse.y = y;
    }

    public static void Listen() {
        EventSystem.AddMouseMovedHandler(Mouse::OnMouseMoved);
    }
}
