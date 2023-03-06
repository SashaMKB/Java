package tlab.Receivers;

import tlab.Interfaces.IEvOutputConsole;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiverOutputConsole implements IEvOutputConsole {
    String logPath = "";

    public ReceiverOutputConsole(String logPath) {
        this.logPath = logPath;
    }

    @Override
    public void Handler() {
        File file = new File(logPath);
        if (file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write("Data has been output in console");
                fileWriter.write("\n");
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("got you (exception)");
            }
        }
    }
}
