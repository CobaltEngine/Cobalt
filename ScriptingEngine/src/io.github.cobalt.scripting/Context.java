package io.github.cobalt.scripting;

public interface Context {
    void LoadFile(String path);

    void Run();

    int     GetInt(String key);
    double  GetDouble(String key);
    String  GetString(String key);
    boolean GetBool(String key);

    void SetInt(String key, int value);
    void SetDouble(String key, double value);
    void SetString(String key, String value);
    void SetBool(String key, boolean value);

    void CallFunc(String name, Object... args);
}
