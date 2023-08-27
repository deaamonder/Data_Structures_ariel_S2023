package Ex2_1;

import java.util.ArrayList;

public class Ex2_1 {
    public static void main(String[] args){
        Point[] points = {new Point(4,5),new Point(6,9),new Point(9,3),new Point(8,6),new Point(5,7)
                ,new Point(3,1),new Point(2,6),new Point(1,4) ,new Point(7,2)};
        ArrayList<Point> maxima = maxima(points);
        System.out.println(maxima);
    }

    public static ArrayList<Point> maxima(Point[] points){
        ArrayList<Point> ans = new ArrayList<Point>();
        mergeSort(points,0,points.length-1);//O(nlogn)
        int count = points.length-1;
        while(count>0){//O(n){
            if(points[count].y()>points[count-1].y() || points[count].x()>points[count-1].x()) {
                ans.add(points[count]);
            }
            if(points[count].y()<points[count-1].y() || points[count].x()<points[count-1].x())
                break;
            count--;
        }
        return ans;
    }

    //private function that sort the given array by distance from (0,0) with time complexity O(nlogn) uses merge sort
    private static void sortByDis(Point[] points , int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Point[] leftArr = new Point[n1];
        Point[] rightArr = new Point[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = points[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = points[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].distance() <= rightArr[j].distance()) {
                points[k] = leftArr[i];
                i++;
            } else {
                points[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            points[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            points[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(Point[] points, int left, int right){
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(points, left, middle);
            mergeSort(points, middle + 1, right);

            sortByDis(points, left, middle, right);
        }
    }
}
