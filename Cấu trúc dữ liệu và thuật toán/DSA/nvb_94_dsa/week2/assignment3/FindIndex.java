package nvb.assignment3;

public class FindIndex {
    public static void main(String[] args) {
        int [] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int iKey = 2;

        int [][] sample = new int[array.length][2];
        for (int i = 0; i < array.length; i++) {
            sample[i][0] = array[i];
            sample[i][1] = i;
        }
        int value = sample[iKey][0];
        mergeSort(sample, 0, sample.length - 1);

        for (int i = 0; i < sample.length; i++) {
            if (sample[i][1] == iKey) {
                System.out.println("Vị trí của a[" + iKey + "] sau khi sắp xếp là: " + i);
                break;
            }
        }
        
    }

    public static int [][] merge(int [][] array, int left, int mid, int right) {
        int [][] l = new int[mid - left + 1][2];
        int [][] r = new int[right - mid][2];

        for (int i = left; i <= mid; i++) {
            l[i - left][0] = array[i][0];
            l[i - left][1] = array[i][1];
        }
        for (int j = mid + 1; j <= right; j++) {
            r[j - mid - 1][0] = array[j][0];
            r[j - mid - 1][1] = array[j][1];
        }

        int i = 0, j = 0, index = left;

        while (i < l.length && j < r.length) {
            if (l[i][0] <= r[j][0]) {
                array[index][0] = l[i][0];
                array[index][1] = l[i][1];
                i++;
            } else {
                array[index][0] = r[j][0];
                array[index][1] = r[j][1];
                j++;
            }
            index++;
        }

        while (i < l.length) {
            array[index][0] = l[i][0];
            array[index][1] = l[i][1];
            i++;
            index++;
        }

        while (j < r.length) {
            array[index][0] = r[j][0];
            array[index][1] = r[j][1];
            j++;
            index++;
        }

        return array;

    }

    public static void mergeSort(int [][] array, int left, int right) {
        if (left < right) {
            int mid  = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

}
