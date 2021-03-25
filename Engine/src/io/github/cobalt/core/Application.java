package io.github.cobalt.core;

import io.github.cobalt.scripting.Context;
import io.github.cobalt.scripting.ScriptEngine;

import java.util.Map;

public abstract class Application {
    Window window;
    protected Renderer2D r2d;

    public abstract boolean OnUpdate(float ts);
    public abstract boolean OnCreate(        );
    public abstract void    OnClose (        );

    public void Start(int width, int height, String title) {
        window = Window.ConstructWindow(width, height, title);
        Mouse.Listen();
        r2d = Renderer2D.ConstructBasedOnContext(window);
        for(Map.Entry<String, Context> program : ScriptEngine.GetAllPrograms()) {
            ScriptEngine.CallFunc(program.getKey(), "OnCreate");
        }
        if(!OnCreate()) return;
        while(window.IsRunning()) {
            for(Map.Entry<String, Context> program : ScriptEngine.GetAllPrograms()) {
                ScriptEngine.CallFunc(program.getKey(), "OnUpdate");
            }
            if(!OnUpdate(1)) break;
            window.Update();
        }
        for(Map.Entry<String, Context> program : ScriptEngine.GetAllPrograms()) {
            ScriptEngine.CallFunc(program.getKey(), "OnDestroy");
        }
        window.Destroy();
        OnClose();
    }

    public Window GetWindow() {return window;}
}
