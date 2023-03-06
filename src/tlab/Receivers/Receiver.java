package tlab.Receivers;

import tlab.Interfaces.IEv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Receiver implements IEv {
    String logPath = "";

    public Receiver(String logPath) {
        this.logPath = logPath;
    }

    @Override
    public void Handler() {
        File file = new File(logPath);
        if (file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write("Its five(5)");
                fileWriter.write("\n");
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("got you (exception)");
            }
        }
    }
}
