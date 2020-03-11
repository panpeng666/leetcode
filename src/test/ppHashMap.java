package test;

/**
 * HashMap 底层原理练习
 */

public class ppHashMap<K,V> {
    //先创建位桶数组
    NodeHash[] table = new  NodeHash[16];
    private int size;//定义map中键值对的数量

    public void put(K key,V value){
        NodeHash newNode = new NodeHash();
        newNode.hash=myHash(key.hashCode(),table.length);
        newNode.key=key;
        newNode.value=value;
        newNode.next=null;

        NodeHash temp=table[newNode.hash];
        Boolean flag = true;
        NodeHash a = null;
        //位桶数组的位置为空时，直接置入
        if (temp==null){
            table[newNode.hash]=newNode;
            size++;
        }else {
            //不为空要遍历查看key是否相同，不同就放到最后面


            while(temp!=null){
                //先处理key重复的覆盖
                if(temp.key.equals(key)){
                    flag=false;
                    temp.value=value;
                    break;
                }
                a= temp;
                temp = temp.next;
                }
            if (flag){
                a.next=newNode;
                size++;
            }
            }


        }
    public V getValue(K key){
        V value=null;
        int hash = myHash(key.hashCode(),table.length);
        if (table[hash]!=null){
            NodeHash temp = table[hash];
            while (temp!=null){
                if (temp.key.equals(key)){
                    value=(V)temp.value;
                    break;
                }
                temp=temp.next;
            }

        }

        return value;
    }



    public static int myHash(int v,int length){
        return v&(length-1);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("{");
        NodeHash temp = new NodeHash();
        for (int i=0;i<table.length-1;i++){
            temp=table[i];
            while (temp!=null){
                sb.append(temp.key+"="+temp.value+",");
                temp=temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }


    public static void main(String[] args) {
        ppHashMap pp = new ppHashMap();
        pp.put(64,"共打");
        pp.put(80,"共打666");
        pp.put(96,"测试成功！！！");
        System.out.println(pp.getValue(99));
        System.out.println(pp);
//        for (int i=0;i<100;i++){
//            System.out.println(i+"-----------"+myHash(i,16));
//        }
        //64,80,96
    }
}
