package io.github.cobalt.core;

public class EventHandlers {

    public static interface OnCloseEvent        { void Call(                  ); }
    public static interface OnMouseMovedEvent   { void Call(double x, double y); }
    public static interface OnMouseClickedEvent { void Call(int button        ); }
    public static interface OnKeyPressedEvent   { void Call(char key          ); }
    public static interface OnKeyReleasedEvent  { void Call(char key          ); }
}
