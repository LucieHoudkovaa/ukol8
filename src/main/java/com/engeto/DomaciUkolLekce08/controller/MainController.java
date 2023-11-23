package com.engeto.DomaciUkolLekce08.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@RestController
@RequestMapping("/api/main")

public class MainController {
    @GetMapping ("/scifi")
    public String getScifi() {
        return getFileContent("resources/scifi.txt");
    }

    @GetMapping ("/romatic")
    public String getRomantic() {
        return getFileContent("resources/romatic.txt");
    }
    @GetMapping ("/historic")
    public String getHistoric() {
        return getFileContent("resources/historic.txt");
    }

    private String getFileContent(String fileLocation) {
        File file = new File(fileLocation);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
        if (scanner != null) {
            StringBuilder output = new StringBuilder();
            while (scanner.hasNextLine()) {
                output.append(scanner.nextLine());
            }
            return output.toString();
        } else {
            return "";
        }
    }
}
