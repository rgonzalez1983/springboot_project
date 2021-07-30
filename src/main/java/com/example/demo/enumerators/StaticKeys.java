package com.example.demo.enumerators;

public enum StaticKeys {
    SERVER_URL("http://127.0.0.1:5050"),
    INIT_URL("/swagger-ui.html"),
    COMMAND_OPEN_CHROME("cmd /c start chrome.exe " + SERVER_URL.text + INIT_URL.text),
    MESSAGE("MESSAGE"),
    STATUS_CODE("STATUS_CODE"),
    CRUD_OPERATION("CRUD_OPERATION"),
    DATA("DATA"),
    KEY_NAME("name"),
    KEY_LASTNAME("lastname");


    /**
     * Valor ENUM.
     */
    private final String text;

    /**
     * Constructor.
     *
     * @param text
     */
    private StaticKeys(final String text) {
        this.text = text;
    }

    /**
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return this.text;
    }
}
