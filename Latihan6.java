import java.util.*;

public class Latihan6 {
    public static void main(String[] args) {

        Vector<String> vc=new Vector<String>();

        vc.add("Vector Object 1");
        vc.add("Vector Object 2");
        vc.add("Vector Object 3");
        vc.add("Vector Object 4");
        vc.add("Vector Object 5");
        vc.add(3, "Element at fix position");
        System.out.println("Vector Size :"+vc.size());
        for(int i=0;i<vc.size();i++)
        {
        System.out.println("Vector Element "+i+" :"+vc.get(i));
        }
    }
}