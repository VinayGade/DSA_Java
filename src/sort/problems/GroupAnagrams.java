package sort.problems;

import java.util.Arrays;
import java.util.Comparator;

//Sort array of Strings so that all Anagrams are next to each other

class AnagramComparator implements Comparator<String> {

    String sortCharacters(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    @Override
    public int compare(String s1, String s2) {
        return sortCharacters(s1).compareTo(sortCharacters(s2));
    }
}
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"name", "angel", "beast","beat","cars","acre", "chaser", "angle",
                            "amen", "beats", "beta","care", "mane", "scar", "search",
                            "abcde","race","java", "mean", "glean", "arcs", "arches"};

        Arrays.sort(strings, new AnagramComparator());

        Arrays.stream(strings).forEach(System.out::println);
    }
}
