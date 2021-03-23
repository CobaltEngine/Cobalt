package io.github.cobalt.core;

public abstract class Application {
    public abstract boolean OnUpdate(float ts);
    public abstract boolean OnCreate(        );
    public abstract void    OnClose (        );

    public void Start(int width, int height, String title) {
        if(!OnCreate()) return;
        while(true) {
            if(!OnUpdate(1)) break;
        }
        OnClose();
    }
}
