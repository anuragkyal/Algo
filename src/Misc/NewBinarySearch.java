package Misc;

/**
 * Created by anurag on 11/13/14.
 */
public class NewBinarySearch {
    public int binarySearch(int[] numbers, int n, int start, int end){
        int mid = (start + end)/2;

        if(start == end){
            if(n == numbers[start]){
                return start;
            }
        }else if(n >= numbers[start] && n<=numbers[mid]){
            return binarySearch(numbers, n , start, mid);
        }else if(n >= numbers[mid+1] && n <= numbers[end]){
            return binarySearch(numbers, n, mid+1, end);
        }

        return -1;
    }

    public static void main(String args[]){
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        NewBinarySearch newBinarySearch = new NewBinarySearch();
        System.out.println(newBinarySearch.binarySearch(numbers, 5, 0, numbers.length - 1));
    }
}
