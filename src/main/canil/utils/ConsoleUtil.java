package main.canil.utils;

import java.io.IOException;

public class ConsoleUtil {

    public void pause() throws IOException {
        System.out.println("\nDigite ENTER para continuar....");
        System.in.read();
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
