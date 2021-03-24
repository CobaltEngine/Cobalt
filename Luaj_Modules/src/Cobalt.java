import io.github.cobalt.core.Renderer2D;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

import java.awt.*;

public class Cobalt extends TwoArgFunction {

    private static Renderer2D r2d;

    public static void SetRenderer2D(Renderer2D renderer) {
        r2d = renderer;
    }

    public Cobalt() {}

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        Cobalt.SetRenderer2D(Renderer2D.GetGlobalR2D());

        LuaValue library = tableOf();
        library.set("Clear", new Clear());
        env.set("Cobalt", library);
        return library;
    }


    static class Clear extends ThreeArgFunction {
        @Override
        public LuaValue call(LuaValue R, LuaValue G, LuaValue B) {
            Color c = new Color(R.toint(), G.toint(), B.toint());
            r2d.Clear(c);
            return LuaValue.NIL;
        }
    }
}
