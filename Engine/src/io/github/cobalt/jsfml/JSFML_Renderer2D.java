package io.github.cobalt.jsfml;

import io.github.cobalt.core.MismatchedContextException;
import io.github.cobalt.core.Renderer2D;
import io.github.cobalt.core.Window;
import org.jsfml.graphics.RenderWindow;

import java.awt.*;

public class JSFML_Renderer2D extends Renderer2D {
    private RenderWindow window;

    public void SetWindowContext(Window context) throws MismatchedContextException {
        if(context instanceof JSFML_Window) {
            window = ((JSFML_Window) context).renderWindow;
        } else {
            throw new MismatchedContextException();
        }

    }

    @Override
    public void DrawRect(double x, double y, double width, double height) {

    }

    @Override
    public void Clear(Color c) {
        window.clear(AdapterFunctions.ToJSFMLColor(c));
    }
}
