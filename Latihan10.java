import java.util.*;

public class Latihan10 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        Vector v = new Vector();
        v.add("4");
        v.add("5");

        arrayList.addAll(v);
        System.out.println("After appending all elements of Vector, ArrayList contains..");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}