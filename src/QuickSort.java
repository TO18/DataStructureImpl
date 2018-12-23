import java.util.*;
import java.lang.*;
import java.math.*;

class QuickSort {
    private static List<Integer> quickSort(List<Integer> arrayList) {
        if (arrayList.size() < 2) {
            return arrayList;
        }

        final int lastIndex = (arrayList.size() - 1);
        sort(arrayList, 0, lastIndex);
        return arrayList;
    }

    private static void sort(List<Integer> arrayList, final int startIndex, final int lastIndex) {
        if (startIndex < lastIndex) {
            final int pivotIndex = partition(arrayList, startIndex, lastIndex);
//        System.out.println(arrayList);
            sort(arrayList, startIndex, (pivotIndex - 1));
            sort(arrayList, (pivotIndex + 1), lastIndex);
        }
    }

    private static int partition(List<Integer> arrayList, final int startIndex, final int lastIndex) {
        final int pivotValue = arrayList.get(lastIndex);
        int pivotIndex = 0;
        for (int index = startIndex; index < lastIndex; index++) {
            final int indexValue = arrayList.get(index);
            if (indexValue < pivotValue) {
                swap(arrayList, pivotIndex, index, indexValue);
                pivotIndex++;
            }
        }
        swap(arrayList, pivotIndex, lastIndex, pivotValue);
        return pivotIndex;
    }

    private static void swap(List<Integer> arrayList, final int pivotIndex, final int index, final int indexValue) {
        final int pivotIndexTempValue = arrayList.get(pivotIndex);
        arrayList.set(pivotIndex, indexValue);
        arrayList.set(index, pivotIndexTempValue);
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(4);
//        System.out.println(arrayList);
        List<Integer> sortedList = quickSort(arrayList);
        System.out.println(sortedList);
    }
}