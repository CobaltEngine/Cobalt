import io.github.cobalt.core.Application;

public class Sandbox extends Application {
    public static void main(String[] args) {
        new Sandbox().Start(1080, 720, "Cobalt Sandbox");
    }

    @Override
    public boolean OnUpdate(float ts) {
        System.out.println("Updating");
        return false;
    }

    @Override
    public boolean OnCreate() {
        System.out.println("Creating");
        return true;
    }

    @Override
    public void OnClose() {
        System.out.println("Closing");
    }
}
