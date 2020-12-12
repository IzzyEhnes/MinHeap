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
}



public class Main
{
    public static void main(String[] args)
    {

    }
}
