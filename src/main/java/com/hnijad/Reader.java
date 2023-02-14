package com.hnijad;

import com.hnijad.model.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    private Reader() {
    }

    public static Input getInput(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        return new Input(Arrays.stream(reader.nextLine().split(","))
                .map(Integer::parseInt)
                .toList(),
                Integer.parseInt(reader.nextLine()));
    }
}