import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        final int m = 3, n = 3;
        merge(num1, m, num2, n);
//        for (int value: num1) {
//            System.out.println(value);
//        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        BinaryTree BT = new BinaryTree(nums1, m);
//        System.out.println(BT.elements);
        BT.insert(nums2, n);
        BT.sort();
//        System.out.println(BT.elements);
        for (int index = 0; index < (m + n); index++) {
            nums1[index] = BT.elements.get(index);
//            System.out.println(nums1[index]);
        }
    }
}

class BinaryTree {
    public List<Integer> elements;
    BinaryTree(int[] elements, int length) {
        this.elements = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            this.elements.add(elements[index]);
        }
    }

    public void insert(int[] elements, int length) {
        for (int index = 0; index < length; index++) {
            this.elements.add(elements[index]);
        }
    }

    public void sort () {
        Collections.sort(this.elements);
    }
}
