package com.yang.dachang.timet24t08t08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 作者：洋哥
 * 描述：牛逼
 */
public class IndexHeap<T> {

    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comparator;

    public IndexHeap(Comparator<T> comparator) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comparator = comparator;
    }

    public void push(T data) {
        heap.add(data);
        indexMap.put(data, heapSize);
        adjust(heapSize++);
    }

    public T get(int index) {
        return heap.get(index);
    }

    public void set(int index, T data) {
        indexMap.remove(heap.get(index));
        heap.set(index, data);
        indexMap.put(data, index);
        adjust(index);
    }

    public T delete(int index) {
        T result = heap.get(index);
        swap(index, --heapSize);
        adjust(index);
        return result;
    }

    public T pop() {
        return delete(0);
    }

    private void adjust(int index) {
        heapInsert(index);
        heapify(index);
    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get((index - 1) / 2), heap.get(index)) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int right = left + 1;
            int best = right < heapSize && comparator.compare(heap.get(right), heap.get(left)) < 0 ? right : left;
            best = comparator.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
            if (best == index) {
                break;
            }
            swap(index, best);
            index = best;
        }
    }

    private void swap(int a, int b) {
        T temp = heap.get(a);
        indexMap.put(heap.get(a), b);
        indexMap.put(heap.get(b), a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

}
