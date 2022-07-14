package SuperArray;

public class SuperArray {
    private int[] elements;
    private int currentIndex = -1;
    public SuperArray(){
        elements = new int[10];
    }
    public SuperArray(int capacity){
        elements = new int[capacity];
    }
    //增:
    public void add(int data){
        currentIndex++;
        if (currentIndex > elements.length - 1){
            int[] temp;
            temp = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
        elements[currentIndex] = data;
    }
    //删:
    public void delete(int index){
        if (index < 0 || index > elements.length - 1){
            System.out.println("Index error(index == "+ index +"), can't delete.");
        } else{
            for (int i = index + 1; i < elements.length - 1; i++) {
                elements[i - 1] = elements[i];
            }
            currentIndex--;
        }
    }
    //改:
    public void set(int index, int data){
        if (index < 0 || index > elements.length - 1){
            System.out.println("Index error(index == "+ index +"), can't set.");
        } else{
            elements[index] = data;
        }
    }
    //查:
    public int select(int index){
        if (index < 0 || index > elements.length - 1){
            System.out.println("Index error(index == "+ index +"), can't delete.");
            return -404;
        } else{
            return elements[index];
        }
    }
    //长度:
    public int size(){
        return currentIndex - 1;
    }
    //数组转字符串:
    public String arrayToString(){
        String result = "[";
        for (int i = 0; i < currentIndex; i++) {
            result += elements[i] + ", ";
        }
        result = result.substring(0, result.length() - 1) + "]";
        return result;
    }
}
