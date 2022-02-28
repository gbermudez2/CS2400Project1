public class ArrayBagTest {
    public static void main(String[] args){
        BagInterface<String> aBag = new ResizableArrayBag<>();
        BagInterface<String> anotherBag = new ResizableArrayBag<>();

        aBag.add("A");
        aBag.add("B");
        aBag.add("C");
        aBag.add("D");
        aBag.add("E");

        anotherBag.add("A");
        anotherBag.add("B");
        anotherBag.add("C");
        anotherBag.add("A");
        anotherBag.add("B");

        aBag.union(anotherBag);
        aBag.intersection(anotherBag);
        aBag.difference(anotherBag);

        anotherBag.union(aBag);
        anotherBag.intersection(aBag);
        anotherBag.difference(aBag);

        // Check size of bag aBag
        aBag.getCurrentSize();

        // Clear bag aBag
        aBag.clear();

        // Check if bag aBag is empty
        aBag.isEmpty();
    }
}
