package io.github.cobalt.jsfml;

import io.github.cobalt.core.EventSystem;
import io.github.cobalt.core.Window;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class JSFML_Window extends Window {
    RenderWindow renderWindow;
    private boolean isRunning = false;
    public JSFML_Window(int width, int height, String title) {
        renderWindow = new RenderWindow(new VideoMode(width, height), title);
        isRunning = true;
        EventSystem.AddCloseHandler(this::OnCloseEvent);

    }


    @Override
    public boolean IsRunning() {
        return isRunning;
    }

    @Override
    public void Update() {
        for (Event event : renderWindow.pollEvents()) {
            switch(event.type) {
                case CLOSED -> EventSystem.DispatchCloseEvent();
                case MOUSE_MOVED -> EventSystem.DispatchMouseMovedEvent(event.asMouseEvent().position.x, event.asMouseEvent().position.y);
                case MOUSE_BUTTON_PRESSED -> EventSystem.DispatchMouseClickedEvent(event.asMouseButtonEvent().button.ordinal());
            }
        }

        renderWindow.display();
    }

    @Override
    public void Destroy() {
        renderWindow.close();
    }

    private void OnCloseEvent() {isRunning = false;}
}
