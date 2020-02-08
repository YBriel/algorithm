package queue;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/12/30   13:46
 */
public class ArrayQueue {

    private int maxSize; //数组最大的容量
    private int front; //队列头
    private int rear; //队列尾部
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("此队列已满，无法添加！");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    public int getQueue(){
        if(!isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i:arr){
            System.out.print(" "+i);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front+1];
    }

    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
        boolean empty = queue.isEmpty();
        boolean full = queue.isFull();
        System.out.println(empty);
        System.out.println(full);
    }
}

