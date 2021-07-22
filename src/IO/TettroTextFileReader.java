package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Driver.Driver;
import IO.IOInterface.Readable;

import Object.Plate;

public class TettroTextFileReader implements Readable {
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Plate getPlate() {
        if (fileName == null) {
            System.out.println("getPlate error. 파일 이름이 null.");
            return null;
        }

        Plate plate = null;
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (true) {
                String line = br.readLine();
                if (plate == null) plate = new Plate(line.length());
                if (line == null) break;
                plate.addRow(count, line);
                count++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((plate != null ? plate.getAmount() : 0) % 4 != 0) {
            System.out.println("input txt파일 에러. 4의 배수가 아님.");
            Driver.fileInfo.setPuzzleNum(-1);
        } else
            Driver.fileInfo.setPuzzleNum((plate != null ? plate.getAmount() : 0) / 4);

        return plate;
    }
}
