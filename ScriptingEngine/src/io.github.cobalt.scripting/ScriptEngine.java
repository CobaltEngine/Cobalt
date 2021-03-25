package io.github.cobalt.scripting;

import io.github.cobalt.common.utils.FileWalker;
import io.github.cobalt.scripting.contexts.LuaJ_Context;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ScriptEngine {
    private static Map<String, Context> programs = new HashMap<>();

    public static int LoadAll(String baseDir) {
        return FileWalker.Walk(new File(baseDir),ScriptEngine::LoadFile);
    }

    private static void LoadFile(File file) {
        String path = file.getAbsolutePath();
        String type = path.split("\\.")[path.split("\\.").length - 1];
        switch(type.toLowerCase(Locale.ROOT)) {
            case "lua" -> LoadLuaFile(file);
        }
     }

    public static void RunLuaFile(String name,String path) {
        if(new File(path).exists()) {
            System.out.printf("[Cobalt/ScriptingEngine]: Loading script %s as %s%n", path, name);
        } else {
            System.out.printf("[Cobalt/ScriptingEngine]: Missing File %s!%n", path);
            return;
        }

        LuaJ_Context program = new LuaJ_Context();
        program.LoadFile(path);
        program.Run();
        programs.put(name, program);
    }

    public static void LoadLuaFile(File file) {
        String path = file.getPath();
        String name = GetNameFromPath(path);
        if(new File(path).exists()) {
            System.out.printf("[Cobalt/ScriptingEngine]: Loading script %s as %s%n", path, name);
        } else {
            System.out.printf("[Cobalt/ScriptingEngine]: Missing File %s!%n", path);
            return;
        }


        LuaJ_Context program = new LuaJ_Context();
        program.LoadFile(path);
        programs.put(name, program);
    }

    public static int GetInt(String name, String key) {
        if(programs.containsKey(name))
            return programs.get(name).GetInt(key);
        else
            return 0;
    }

    public static boolean GetBool(String name, String key) {
        if(programs.containsKey(name))
            return programs.get(name).GetBool(key);
        else
            return false;
    }

    public static String GetString(String name, String key) {
        if(programs.containsKey(name))
            return programs.get(name).GetString(key);
        else
            return "";
    }


    public static double GetDouble(String name, String key) {
        if(programs.containsKey(name))
            return programs.get(name).GetDouble(key);
        else
            return Double.NaN;
    }

    public static void SetDouble(String name, String key, double value) {
        if(programs.containsKey(name))
            programs.get(name).SetDouble(key, value);
    }

    public static void SetInt(String name, String key, int value) {
        if(programs.containsKey(name))
            programs.get(name).SetDouble(key, value);
    }

    public static void SetBool(String name, String key, boolean value) {
        if(programs.containsKey(name))
            programs.get(name).SetBool(key, value);
    }

    public static void SetDouble(String name, String key, String value) {
        if(programs.containsKey(name))
            programs.get(name).SetString(key, value);
    }

    public static void CallFunc(String name, String func) {
        if(programs.containsKey(name))
            programs.get(name).CallFunc(func);
    }

    public static String GetNameFromPath(String path) {
        String[] pathArr = path.split(File.pathSeparator);
        return pathArr[pathArr.length - 1];
    }

    public static Set<Map.Entry<String, Context>> GetAllPrograms() {
        return programs.entrySet();
    }
}
