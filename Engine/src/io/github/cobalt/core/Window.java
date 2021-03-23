package io.github.cobalt.core;

import io.github.cobalt.jsfml.JSFML_Window;

public abstract class Window {
    public static Window ConstructWindow(int width, int height, String title) {
        return new JSFML_Window(width, height, title);
    }

    public abstract boolean IsRunning();
    public abstract void    Update   ();
    public abstract void    Destroy  ();

}
