import java.util.*;

public class Main {
    static int[] calSum(int a[], int b[], int n, int m) {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();

        int carry = 0;
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            int currSum = a[i] + b[j] + carry;
            int rem = currSum % 10;
            carry = currSum / 10;

            ans.add(rem);
            i--;
            j--;
        }

        while (i >= 0) {
            int currSum = a[i] + carry;
            int rem = currSum % 10;
            carry = currSum / 10;

            ans.add(rem);
            i--;
        }

        while (j >= 0) {
            int currSum = b[j] + carry;
            int rem = currSum % 10;
            carry = currSum / 10;

            ans.add(rem);
            j--;
        }

        if (carry > 0) {
            ans.add(carry);
        }

        Collections.reverse(ans);

        int[] sol = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            sol[k] = ans.get(k);
        }

        return sol;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();
        sc.close();

        int[] res = calSum(arr1, arr2, n1, n2);
        for (int i : res)
            System.out.println(i);
    }
}

class Solution {
    public void printMultiplication(int[][] a, int[][] b, int n) {
        // Write code here and print output

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // System.out.println("Work here for C " + row + " ," + col);
                int work = 0;

                // do work for me C [row][col]
                for (int k = 0; k < n; k++) {
                    // System.out.println("A ->" + row + " " + k + " " + "B ->" + k + " " + col);
                    work += a[row][k] * b[k][col];
                }
                // completed my work

                System.out.print(work + " ");
            }
            System.out.println();
        }

    }
}

public class Main {

    public static String largestNumber(final int[] A) {
        String[] arr = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i] + "";
        }

        Arrays.sort(arr, (a, b) -> {
            Long n1 = Long.parseLong(a + b);
            Long n2 = Long.parseLong(b + a);

            if (n1 > n2) {
                return -1;
            } else if (n1 < n2) {
                return 1;
            } else {
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(largestNumber(arr));
    }
}

public class Main {

    public static int searchInsert(int[] arr, int tar) {
        // Write code here
        int n = arr.length;
        int pos = n;
        int si = 0;
        int ei = n - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] > tar) {
                pos = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return pos;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A, B));
    }
}

public class Main {

    static int[] subtract(int[] n1, int[] n2) {
        List<Integer> sub = new ArrayList<>();
        int i = n1.length - 1, j = n2.length - 1, c = 0;
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : n1[i--];
            int b = j < 0 ? 0 : n2[j--];
            int sum = a - b + c;
            if (sum < 0) {
                c = -1;
                sum += 10;
            } else {
                c = 0;
            }
            sub.add(sum);
        }

        // Swap num1 and num2, then do it again.
        if (c < 0) {
            int[] tmp = subtract(n2, n1);
            tmp[0] *= -1;
            return tmp;
        }
        Collections.reverse(sub);

        // Remove leading zeros
        int start = 0;
        while ((sub.get(start) == 0) && (start < sub.size() - 1))
            start++;
        int[] ans = new int[sub.size() - start];
        for (int k = 0; k + start < sub.size(); k++) {
            ans[k] = sub.get(start + k);
        }
        return ans;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();
        sc.close();

        int[] res = subtract(arr1, arr2);
        for (int i : res)
            System.out.println(i);
    }
}

public class Main {
    public static int[] findTheWay(int[][] matrix) {
        // Write code here

        int r = 0;
        int c = 0;

        // dir 1->east, 2->south, 3->west, 4->north
        int dir = 1;

        while (true) {
            if (matrix[r][c] == 1) {
                // turn 90deg right
                dir++;
                if (dir == 5) {
                    dir = 1;
                }

                // convert 1 -> 0 to avoid cycle
                matrix[r][c] = 0;
            }

            if (dir == 1) {
                // going east
                c++;
            } else if (dir == 2) {
                // going south
                r++;
            } else if (dir == 3) {
                // going west
                c--;
            } else {
                // going north
                r--;
            }

            // exited or not
            if (r < 0) {
                // top exit
                return new int[] { r + 1, c };
            } else if (c == matrix[0].length) {
                // right exit
                return new int[] { r, c - 1 };
            } else if (r == matrix.length) {
                // bottom exit
                return new int[] { r - 1, c };
            } else if (c < 0) {
                // left exit
                return new int[] { r, c + 1 };
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int result[] = findTheWay(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}

public class Main {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        // Write your code here
        int n = mat.length;
        int m = mat[0].length;

        int si = 0;
        int ei = n - 1;
        int ridx = -1;

        while (si <= ei) {
            // get mid
            int mid = (si + ei) / 2;

            if (mat[mid][m - 1] == x) {
                return true;
            } else if (mat[mid][m - 1] > x) {
                ridx = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        if (ridx == -1) {
            return false;
        }

        si = 0;
        ei = m - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (mat[ridx][mid] == x) {
                return true;
            } else if (mat[ridx][mid] > x) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if (SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

public class Main {
    static boolean isPalindrome(String str) {
        int si = 0;
        int ei = str.length() - 1;

        while (si <= ei) {
            if (str.charAt(si) != str.charAt(ei)) {
                return false;
            } else {
                si++;
                ei--;
            }
        }

        return true;
    }

    static void palindromeSubStrs(String s) {
        // Write your code here
        int n = s.length();

        ArrayList<String> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String str = s.substring(i, j + 1);
                if (isPalindrome(str) == true) {
                    list.add(str);
                }
            }
        }

        // lexo order
        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            String currString = list.get(i);
            String nextString = list.get(i + 1);

            if (currString.equals(nextString) == false) {
                System.out.println(currString);
            } else {
                continue;
            }
        }

        System.out.println(list.get(list.size() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        palindromeSubStrs(s);
    }
}

public class Main {
    public static int[] floorAndCeil(int key, int[] arr) {
        // Write code here
        int si = 0;
        int ei = arr.length - 1;

        // just smaller
        int floor = -1;

        // just greater
        int ceil = -1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == key) {
                return new int[] { key, key };
            } else if (arr[mid] > key) {
                ceil = arr[mid];
                ei = mid - 1;
            } else {
                floor = arr[mid];
                si = mid + 1;
            }
        }

        return new int[] { floor, ceil };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] result = floorAndCeil(key, arr);
        System.out.println(result[0] + " " + result[1]);
        sc.close();
    }
}