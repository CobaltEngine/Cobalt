package io.github.cobalt.scripting;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.HashMap;

public class LuaJ_Context {
    private static final Globals globals = JsePlatform.standardGlobals();
    private LuaValue chunk;
    public void LoadFile(String path) {
        chunk = globals.loadfile(path);
    }

    public void Run() {
        chunk.call();
    }

    public double GetDouble(String key) {
        return globals.get(key).todouble();
    }

    public int GetInt(String key) {
        return globals.get(key).toint();
    }

    public void CallFunc(String name) {
        if(globals.get(name).isfunction()) {
            globals.get(name).invoke();
        }
    }
}
