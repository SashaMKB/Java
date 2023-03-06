package tlab.Receivers;

import tlab.Interfaces.IEvFileOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiverFileOutput implements IEvFileOutput {
    String logPath = "";

    public ReceiverFileOutput(String logPath) {
        this.logPath = logPath;
    }

    @Override
    public void Handler() {
        File file = new File(logPath);
        if (file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write("Data has been output in file");
                fileWriter.write("\n");
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("got you (exception)");
            }
        }
    }
}
