package Misc;

/**
 * Created by anurag on 11/13/14.
 */
public class RotatedBinarySearch {
    public int search(int[] numbers, int n, int start, int end){
        int mid = (start + end)/2;

        if(start == end) {
            if (n == numbers[start]) {
                return start;
            }
        }else if(numbers[start] < numbers[mid] && n >= numbers[start] && n <= numbers[mid]){
            return search(numbers, n, start, mid);
        }else if(numbers[start] >= numbers[mid] && (n >= numbers[start] || n <= numbers[mid])){
            return search(numbers, n, start, mid);
        }else if(numbers[mid+1] < numbers[end] && n >= numbers[mid+1] && n <= numbers[end]){
            return search(numbers, n, mid+1, end);
        }else if(numbers[mid+1] >= numbers[end] && (n >= numbers[mid+1] || n <= numbers[end])){
            return search(numbers, n, mid+1, end);
        }
        return -1;
    }

    public int search2(int[] numbers, int n, int start, int end){
        int mid = (start + end)/2;

        if(start == end){
            if(n == numbers[start]){
                return start;
            }
        } else if(numbers[start] >= numbers[end] && (n >= numbers[start] || n <= numbers[end])){
            int leftResult = search2(numbers, n, start, mid);
            int rightResult = search2(numbers, n, mid+1, end);

            return leftResult > rightResult ? leftResult : rightResult;
        } else if(numbers[start] < numbers[end] && n >= numbers[start] && n <= numbers[end]){
            int leftResult = search2(numbers, n, start, mid);
            int rightResult = search2(numbers, n, mid+1, end);

            return leftResult > rightResult ? leftResult : rightResult;
        }

        return -1;
    }

    //Search has a bug
    //Search2 works!
    public static void main(String args[]){
        int[] numbers = new int[]{7, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        RotatedBinarySearch rotatedBinarySearch = new RotatedBinarySearch();
        System.out.println(rotatedBinarySearch.search2(numbers, 5, 0, numbers.length - 1));
    }
}
