package com.vksviit.patterns.factorydesignpattern.streaming;

import java.io.*;

public class StreamingExamples {
    public static void main(String[] args) throws IOException {


        System.out.println("reading from FileReader Started...");
        //read from a file using FileReader
        File file=null;
        FileReader fileReader=null;
        StringBuilder sb=new StringBuilder();
        try {
             file = new File("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/sample.txt");
            fileReader = new FileReader(file);
            int currentChar=0;

            while(  (currentChar=fileReader.read())!=-1) {
                    char ch = (char)currentChar;
                    sb.append(ch);

            }

            System.out.println(sb);

        }catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fileReader!=null) {
                fileReader.close();
            }
        }


        System.out.println("reading from FileReader Ended...");
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("reading from BufferedReader  Started...");
        //read the same file using buffered Reader
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/sample2.txt"));
            String currentLine;
           while(  (currentLine =bufferedReader.readLine())!=null) {
               System.out.println(currentLine);
           }

        }catch (IOException e) {
            e.printStackTrace();

        } finally {

            if(bufferedReader!=null) {
                bufferedReader.close();
            }
        }


        System.out.println("reading from BufferedReader Ended ...");

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("reading from BufferedReader2   Started...");
        //read the same file using buffered

        try {
            System.out.println("reading from sameple 3 ");
            bufferedReader = new BufferedReader( new InputStreamReader( new FileInputStream(("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/sample3.txt"))) );
            String currentLine;
            while(  (currentLine =bufferedReader.readLine())!=null) {
                System.out.println(currentLine);
            }

        }catch (IOException e) {
            e.printStackTrace();

        } finally {

            if(bufferedReader!=null) {
                bufferedReader.close();
            }
        }


        System.out.println("reading from BufferedReader Ended ...");
    }
}
