package io.github.cobalt.scripting.contexts;

import io.github.cobalt.scripting.Context;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaJ_Context implements Context {
    private static final Globals globals = JsePlatform.standardGlobals();
    private LuaValue chunk;
    public void LoadFile(String path) {
        chunk = globals.loadfile(path);
        Run();
        System.out.println(chunk);
    }

    public void Run() {
        chunk.call();
    }

    public double GetDouble(String key) {
        return globals.get(key).todouble();
    }

    @Override
    public String GetString(String key) {
        return globals.get(key).tojstring();
    }

    @Override
    public boolean GetBool(String key) {
        return globals.get(key).toboolean();
    }

    @Override
    public void SetInt(String key, int value) {
        globals.get(key).set(key, value);
    }

    @Override
    public void SetDouble(String key, double value) {
        globals.get(key).set(key, value);
    }

    @Override
    public void SetString(String key, String value) {
        globals.get(key).set(key, value);
    }

    @Override
    public void SetBool(String key, boolean value) {
        globals.get(key).set(key, LuaValue.valueOf(value));
    }

    public int GetInt(String key) {
        return globals.get(key).toint();
    }


    @Override
    public void CallFunc(String name, Object... args) {
        if(globals.get(name).isfunction()) {
            globals.get(name).invoke();
        } else {
            System.out.printf("Unable to locate Function \"%s\"%n", name);
        }
    }

    private Varargs ToVarArgs(Object... args) {
        LuaValue[] values = new LuaValue[args.length];
        for(int i = 0; i < values.length; i++) {
            values[i] = ToLuaValue(args[i]);
        }
        return LuaValue.varargsOf(values);
    }

    private LuaValue ToLuaValue(Object value) {
        if(value instanceof Integer) return LuaValue.valueOf((int) value);
        if(value instanceof String) return LuaValue.valueOf((String) value);
        if(value instanceof Boolean) return LuaValue.valueOf((boolean) value);
        if(value instanceof Short) return LuaValue.valueOf((short) value);
        if(value instanceof Double) return LuaValue.valueOf((double) value);
        if(value instanceof Float) return LuaValue.valueOf((float) value);
        if(value instanceof Byte) return LuaValue.valueOf((byte) value);
        return LuaValue.NIL;
    }
}
