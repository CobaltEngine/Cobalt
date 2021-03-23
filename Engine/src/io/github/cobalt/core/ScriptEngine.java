package io.github.cobalt.core;

import io.github.cobalt.luaj.LuaJ_Context;

import java.io.File;

public class ScriptEngine {

    public static void RunFile(String path) {
        String name = GetNameFromPath(path);
        LuaJ_Context.Get().LoadFile(name, path);
        LuaJ_Context.Get().Run(name);
    }

    public static int GetInt(String key) {
        return LuaJ_Context.Get().GetInt(key);
    }


    public static void CallFunc(String name) {
        LuaJ_Context.Get().CallFunc(name);
    }

    public static String GetNameFromPath(String path) {
        String[] pathArr = path.split(File.pathSeparator);
        return pathArr[pathArr.length - 1];
    }
}
