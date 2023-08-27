package Ex2_2;

public class Ex2_2 {
    public static void main(String[] args){
        // test case of values
        Integer[] data = {45, -2, -45, 78, 30, -42, 10, 19, 73, 93};
        mergeSort3(data);
        System.out.println("After 3 way merge sort: ");
        for (int d : data)
            System.out.print(d + " ");
    }

    public static void mergeSort3(Integer[]arr){
        //make a copy of the given array
        Integer[] arr2 = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i] = arr[i];
        }
        mergeSort3Rec(arr,0,arr.length-1,arr2);
    }
    public static void mergeSort3Rec(Integer[] arr,int low,int high, Integer[]arr2){
        if (high - low < 2)
            return;

        // Splitting array into 3 parts
        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        // Sorting 3 arrays recursively
        mergeSort3Rec(arr2, low, mid1, arr);
        mergeSort3Rec(arr2, mid1, mid2, arr);
        mergeSort3Rec(arr2, mid2, high, arr);

        // Merging the sorted arrays
        merge(arr2, low, mid1, mid2, high, arr);

    }

    public static void merge(Integer[] arr, int low,
                             int mid1, int mid2, int high,
                             Integer[] arr2)
    {
        int i = low, j = mid1, k = mid2, l = low;

        // choose smaller of the smallest in the three ranges
        while ((i < mid1) && (j < mid2) && (k < high))
        {
            if (arr[i].compareTo(arr[j]) < 0)
            {
                if (arr[i].compareTo(arr[k]) < 0)
                    arr2[l++] = arr[i++];

                else
                    arr2[l++] = arr[k++];
            }
            else
            {
                if (arr[j].compareTo(arr[k]) < 0)
                    arr2[l++] = arr[j++];
                else
                    arr2[l++] = arr[k++];
            }
        }

        while ((i < mid1) && (j < mid2))
        {
            if (arr[i].compareTo(arr[j]) < 0)
                arr2[l++] = arr[i++];
            else
                arr2[l++] = arr[j++];
        }

        while ((j < mid2) && (k < high))
        {
            if (arr[j].compareTo(arr[k]) < 0)
                arr2[l++] = arr[j++];

            else
                arr2[l++] = arr[k++];
        }

        while ((i < mid1) && (k < high))
        {
            if (arr[i].compareTo(arr[k]) < 0)
                arr2[l++] = arr[i++];
            else
                arr2[l++] = arr[k++];
        }

        // copy remaining values from the first range
        while (i < mid1)
            arr2[l++] = arr[i++];

        // copy remaining values from the second range
        while (j < mid2)
            arr2[l++] = arr[j++];

        // copy remaining values from the third range
        while (k < high)
            arr2[l++] = arr[k++];
    }
}
