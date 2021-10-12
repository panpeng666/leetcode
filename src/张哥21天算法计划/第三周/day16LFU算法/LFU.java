package 张哥21天算法计划.第三周.day16LFU算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class LFUCache {
     HashMap<Integer,Integer> keyToValue;
     HashMap<Integer,Integer> keyToFreq;
     HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
     int minFreq;
     int cap;
     public  LFUCache(int capacity){
         keyToValue=new HashMap<>();
         keyToFreq=new HashMap<>();
         freqToKey=new HashMap<>();
         this.minFreq=0;
         this.cap=capacity;
     }
    public int get(int key) {
        if (!keyToValue.containsKey(key))return -1;
        makeRecently(key);
        return keyToValue.get(key);
    }
    //key一定存在，此时需要给kf表加一
    private void makeRecently(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        // 将 key 从 freq 对应的列表中删除
        freqToKey.get(freq).remove(key);
        freqToKey.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKey.get(freq+1).add(key);
        if (freqToKey.get(freq).isEmpty()){
            freqToKey.remove(freq);
            if (freq==minFreq){
                minFreq++;
            }
        }

    }
    private void removeLeast(){
         //先获取最小的这个
        LinkedHashSet<Integer> temp = freqToKey.get(this.minFreq);
        //这个里面的第一个就是需要删除的key
        int removeTemp = temp.iterator().next();
        temp.remove(removeTemp);
        if (temp.isEmpty()){
            freqToKey.remove(this.minFreq);
        }
        keyToValue.remove(removeTemp);
        keyToFreq.remove(removeTemp);
    }

    public void put(int key, int value) {
         if (this.cap<=0)return;
        if (keyToValue.containsKey(key)){
            keyToValue.put(key,value);
            makeRecently(key);
            return;
        }
        if (this.cap<=keyToValue.size()){
            removeLeast();
        }
        keyToValue.put(key,value);
        keyToFreq.put(key,1);
        freqToKey.putIfAbsent(1,new LinkedHashSet<>());
        freqToKey.get(1).add(key);
        this.minFreq=1;
    }


}
