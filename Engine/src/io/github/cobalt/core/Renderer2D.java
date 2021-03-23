package io.github.cobalt.core;

import io.github.cobalt.jsfml.JSFML_Renderer2D;
import io.github.cobalt.jsfml.JSFML_Window;
import io.github.cobalt.jsfml.MismatchedContextException;

import java.awt.*;

public abstract class Renderer2D {

    public static Renderer2D ConstructBasedOnContext(Window window) {
        if(window instanceof JSFML_Window) {
            JSFML_Renderer2D r2d = new JSFML_Renderer2D();
            r2d.SetWindowContext(window);
            return r2d;
        }
        return null;
    }


    public abstract void SetWindowContext(Window context) throws MismatchedContextException;
    public abstract void DrawRect(double x, double y, double width, double height);
    public abstract void Clear(Color c);
}
