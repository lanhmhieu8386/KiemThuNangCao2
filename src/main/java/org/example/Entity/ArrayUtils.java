package org.example.Entity;

public class ArrayUtils {
    public int tinhTong(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Mang khong duoc rong");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 1 || array[i] > 1000) {
                throw new IllegalArgumentException("Cac phan tu trong mang phai tu 1-1000");
            }
            sum += array[i];
        }
        return sum;
    }
}
