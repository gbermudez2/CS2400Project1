// CS2400
// Project 1
// Gabriel Bermudez, Drew Higashigawa, Jose Gutierrez


/*
This interface is subject to change,
feel free to edit if you believe there are any changes necessary
*/

public interface BagInterface<T>{
    public boolean add(T anEntry); // adds an item to the bag

    public T remove(); // removes an item from the bag (unspecified)

    public boolean remove(T anEntry); // removes the specified item

    public int getCurrentSize(); // gets size of bag

    public boolean isEmpty(); // checks if bag is empty

    public void clear(); // clears the bag

    public int getFrequencyOf(T anEntry); // checks frequency of an item

    public boolean contains(T anEntry); // checks if bag has an item

    public T[] toArray(); // displays bag

    public BagInterface<T> union(BagInterface<T> otherBag); // displays a bag that combines two existing bags

    public BagInterface<T> intersection(BagInterface<T> otherBag); // displays a bag that contains common items

    public BagInterface<T> difference(BagInterface<T> otherBag); // displays a bag that removes commonalities one existing bag has with another
}