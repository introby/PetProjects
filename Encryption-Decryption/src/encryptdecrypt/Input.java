package encryptdecrypt;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Input {
    private String mode;
    private int key;
    private String data;
    private String inFile;
    private String outFile;
    private String alg;

    public Input() {
        this.mode = "enc";
        this.key = 0;
        this.data = "";
        this.inFile = "";
        this.outFile = "";
        this.alg = "shift";
    }

    public static Input getInput(String[] args) {
        Input input = new Input();

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    input.mode = args[i + 1];
                    break;
                case "-key":
                    input.key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    input.data = args[i + 1];
                    break;
                case "-in":
                    input.inFile = args[i + 1];
                    break;
                case "-out":
                    input.outFile = args[i + 1];
                    break;
                case "-alg":
                    input.alg = args[i + 1];

            }
        }

        return input;
    }

    public void start(Input input) {
        String dataForCrypt = "";

        if (input.data.equals("")) {
            try {
                dataForCrypt = new String(Files.readAllBytes(Paths.get(input.inFile)));
            } catch (Exception e) {
                System.out.println("Error");;
            }
        } else {
            dataForCrypt = input.data;
        }

        String outputData = Crypt.crypt(dataForCrypt, input.key, input.mode, input.alg);

        writeData(outputData, input.outFile);
    }

    void writeData(String outputData, String outputFile) {

        if (!outputFile.equals("")) {

            try {
                FileWriter writer = new FileWriter(outputFile);

                writer.write(outputData);
                writer.close();
            } catch (Exception e) {
                System.out.println("Error");
            }
        } else {
            System.out.println(outputData);
        }
    }

}
