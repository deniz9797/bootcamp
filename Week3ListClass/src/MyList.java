import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<T> {
    T[] arr;
    public MyList(){
        this.arr = (T[] )new Object[10];
    }
    public MyList(int capacity){
        this.arr = (T[] )new Object[capacity];
    }
    public int size(){
        int count=0;
        for(T i: arr){
            if(i != null){
                count++;
            }
        }
        return count;
    }
    public int capacity(){
        return arr.length;
    }
    public void add(T data){
        int i=0;
        while(arr[i]!= null){
            i++;
        }
        if(i==arr.length-1){
            System.out.println("Dolu");
            arr = Arrays.copyOf(arr, arr.length+arr.length);
            arr[i] = data;
        }else{
            arr[i] =data;
        }
    }
    public T get(int index){
        try{
            T res = arr[index];
            return res;
        }catch(Exception e){
            return null;
        }
    }
    public T[] remove(int index){
        try{
            for(int i=index; i<=arr.length-1;i++){
                arr[i] = arr[i+1];
                arr[i+1]=null;
            }
            return arr;
        }catch(Exception e){
            return null;
        }
    }
    public T[] set(int index, T data){
        try{
            arr[index] =data;
            return arr;
        }catch(Exception e){
            return null;
        }
    }
    public String toString(){
        String result = "[";
        int size = size();
        for(int i=0; i<size;i++){
            result += arr[i]+",";
        }
        result +="]";
        return result;
    }

    public int indexOf(T data){
        int size=size();
        for(int i=0;i<size;i++){
            if(arr[i] == data){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        int size=size();
        boolean exist = false;
        int result = -1;
        for(int i=0;i<size;i++){
            if(arr[i] == data){
                result= i;
                exist = true;
            }
        }
        if(exist){
            return result;
        }else{
            return -1;
        }
    }
    public boolean isEmpty(){
        int size=size();
        for(int i=0; i<size;i++){
            if(arr[i] != null){
                return false;
            }
        }
        return true;
    }
    public T[] toArray(){
        return Arrays.copyOfRange(arr,0,size());
    }
    public void clear(){
        new MyList();
    }
    public MyList<T> subList(int start,int finish){
        int size = finish-start+1;
        MyList<T> list= new MyList<>(size);
        for(int i=start;i<=finish;i++){
            list.add(arr[i]);
        }
        return  list;
    }
    public boolean contains(T data){
        for(int i=0; i<size();i++){
            if(arr[i] == data){
                return true;
            }
        }
        return false;
    }

}
