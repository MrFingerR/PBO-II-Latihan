import java.util.*;
public class Latihan3 {
    public static void main(String[] args) {
        String[] words = {"saya", "ingin", "lulus", "saya", "akan", "berusaha"};
        Set<String> uniques = new HashSet<String>();

        Set<String> dups = new HashSet<String>();
        
        for (String a : words)
            if (!uniques.add(a))
                dups.add(a);
        // Destructive set-difference
        uniques.removeAll(dups);
        System.out.println("Unique words: " + uniques);
        System.out.println("Duplicate words: " + dups);
}
}