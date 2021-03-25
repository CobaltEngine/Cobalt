package io.github.cobalt.sandbox;

import io.github.cobalt.core.*;

import io.github.cobalt.scripting.*;
import io.github.cobalt.common.utils.FileWalker;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class Sandbox extends Application {

    public static void main(String[] args) {
        new Sandbox().Start(1080, 720, "Cobalt Sandbox");
    }

    @Override
    public boolean OnUpdate(float ts) {
        for(Map.Entry<String, Context> program : ScriptEngine.GetAllPrograms()) {
            ScriptEngine.CallFunc(program.getKey(), "OnUpdate");
        }
        return true;
    }

    @Override
    public boolean OnCreate() {
        System.out.printf("Loaded %d Scripts%n",ScriptEngine.LoadAll("Scripts/"));
        return true;
    }

    @Override
    public void OnClose() {
        System.out.println("Closing");
    }

}
