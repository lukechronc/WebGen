package com.company;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Question{
    String question;
    String answer;

    Question(String question, String answer){
        this.answer = answer;
        this.question = question;

    }
    public void generate(String filename) throws IOException {
        String start;
        String end;
        BufferedReader br = new BufferedReader(new FileReader("startq.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            start = sb.toString();
        }finally {
            br.close();
        }
        BufferedReader br1 = new BufferedReader(new FileReader("endq.txt"));
        try {
            StringBuilder sb1 = new StringBuilder();
            String line = br1.readLine();
            while (line != null) {
                sb1.append(line);
                sb1.append(System.lineSeparator());
                line = br1.readLine();
            }
            end = sb1.toString();
        }finally {
            br1.close();
        }
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.print(start);
        writer.print("<h2>"+question+"</h2>\n" +
                "\t<button onclick=\"myFunction()\" type=\"button\" class=\"btn btn-danger\">Show Answer</button>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"container\" id=\"myDIV\" style=\"display: none;\">\n" +
                "\t<h3>"+answer+"</h3>");



        writer.print(end);
        writer.close();

    }

}
