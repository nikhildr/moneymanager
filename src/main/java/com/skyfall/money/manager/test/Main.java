package com.skyfall.money.manager.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "test.json";

        String a = new String(Files.readAllBytes(Paths.get(fileName)));
        System.out.println(a);

    }
}
