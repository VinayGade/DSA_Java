package trie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*

4
add hack
add hackerrank
find hac
find hak

* */

public class Contacts {

    // Brute-Force
    /*
    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        // trie
        for(List<String> selectedQueries: queries){
            for(String query: selectedQueries){
                //String[] words = query.split(" ");
                if(query.equals("add"))
                    wordList.add(selectedQueries.get(1));
                if(query.equals("find"))
                    keys.add(selectedQueries.get(1));
            }
        }
        for(String key: keys){
            int count = 0;
            for(String word: wordList) {
                if(word.contains(key)){
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }*/

    // Optimised approach: Trie
    // Time Complexity

    private Trie trie;

    public Contacts(){
        trie = new Trie();
    }

    public static void main(String[] args) {
        Contacts solution = new Contacts();

        Scanner scanner = new Scanner(System.in);
        int numOperations = scanner.nextInt();
        scanner.nextLine();
        for ( int no = 0; no < numOperations; no++ ) {
            String strOperation = scanner.nextLine();
            solution.process(strOperation);
        }
        scanner.close();
    }

    private void process(String strOperation) {
        String[] arrStrOperation = strOperation.split(" ");
        String operation = arrStrOperation[0];
        String input = arrStrOperation[1];

        switch (operation) {
            case "add":
                trie.add(input);
                break;
            case "find":
                System.out.println(trie.find(input));
                break;
            default:
                System.err.println("Unknown operation!");
        }
    }

    private static class Trie {
        public Node head;
        public Trie() {
            head = new Node(null);
        }
        public void add(String input) {
            if ( input == null )
                return;
            int inLen = input.length();
            if ( inLen == 0)
                return;

            Node node = head;
            for ( int i = 0; i < inLen; i++ ) {
                char inChar = input.charAt(i);
                int idxInChar = (int)inChar - (int)'a';
                if ( node.next[idxInChar] == null )
                    node.next[idxInChar] = new Node(inChar);
                else
                    node.next[idxInChar].prefixes++;
                node = node.next[idxInChar];
            }
        }
        public int find(String input) {
            if ( input == null )
                return 0;
            int inLen = input.length();
            if ( inLen == 0)
                return 0;

            Node node = head;
            int i = 0;
            while ( i < inLen ) {
                char inChar = input.charAt(i);
                int idxInChar = (int)inChar - (int)'a';
                if ( node.next[idxInChar] == null )
                    break;
                node = node.next[idxInChar];
                i++;
            }
            return ( i == inLen ) ? node.prefixes : 0;
        }
    }

    private static class Node {
        public Character c;
        public int prefixes;
        public Node[] next;
        public Node(Character c) {
            this.c = c;
            prefixes = 1;
            next = new Node[26];
        }
    }

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Contacts.contacts(queries);
        result.forEach(System.out::println);

        bufferedReader.close();
    }*/
}
