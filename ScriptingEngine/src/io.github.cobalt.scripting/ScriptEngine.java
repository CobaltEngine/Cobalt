package io.github.cobalt.scripting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ScriptEngine {
    private static Map<String, LuaJ_Context> programs = new HashMap<>();
    public static void RunFile(String name,String path) {
        LuaJ_Context program = new LuaJ_Context();
        program.LoadFile(path);
        program.Run();
        programs.put(name, program);
    }

    public static int GetInt(String name, String key) {
        return programs.get(name).GetInt(key);
    }


    public static void CallFunc(String name, String func) {
        programs.get(name).CallFunc(func);
    }

    public static String GetNameFromPath(String path) {
        String[] pathArr = path.split(File.pathSeparator);
        return pathArr[pathArr.length - 1];
    }
}
