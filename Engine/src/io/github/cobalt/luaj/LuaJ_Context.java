package io.github.cobalt.luaj;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.HashMap;

public class LuaJ_Context {
    HashMap<String, LuaValue> chunkMap = new HashMap<>();
    private final Globals globals = JsePlatform.standardGlobals();
    private static final LuaJ_Context CXT = new LuaJ_Context();
    public static LuaJ_Context Get() {
        return CXT;
    }

    public void LoadFile(String name,String path) {
        chunkMap.put(name, globals.loadfile(path));
    }

    public void Run(String name) {
        chunkMap.get(name).invoke();
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
