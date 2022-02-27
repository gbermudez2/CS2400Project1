import java.util.Iterator;

public class LinkedBag<T> implements BagInterface<T>{
    private Node<T> firstNode; // Defines the first node of the bag
    private int numberOfEntries; // Determines the number of entries in a bag

    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }

    // Adds a new node to the bag
    public boolean add(T newEntry){
        Node<T> newNode = new Node<T>(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;

        System.out.println("\nAdded item " + newEntry);

        return true;
    }

    // Removes a node at the first position if possible
    public T remove() throws NullPointerException {
        T result = null;

        if (firstNode != null){
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;

            System.out.println("Item successfully removed.");
        }
        else
            // If there are no items, throw an error
            throw new NullPointerException("No object to remove!");

        return result;
    }

    // Removes node with given data
    public boolean remove(T newEntry) throws NullPointerException { 
        boolean result = false;
        Node<T> nodeN = getReferenceTo(newEntry);

        if (nodeN != null){
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;

            System.out.println("Item " + newEntry + " successfully removed from bag.");
        }
        else
            // If item doesn't exist, throw an error
            throw new NullPointerException("No object to remove!");

        return result;
    }

    // Reference a certain entry in the bag, used for removing items
    private Node getReferenceTo(T newEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode !=null)){
            if (newEntry.equals(currentNode.getData())){
                found = true;
            }
            else
                currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    // Returns the size of the bag
    public int getCurrentSize(){
        System.out.println("Bag contains " + numberOfEntries + " items.");
        return numberOfEntries; // returns number of items in bag
    }

    // Checks if bag is empty
    public boolean isEmpty(){
        if (numberOfEntries == 0)
            System.out.println("\nBag empty.");
        else
            System.out.println("\nBag is not empty.");
        return numberOfEntries == 0; // if 0, return true
    }

    // Clears the entire bag of all items
    public void clear(){
        while (!isEmpty())
            remove();

        System.out.println("Bag cleared.");
    }

    // Check how many of a certain item is in the bag
    public int getFrequencyOf(T newEntry){
        int frequency = 0;
        int counter = 0;
        Node<T> currentNode = firstNode;

        while ((counter < numberOfEntries) && (currentNode != null)){
            if (newEntry.equals(currentNode.getData())){
                frequency++;
            }

            counter++;
            currentNode = currentNode.getNextNode();
        }

        System.out.println("Item " + newEntry + " appears " + frequency + " times.");

        return frequency;
    }

    // Check if bag contains a certain item
    public boolean contains(T newEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)){
            if (newEntry.equals(currentNode.getData())){
                found = true;
            }
            else
                currentNode = currentNode.getNextNode();
        }

        if (found == true)
            System.out.println(newEntry + " was found!");
        else
            System.out.println(newEntry + " was not found.");

        return found;
    }

    // Converts bag to array, and displays it
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node<T> currentNode = firstNode;

        while ((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        
        System.out.println("\nDisplaying current Linked Bag: ");
        for (T item : result){
            System.out.print(item + " ");
        }
        
        return result;
    }

    // Combines two bags together, and returns the resulting bag
    public BagInterface<T> union(BagInterface<T> otherBag){
        System.out.println("\n\n-- Performing union function --");
        
        BagInterface<T> result = new LinkedBag<>();

        T[] array1 = this.toArray();
        T[] array2 = otherBag.toArray();

        for (T element : array1){
            result.add(element);
        }

        for (T element : array2){
            result.add(element);
        }

        T[] resultArray = result.toArray();

        System.out.println("\nThe new bag union contains these items: ");
        for (T item : resultArray){
            System.out.print(item + " ");
        }

        return result;
    }

    // Returns bag that contains shared items between two existing bags
    public BagInterface<T> intersection(BagInterface<T> otherBag){
        System.out.println("\n\n-- Performing intersection function --"); 
        BagInterface<T> result = new LinkedBag<>();

        T[] array1 = this.toArray();
        T[] array2 = otherBag.toArray();

        for (T element1 : array1){
            for (T element2 : array2){
                if (element1 == element2){
                    result.add(element1);
                    break;
                }
            }
        }

        T[] resultArray = result.toArray();

        System.out.println("\nThe new bag intersection contains these items: ");
        for (T item : resultArray){
            System.out.print(item + " ");
        }

        return result;
    }

    // Returns the difference of one bag from another
    public BagInterface<T> difference(BagInterface<T> otherBag){
        System.out.println("\n\n-- Performing difference function --");
        BagInterface<T> result = new LinkedBag<>();

        T[] array1 = this.toArray();
        T[] array2 = otherBag.toArray();

        for (T element1 : array1){
            for (T element2 : array2){
                if (element1 != element2){
                    break;
                }
                else
                    result.add(element1);
                    break;
            }
        }

        T[] resultArray = result.toArray();

        System.out.println("\nThe new bag difference contains these items: ");
        for (T item : resultArray){
            System.out.print(item + " ");
        }

        return result;
    }

    // Creates a new Node class
    private class Node<T> {
        private T data;
        private Node next;
    
        private Node(T dataPortion){
            this(dataPortion, null);
        }
    
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
    
        private T getData(){
            return data;
        }
    
        private void setData(T newData){
            data = newData;
        }
    
        private Node getNextNode(){
            return next;
        }
    
        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }
}
