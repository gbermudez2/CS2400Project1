
public class LinkedBagTest extends LinkedBag{
    public static void main(String[] args){
        // Tests on a bag that is empty
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        aBag.toArray();
        aBag.isEmpty();

        // Define new test string
        String[] testStrings1 = {"", "B"};

        // Add items in array to bag aBag
        for (String item : testStrings1){
            aBag.add(item);
        }

        // Displaying bag with added items
        aBag.toArray();

        // Does bag contain B?
        aBag.contains("B");

        // Remove B from bag
        aBag.remove("B");

        // Does bag contain A?
        aBag.contains("A");

        // Define new test string
        String[] testStrings2 = {"test1", "A", "C", "test2"};

        // Add items in array to bag aBag
        for (String item2 : testStrings2){
            aBag.add(item2);
        }

        // Display bag with added items
        aBag.toArray();

        // Check if bag is empty
        aBag.isEmpty();

        // Define another bag
        BagInterface<String> anotherBag = new LinkedBag<>();
        
        // Define new test string
        String [] testStrings3 = {"A", "A", "B", "C"};
        
        // Add items in array to bag anotherBag
        for (String item3 : testStrings3){
            anotherBag.add(item3);
        }

        // Check frequency of A in anotherBag
        anotherBag.getFrequencyOf("A");

        // Create a union between aBag and anotherBag
        aBag.union(anotherBag);

        // Make a bag with intersecting items between aBag and anotherBag
        aBag.intersection(anotherBag);

        // Make a bag that excludes shared items between aBag and anotherBag
        aBag.difference(anotherBag);

        // Same last 3 functions but reversed
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