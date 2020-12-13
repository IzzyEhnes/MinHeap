import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class MinHeap
{
    private int[] heap;
    private int size;
    private int maxSize;



    public MinHeap(int inMaxSize)
    {
        this.heap = new int[inMaxSize];
        this.size = 0;
        this.maxSize = inMaxSize;
    }



    public int[] getHeap()
    {
        return heap;
    }



    public void setHeap(int[] inHeap)
    {
        this.heap = inHeap;
    }



    public int getSize()
    {
        return size;
    }



    public void setSize(int inSize)
    {
        this.size = inSize;
    }



    public int getMaxSize()
    {
        return maxSize;
    }



    public void setMaxSize(int inMaxSize)
    {
        this.maxSize = inMaxSize;
    }



    private int getParent(int currentIndex)
    {
        return ((currentIndex - 1) / 2);
    }



    private int getLeftChild(int currentIndex)
    {
        return ((currentIndex * 2) + 1);
    }



    private int getRightChild(int currentIndex)
    {
        return ((currentIndex * 2) + 2);
    }



    public void swap(int firstElement, int secondElement)
    {
        int temp = heap[firstElement];
        heap[firstElement] = heap[secondElement];
        heap[secondElement] = temp;
    }



    public void insert(int inElement)
    {
        if (size == maxSize)
        {
            System.out.println("The heap has reached max capacity - " + inElement + " cannot be added.");
            return;
        }

        size++;
        heap[size - 1] = inElement;

        int currentIndex = size - 1;

        while (currentIndex > 0 && heap[getParent(currentIndex)] > heap[currentIndex])
        {
            swap(getParent(currentIndex), currentIndex);
            currentIndex = getParent(currentIndex);
        }
    }



    public void delete(int inIndex)
    {
        if (inIndex > size - 1)
        {
            System.out.println("\nInvalid index - element could not be deleted");

            return;
        }

        heap[inIndex] = heap[0];
        int currentIndex = inIndex;

        while (currentIndex > 0 && heap[getParent(currentIndex)] > heap[currentIndex])
        {
            swap(getParent(currentIndex), currentIndex);
            currentIndex = getParent(currentIndex);
        }

        int currentSize = size;
        int lastElement = heap[currentSize - 1];

        heap[0] = lastElement;
        size--;
        makeMinHeap(0);
    }



    public void makeMinHeap(int currentIndex)
    {
        if (size <= 1)
        {
            return;
        }

        int leftChild = getLeftChild(currentIndex);
        int rightChild = getRightChild(currentIndex);

        int minimumIndex = currentIndex;

        if (leftChild < size && heap[leftChild] < heap[currentIndex])
        {
            minimumIndex = leftChild;
        }

        if (rightChild < size && heap[rightChild] < heap[minimumIndex])
        {
            minimumIndex = rightChild;
        }

        if (minimumIndex != currentIndex)
        {
            swap(currentIndex, minimumIndex);
            makeMinHeap(minimumIndex);
        }
    }



    public void printHeap()
    {
        System.out.println();

        for (int i = 0; i < size; i++)
        {
            System.out.println(heap[i]);
        }
    }
}



public class Main
{
    public static MinHeap readFile(String fileName)
    {
        Scanner fileReader = null;

        try
        {
            fileReader = new Scanner(new File(fileName));
        }

        catch (FileNotFoundException fileError)
        {
            System.out.println(String.format
                    ("There was a problem opening file \"%s\": \n\tError = %s", fileName, fileError.getMessage()));

            System.out.println("Exiting program...");

            System.exit(1);
        }

        ArrayList<Integer> temp = new ArrayList<>();

        while (fileReader.hasNext())
        {
            int num = fileReader.nextInt();

            temp.add(num);;
        }

        MinHeap heap = new MinHeap(temp.size());

        for (int num : temp)
        {
            heap.insert(num);
        }

        fileReader.close();

        return heap;
    }



    public static void main(String[] args)
    {
        MinHeap heap = new MinHeap(6);

        heap = readFile("src/input.txt");

        heap.delete(2);
        heap.printHeap();
        heap.delete(0);
        heap.printHeap();
        heap.delete(4);
        heap.printHeap();
        heap.delete(0);
        heap.printHeap();
        heap.delete(1);
        heap.printHeap();
    }
}
