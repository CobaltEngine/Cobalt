package io.github.cobalt.core;

import java.util.*;
import static io.github.cobalt.core.EventHandlers.*;

public class EventSystem {
    private static final List<OnCloseEvent> closeHandlers = new ArrayList<>();
    private static final List<OnMouseMovedEvent> mouseMovedHandlers = new ArrayList<>();
    private static final List<OnMouseClickedEvent> mouseClickedHandler = new ArrayList<>();

    public static void AddCloseHandler(OnCloseEvent handler) {
        closeHandlers.add(handler);
    }

    public static void AddMouseMovedHandler(OnMouseMovedEvent handler) {
        mouseMovedHandlers.add(handler);
    }

    public static void AddMouseClickedHandler(OnMouseClickedEvent handler) {
        mouseClickedHandler.add(handler);
    }

    public static void DispatchCloseEvent() {
        for (OnCloseEvent event : closeHandlers) {
            event.Call();
        }
    }

    public static void DispatchMouseMovedEvent(double x, double y) {
        for (OnMouseMovedEvent event : mouseMovedHandlers) {
            event.Call(x, y);
        }
    }

    public static void DispatchMouseClickedEvent(int button) {
        for (OnMouseClickedEvent event : mouseClickedHandler) {
            event.Call(button);
        }
    }
}
