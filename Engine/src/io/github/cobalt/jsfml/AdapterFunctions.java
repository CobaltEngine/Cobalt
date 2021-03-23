package io.github.cobalt.jsfml;

import org.jsfml.graphics.Color;

public class AdapterFunctions {
        public static Color ToJSFMLColor(java.awt.Color c) {
            return new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
        }
}
