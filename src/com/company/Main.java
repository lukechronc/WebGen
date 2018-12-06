package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String oof;
        BufferedReader br = new BufferedReader(new FileReader("start.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            oof = sb.toString();
        } finally {
            br.close();
        }
        System.out.println(oof);
        PrintWriter writer = new PrintWriter("main.html", "UTF-8");
        writer.print(oof);
        ArrayList<String> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) values.add(String.valueOf((i + 1) * 100));
        ArrayList<String> categories = new ArrayList<>(Arrays.asList("Guess the artist", "Decades", "Guess the song", "Finish the lyrics"));
        ArrayList<String> classes = new ArrayList<>(Arrays.asList("primary", "info", "success", "warning", "danger"));
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        for (int i = 0; i < values.size(); i++) {
            writer.print("<div class=\"container\">");
            for (int x = 0; x < categories.size(); x++) {
                String filename = categories.get(x) + values.get(i) + ".html";
                writer.print("<a href=\"" + filename + "\" class=\"btn btn-" + classes.get(i) + "\" role=\"button\" onclick=\"this.style.visibility = 'hidden';\" target=\"_blank\">" + categories.get(x) + " " + values.get(i) + "</a>");
                System.out.println("Category: " + categories.get(x));
                System.out.println("Enter a question: ");
                String question = reader.nextLine();
                System.out.println("Enter an answer: ");
                String answer = reader.nextLine();
                //reader.close();
                Question q = new Question(question, answer);
                q.generate(filename);
            }
            writer.print("</div>");
        }

        writer.print("</body></html>");
        writer.close();



    }

}
