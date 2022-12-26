class Solution 

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            a[i] = Integer.valueOf(arr[i]);
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (Integer.bitCount(x) - Integer.bitCount(y) == 0) {
                    return x - y;
                } else {
                    return Integer.bitCount(x) - Integer.bitCount(y);
                }
            }
        });
        for (int i = 0; i < arr.length; i++)
            arr[i] = a[i];
        return arr;
    }

    public int[] sortByBits(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int arr[], int i, int j) {
        if (i == j)
            return;
        int mid = (j - i) / 2 + i;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        mergeTwoSortedArray(arr, i, mid, j);
    }

    private void mergeTwoSortedArray(int arr[], int i, int mid, int j) {

        int sort[] = new int[j - i + 1];
        int p1 = i, p2 = mid + 1;
        int itr = 0;
        while (p1 <= mid && p2 <= j) {

            if (compare(arr[p1], arr[p2]) < 0) {
                sort[itr++] = arr[p1++];
            } else {
                sort[itr++] = arr[p2++];
            }
        }
        while (p1 <= mid)
            sort[itr++] = arr[p1++];
        while (p2 <= j)
            sort[itr++] = arr[p2++];
        System.arraycopy(sort, 0, arr, i, sort.length);

    }

    public int compare(int a, int b) {
        int diff = Integer.bitCount(a) - Integer.bitCount(b);
        // in case of two or more integers have the same number of 1's
        // you have to sort them in ascending order.
        if (diff == 0)
            return Integer.compare(a, b);

        else
            return diff;
    }
}

// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/