import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 稍微给大佬版本加了个注释，不懂的小伙伴可以看下就明白了~
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);  //对字母进行排序

            // map.computeIfAbsent(new String(s),k->new ArrayList<>())
            //     .add(str);

            // 上述computeIfAbsent方法做的事情
            if(map.containsKey(new String(s))){
                // 先判断map中是否有排序后的字母作为key，有的话直接获取list值，添加未排序的str
                map.get(new String(s)).add(str);
            }else{
                // map中没有排序后的字母作为的key，创建一个新的list，添加str
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(new String(s), temp);
            }
        }
        return new ArrayList<>(map.values());
    }
}
