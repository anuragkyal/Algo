package HackerRank;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by anurag on 11/18/14.
 */
public class QuickSort {
    public void sort(int[] array, int start, int end){
        if(start >= end){
            return;
        }

        int i = start;
        int j = start+1;
        int pivot = end;

        int swap = 0;

        /*while(i != pivot || j != pivot){
            if(array[i] > array[pivot]){
                int temp = array[i];
                array[i] = array[pivot];
                array[pivot] = temp;
                pivot = i;
                swap++;
            }else if(i != pivot){
                i++;
            }

            if(array[j] <= array[pivot] && j != pivot){
                int temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
                pivot = j;
                swap++;
            }else if(j != pivot){
                j--;
            }
        }*/

        while(j < end){
            if(array[i] > array[pivot] && array[j] <= array[pivot]){
                //Swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }else if(array[i] > array[pivot] && array[j] > array[pivot]){
                j++;
            }else{
                i++;
                j++;
            }
        }

        if(array[i] > array[pivot]) {
            int temp = array[i];
            array[i] = array[end];
            array[end] = temp;
            pivot = i;
        }

        for(int k=0; k<array.length; k++){
            System.out.print(array[k] + " ");
        }
        System.out.println();

        sort(array, start, pivot - 1);
        sort(array, pivot+1, end);
    }

    public int[] readData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(bufferedReader.readLine());

        int[] array = new int[l];

        String[] line = bufferedReader.readLine().split(" ");
        for(int i=0; i<l; i++){
            array[i] = Integer.parseInt(line[i]);
        }

        return array;
    }

    public static void main(String args[]) throws IOException {
        QuickSort quickSort = new QuickSort();
        int[] array = quickSort.readData();
        quickSort.sort(array, 0, array.length-1);
    }
}
