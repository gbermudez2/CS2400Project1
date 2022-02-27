import java.util.Iterator;

public class LinkedBag<T> implements BagInterface<T>{
    private Node<T> firstNode; // Defines the first node of the bag
    private int numberOfEntries; // Determines the number of entries in a bag

    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean add(T newEntry){ // Adds a new node to the bag
        Node<T> newNode = new Node<T>(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;

        return true;
    }

    public T remove() throws NullPointerException { // Removes a node at the first position if possible
        T result = null;

        if (firstNode != null){
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        else
            throw new NullPointerException("No object to remove!"); // If there are no items, throw an error

        return result;
    }

    public boolean remove(T newEntry){
        boolean result = false;
        Node<T> nodeN = getReferenceTo(newEntry);

        if (nodeN != null){
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }

        return result;
    }

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

    public int getCurrentSize(){
        return numberOfEntries; // returns number of items in bag
    }

    public boolean isEmpty(){
        return numberOfEntries == 0; // if 0, return true
    }

    public void clear(){
        while (!isEmpty())
            remove();
    }

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

        return frequency;
    }

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

        return found;
    }

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

        return result;
    }

    public BagInterface<T> union(BagInterface<T> otherBag){
        BagInterface<T> result = new LinkedBag<>();

        T[] array1 = this.toArray();
        T[] array2 = otherBag.toArray();

        for (T element : array1){
            result.add(element);
        }

        for (T element : array2){
            result.add(element);
        }

        return result;
    }

    public BagInterface<T> intersection(BagInterface<T> otherBag){
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

        return result;
    }

    public BagInterface<T> difference(BagInterface<T> otherBag){
        BagInterface<T> result = new LinkedBag<>();

        T[] array1 = this.toArray();
        T[] array2 = otherBag.toArray();

        for (T element1 : array1){
            for (T element2 : array2){
                if (element1 == element2){
                    break;
                }
                else
                    result.add(element1);
            }
        }

        return result;
    }

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
