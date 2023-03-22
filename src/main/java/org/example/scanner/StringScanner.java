package org.example.scanner;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StringScanner {
    private Scanner scanner = new Scanner(System.in);

    public Scanner getStringScanner(){
        return scanner;
    }
}
