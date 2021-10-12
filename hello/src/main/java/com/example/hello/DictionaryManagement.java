package com.example.hello;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DictionaryManagement {
    Scanner sc = new Scanner(System.in);
    private String word_target, word_explain;
    Dictionary arrayWords = new Dictionary();

    /**
     * insert word from file.
     */
    public void  insertFromFile() throws IOException {
        File file = new File("C:/file/dictionaries.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), "\t");
            while (stringTokenizer.hasMoreTokens()) {
                word_target = stringTokenizer.nextToken();
                word_explain = stringTokenizer.nextToken();
                Word word = new Word(word_target, word_explain);
                arrayWords.wordArrayList.add(word);
            }
        }
    }

    public void dictionaryLookup() {
        String input;
        input = sc.nextLine();
        StringTokenizer string = new StringTokenizer(input, "\t");
        String inputCommand = string.nextToken();
        String inputTarget = string.nextToken();
        if (inputCommand.equals("lookup")) {
            for (int i = 0; i < arrayWords.wordArrayList.size(); i++) {
                String target = arrayWords.wordArrayList.get(i).getWord_target();
                String explain = arrayWords.wordArrayList.get(i).getWord_explain();
                if (inputTarget.equals(target)) {
                    System.out.printf("%-8s%-24s%-24s\n", "No", "|English", "|Vietnamese");
                    System.out.printf("%-8s%-24s%-24s\n", i + 1, "|" +target, "|" + explain);
                    break;
                } else {
                    return;
                }
            }
        }
    }

    public void dictionaryAdd() {
        String input;
        input = sc.nextLine();
        StringTokenizer string = new StringTokenizer(input, "\t");
        while(string.hasMoreTokens()) {
            String inputCommand = string.nextToken();
            String inputTarget = string.nextToken();
            String inputExplain = string.nextToken();

            Word word = new Word(inputTarget, inputExplain);
            if (inputCommand.equals("add")) {
                arrayWords.wordArrayList.add(word);
            }
        }
    }


}
