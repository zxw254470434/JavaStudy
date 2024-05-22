import java.util.*;

public class Solution380 {
    List<Integer> list;
    Map<Integer, Integer> valToIndex;
    Random random;

    public Solution380() {
        list = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) return false;
        int index = list.size();
        list.add(val);
        valToIndex.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) return false;
        int index = valToIndex.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        valToIndex.put(last, index);

        list.remove(list.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
