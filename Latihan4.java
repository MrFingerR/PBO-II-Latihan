import java.util.*;

public class Latihan4 {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Australia");
        s1.add("Sweden");
        s1.add("Germany");

        Set<String> s2 = new HashSet<>();
        s2.add("Sweden");
        s2.add("France");

        Set<String> union = new TreeSet<>(s1);
        union.addAll(s2); // Union of s1 and s2
        print("Union", union);

        Set<String> intersect = new TreeSet<>(s1);
        intersect.retainAll(s2); // Intersection of s1 and s2
        print("Intersection", intersect);
    }

    protected static void print(String label, Collection<?> c) {
        System.out.println(label);
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
