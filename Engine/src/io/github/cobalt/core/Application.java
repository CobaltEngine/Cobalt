package io.github.cobalt.core;

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

        if(!OnCreate()) return;
        while(window.IsRunning()) {
            if(!OnUpdate(1)) break;
            window.Update();
        }
        window.Destroy();
        OnClose();
    }

    public Window GetWindow() {return window;}
}
