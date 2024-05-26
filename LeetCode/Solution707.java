import java.util.ArrayList;

public class Solution707 {
    ArrayList<Integer> list;

    public Solution707() {
        list = new ArrayList<>();
    }

    public int get(int index) {
        if (index >= list.size()) return -1;
        else return list.get(index);
    }

    public void addAtHead(int val) {
        list.add(0, val);
    }

    public void addAtTail(int val) {
        list.add(val);
    }

    public void addAtIndex(int index, int val) {
        if (index > list.size()) {
            return;
        } else if (index == list.size()) {
            list.add(val);
        } else {
            list.add(index, val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= list.size()) return;
        else list.remove(index);
    }
}
