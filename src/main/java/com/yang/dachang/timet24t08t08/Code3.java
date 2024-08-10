package com.yang.dachang.timet24t08t08;

import java.util.*;

/**
 * 情景题暴力版
 */
public class Code3 {

    public static class Customer {
        public int id;
        public int buyCount;
        public int time;
        public boolean buy;

        public Customer(int id, int buyCount, int time) {
            this.id = id;
            this.buyCount = buyCount;
            this.time = time;
        }
    }

    public static List<List<Customer>> getTarget(int[] arr, boolean[] buys, int k) {
        List<List<Customer>> ans = new ArrayList<>();
        List<Customer> daddy = new ArrayList<>();
        List<Customer> cands = new ArrayList<>();
        Map<Integer, Customer> userMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!buys[i] && !userMap.containsKey(i)) {
                ans.add(daddy);
                continue;
            }

            if (!userMap.containsKey(arr[i])) {
                userMap.put(arr[i], new Customer(arr[i], 0, 0));
            }
            Customer currentCustomer = userMap.get(arr[i]);
            if (buys[i]) {
                currentCustomer.buyCount++;
            } else {
                currentCustomer.buyCount--;
            }
            if (currentCustomer.buyCount == 0) {
                userMap.remove(i);
            }
            if (!cands.contains(currentCustomer) && !daddy.contains(currentCustomer)) {
                currentCustomer.time = i;
                if (daddy.size() < k) {
                    daddy.add(currentCustomer);
                } else {
                    cands.add(currentCustomer);
                }
            }
            clearBuyIsZero(cands);
            clearBuyIsZero(daddy);
            daddy.sort(new ComparatorWithDaddy());
            cands.sort(new ComparatorWithCands());
            ans.add(daddy);
        }
        return ans;
    }

    public static void move(List<Customer> daddy, List<Customer> cands, int i, int k) {
        if (cands.isEmpty()) {
            return;
        }
        if (daddy.size() < k) {
            Customer customer = cands.get(0);
            customer.time = i;
            daddy.add(customer);
            cands.remove(0);
        } else {
            if (cands.get(0).buyCount > daddy.get(0).buyCount) {
                Customer oldDaddy = daddy.get(0);
                daddy.remove(0);
                Customer newDaddy = cands.get(0);
                cands.remove(0);
                oldDaddy.time = i;
                newDaddy.time = i;
                daddy.add(newDaddy);
                cands.add(oldDaddy);
            }
        }
    }

    public static class ComparatorWithDaddy implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.buyCount != o2.buyCount ? (o1.buyCount - o2.buyCount) : (o1.time - o2.time);
        }
    }

    public static class ComparatorWithCands implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.buyCount != o2.buyCount ? (o2.buyCount - o1.buyCount) : (o1.time - o2.time);
        }
    }


    public static void clearBuyIsZero(List<Customer> list) {
        Iterator<Customer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.buyCount == 0) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
