package com.yang.dachang.timet24t10.time18;

import java.util.zip.Adler32;

/**
 * 测试客户端
 */
public class TestClient {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(5);
        heap.printAll();
    }

}
