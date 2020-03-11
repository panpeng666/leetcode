package test;

/**
 * 关于ArraysList底层的个人练习
 * @param <E>
 */
public class ppArraysList <E>{

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY=10;

    public ppArraysList(){
        elementData = new Object[DEFALT_CAPACITY];
    }
    public ppArraysList(int capacity){
        elementData=new Object[capacity];
    }
    public void add(E element){
        if (size == elementData.length){
            Object[] newArraysList = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArraysList,0,elementData.length);
            elementData = newArraysList;
        }
        elementData[size++]=element;
    }

    public void check(int index){
        if (index<0||index>(size-1)){
            throw new  RuntimeException("索引不合法"+index);
        }
    }

    public E get(int index){
        check(index);
        return (E)elementData[index];
    }

    public void set(E element,int index){
        check(index);
        elementData[index]=element;
    }
//a b c d
    public void remove(int index){
        int num = elementData.length-index-1;
        if (num>0){
            System.arraycopy(elementData,index,elementData,index-1,num);
        }
        elementData[--size]=null;
    }

    public void remove(E element){
        if (element.equals(null)){
            throw  new  RuntimeException("不能删除null");
        }
        for (int i=0;i<size;i++){
            if (element.equals(elementData[i])){
                remove(i+1);
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return  size==0?true:false;
    }



    public static void main(String[] args) {
        ppArraysList pp = new ppArraysList();
//        pp.add("6666");
//        pp.add("jjj");
        ppArraysList pp01 = new ppArraysList(11);
        for (int i=0;i<40;i++){
            pp.add(i);
        }
        System.out.println(pp.toString());
        pp.set("4444444",10);
       System.out.println( pp.get(10));
       pp.remove(9);
       pp.remove("4444444");

        System.out.println(pp.toString());
    }
}
