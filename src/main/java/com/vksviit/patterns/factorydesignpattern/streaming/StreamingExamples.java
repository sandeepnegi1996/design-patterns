package com.vksviit.patterns.factorydesignpattern.streaming;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

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
/*

        TODO : Create a buffered reader to read from a file and then Write to another file
        take a file sameple 4.txt and write the content in another file sammple5.txt
        // open a buffered reader on sample4.txt and buffered writer on sample5.txt
        // read and start writing once done -> after while close the connections
        // also print the lines that are written


*/


        try (BufferedReader reader4 = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/sample4.txt")), 16384);
             BufferedWriter writer4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/sample5.txt")), 16384)) {

            String currentLine;
            while ((currentLine = reader4.readLine()) != null) {
                System.out.println(currentLine);
                writer4.write(currentLine);
                writer4.write("\n");
            }


        } catch (Exception e) {
            e.printStackTrace();

        }




        //TODO : read from a file  that contains 10k records and create chunks of 1k
        // steps
        // open buffered reader
        // read lines
        // count all the
        // and when count % maxLines(1000) then create new chunk


        BufferedReader bufferedReader2=null;
        BufferedWriter bufferedWriter2 = null;

        try{

            bufferedReader2= new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/sample6.txt"), StandardCharsets.UTF_8));

            String currentString;
            int count=0;
            while ((currentString = bufferedReader2.readLine())!=null) {

                if (count++ %10==0) {
                    //create new file
                   if (bufferedWriter2!=null) {
                       bufferedWriter2.close();
                   }

                    System.out.println("count is  :  " +count);
                    bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/com/vksviit/patterns/factorydesignpattern/streaming/chunks/smallChunk" + (count/10) +".txt"  ),StandardCharsets.UTF_8));
                    System.out.println("chunk name is :   "+ "smallChunk" +(count/10));
                }
                bufferedWriter2.write(currentString);
                bufferedWriter2.newLine();

            }




        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader2!=null) {

                bufferedReader2.close();
            }
            if (bufferedWriter2!=null) {
                bufferedWriter2.close();
            }

        }
















    }
}
