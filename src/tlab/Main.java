package tlab;

import tlab.Receivers.Receiver;
import tlab.Receivers.ReceiverFileOutput;
import tlab.Receivers.ReceiverOutputConsole;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* обращение к потоку вывода на консоль
*  равенство указанного объекта некоторому значению
* Обращение к потоку вывода в указанный файл
* указание пути к файлу журнала  через ввод названия файла
* явная реализация события  */
public class Main {
    public static void main(String[] args) throws IOException {
        {
            System.out.println("Enter path to file where data located:");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            File file = new File(fileName);
            if(file.exists()){
                try {
                    var list = Files.readAllLines(Paths.get(fileName));// array with elements: 1 - path to loq file, 2 - data

                    ReceiverOutputConsole receiver = new ReceiverOutputConsole(list.get(0)); // объект приемника
                    SourceOutputHandler source = new SourceOutputHandler(receiver); // объект источника
                    Receiver receiver1 = new Receiver(list.get(0));
                    Source source1 = new Source(receiver1);
                    ReceiverFileOutput receiverFileOutput = new ReceiverFileOutput(list.get(0));
                    SourceFileOutput sourceFileOutput = new SourceFileOutput(receiverFileOutput);


                    System.out.println("Data has been output in console");
                    source.genEv();

                    String[] str = list.get(1).split(" ");
                    ArrayList<Integer> arr = new ArrayList<>();

                    for (String x: str) {
                        arr.add(Integer.parseInt(x));
                        if (Integer.parseInt(x) == 5) {
                            source1.genEv();
                       }
                    }

                    Collections.sort(arr);

                    for (Integer x: arr)
                        System.out.print(x + " ");

                    FileWriter fileWriter = new FileWriter("src/tlab/result.txt",true);
                    fileWriter.write(String.valueOf(arr));
                    fileWriter.write("\n");
                    fileWriter.close();
                    sourceFileOutput.genEv();

                } catch (IOException e){
                    System.out.println("got you(exception)");
                }
            }
        }
    }
}



