package com.vksviit.patterns.factorydesignpattern.streaming;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;

public class HttpConnectionReaders {


        public static void main(String[] args) throws Exception {

            URL yahooUrl = new URL("https://www.google.com/");

            HttpsURLConnection connection = (HttpsURLConnection)yahooUrl.openConnection();





            //print the content
            print_content(connection);
            print_certificates(connection);


        }

        public  static  void print_content(HttpsURLConnection connection) throws IOException {

            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                int counter=0;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    System.out.println(counter++);
//                    System.out.println(inputLine);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static void print_certificates(HttpsURLConnection connection) {

            if (connection != null) {
                try{
                    int responseCode = connection.getResponseCode();
                    System.out.println("responseCode is " +responseCode);

                    Certificate[] certificate = connection.getServerCertificates();

                    for (Certificate cert :certificate) {

                        // what is certificate type x.509 and Algorithm EC and RSA Ceritifactae Format X.509
                        System.out.println("Certificate Type :  " + cert.getType());
                        System.out.println("Certificate Algorithm :  " + cert.getPublicKey().getAlgorithm());
                        System.out.println("Certificate format  :  " + cert.getPublicKey().getFormat());


                    }

                }catch (IOException exception) {
                    exception.printStackTrace();
                }

            }


        }
    }

