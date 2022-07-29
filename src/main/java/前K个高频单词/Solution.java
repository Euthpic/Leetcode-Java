package 前K个高频单词;

//

import java.util.*;

/**
 * 构造小根堆,最顶层元素即最小元素
 * 若堆中元素大于k,则弹出最顶层元素
 *
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> countMap=new HashMap<>();
        for (String word : words) {
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> minHeap=new PriorityQueue<>((s1,s2)->{
            if(countMap.get(s1).equals(countMap.get(s2))){
                return s2.compareTo(s1);
            }else{
                return countMap.get(s1)-countMap.get(s2);
            }
        });
        for (String s : countMap.keySet()) {
            minHeap.offer(s);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<String> res=new LinkedList<>();
        while (minHeap.size()>0){
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
