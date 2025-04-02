import java.util.*;

public class Latihan5 {
    public static void main(String[] args) {
List list=new ArrayList();
        list.add("Jenie");
        list.add("Sherly");
        list.add("Nopeliba");
        list.add("Oktria");
        list.add("Angelyne");
        list.add("Michella");
        System.out.println(list);

        System.out.println("2 : "+list.get(2));
        System.out.println("0 : "+list.get(0));

        LinkedList queue = new LinkedList();
        queue.addFirst("Oktria");
        queue.addFirst("Nopeliba");
        queue.addFirst("Jenie");
        queue.addFirst("Michella");
        queue.addFirst("Sherly");
        queue.addFirst("Angelyne");
        System.out.println(queue);
        queue.removeLast();
        System.out.println(queue);
}
}