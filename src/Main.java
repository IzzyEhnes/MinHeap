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
    public static void main(String[] args)
    {
        MinHeap heap = new MinHeap(6);

        /*
        heap.insert(12);
        heap.insert(7);
        heap.insert(6);
        heap.insert(10);
        heap.insert(8);
        heap.insert(20);
        heap.delete(0);
         */


        heap.insert(3);
        heap.insert(1);
        heap.insert(6);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        heap.delete(4);
        heap.insert(3);
        heap.delete(0);


        heap.printHeap();
    }
}
