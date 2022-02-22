// CS2400
// Project 1
// Gabriel Bermudez, Drew Higashigawa, Jose Gutierrez

public interface BagInterface<T>{
    public boolean add(T anEntry); // adds an item to the bag

    public boolean remove(T anEntry); // removes an item from the bag

    public int getCurrentSize(); // gets size of bag

    public boolean isEmpty(); // checks if bag is empty

    public void clear(); // clears the bag

    public int getFrequencyOf(T anEntry); // checks frequency of an item

    public boolean contains(T anEntry); // checks if bag has an item

    public void display(); // displays bag

    public void union(BagInterface<T> otherBag); // displays a bag that combines two existing bags

    public void intersection(BagInterface<T> otherBag); // displays a bag that contains common items

    public void difference(BagInterface<T> otherBag); // displays a bag that removes commonalities one existing bag has with another
}