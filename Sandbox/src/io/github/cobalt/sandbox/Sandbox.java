package io.github.cobalt.sandbox;

import io.github.cobalt.core.*;
import io.github.cobalt.jsfml.JSFML_Renderer2D;

import java.awt.*;

public class Sandbox extends Application {

    public static void main(String[] args) {
        new Sandbox().Start(1080, 720, "Cobalt Sandbox");
    }

    @Override
    public boolean OnUpdate(float ts) {
        r2d.Clear(Color.BLUE);

        return true;
    }

    @Override
    public boolean OnCreate() {
        ScriptEngine.RunFile("scripts/Test.lua");
        System.out.println("Test_TestVar="+ScriptEngine.GetInt("Test_TestVar"));
        ScriptEngine.CallFunc("Test_TestFunc");
        return true;
    }

    @Override
    public void OnClose() {
        System.out.println("Closing");
    }

}
