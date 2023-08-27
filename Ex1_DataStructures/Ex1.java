// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Ex1 {
    // ID : 212510739_314749961
    //testing our code
    public static void main(String[] args) {
        int[]arr = new int[100000];
        for(int i =0; i<arr.length;i++){
            arr[i] = (int)(Math.random()*100);
        }
        double startT = System.currentTimeMillis();
        String s = rangeOfK(arr,3);
        double endT = System.currentTimeMillis();
        System.out.println(s + (endT - startT));
    }

    public static String rangeOfK(int[] arr , int k){
        int firstIndex = searchForFirstK(arr,k);
        int lastIndex = searchForLastK(arr,k);
        //if the first index is -1 the last index will be the same .
        if(firstIndex==-1){return "[-1,-1]";}
        String ans = "[" + firstIndex + "," + lastIndex + "]";
        return ans;
    }
    //private function the return the index of first k in the given array (binary search). O(log(n))
    private static int searchForFirstK(int[]arr, int k){
        int start = 0 , end = arr.length-1 , result = -1;
        while(start<=end){
            int middle = (start + end)/2;
            if(arr[middle] == k){
                result = middle;
                end = middle -1;
            }
            else if(arr[middle] > k){
                end = middle -1;
            }
            else{
                start = start+1;
            }
        }
        return result;
    }
    //private function the return the index of last k in the given array (binary search). O(log(n))
    private static int searchForLastK(int[]arr, int k){
        int start = 0 , end = arr.length-1 , result = -1;
        while(start<=end){
            int middle = (start + end)/2;
            if(arr[middle] == k){
                result = middle;
                start = middle +1;
            }
            else if(arr[middle] > k){
                end = middle -1;
            }
            else{
                start = start+1;
            }
        }
        return result;
    }
}