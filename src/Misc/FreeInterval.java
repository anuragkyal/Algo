package Misc;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by anurag on 11/6/14.
 */

public class FreeInterval {
    public Pair<Integer, Integer> findMaximumInterval(Pair<Integer, Integer>[] booked){
        Pair<Integer, Integer>[] sorted = quickSort(booked, 0, booked.length-1);
        Integer[] maxOccupied = new Integer[sorted.length];

        maxOccupied[0] = sorted[0].getValue();

        Integer max = 0;
        Pair<Integer, Integer> maxInterval = null;

        for(int i=1; i<sorted.length; i++){
            if(sorted[i].getKey() > maxOccupied[i-1]){
                System.out.println("Free:" + maxOccupied[i-1] + "-" + sorted[i].getKey());

                if(sorted[i].getKey() - maxOccupied[i-1] > max){
                    max = sorted[i].getKey() - maxOccupied[i-1];
                    maxInterval = new Pair<Integer, Integer>(sorted[i].getKey(), maxOccupied[i-1]);
                }
            }

            maxOccupied[i] = Math.max(maxOccupied[i-1], sorted[i].getValue());
        }

        System.out.println("Max:" + maxInterval.getValue() + "-" + maxInterval.getKey());
        return null;
    }

    public Pair<Integer, Integer>[] quickSort(Pair<Integer, Integer>[] booked, int start, int end){
        int pivot = end;
        int origStart = start;
        int origEnd = end;

        if(start >= end){
            return booked;
        }

        while(start != pivot || end != pivot){
            while(booked[start].getKey() <= booked[pivot].getKey() && start != pivot){
                start++;
            }

            if(start != pivot){
                Pair<Integer, Integer> temp = booked[start];
                booked[start] = booked[pivot];
                booked[pivot] = temp;
                pivot = start;
            }

            while (booked[end].getKey() > booked[pivot].getKey()){
                end--;
            }

            if(end != pivot){
                Pair<Integer, Integer> temp = booked[end];
                booked[end] = booked[pivot];
                booked[pivot] = temp;
                pivot = end;
            }
        }

        quickSort(booked, origStart, pivot-1);
        quickSort(booked, pivot+1, origEnd);

        return booked;
    }

    public static void main(String args[]){
        FreeInterval freeInterval = new FreeInterval();
        Pair<Integer, Integer>[] booked = new Pair[10];
        Random random = new Random();

        for(int i=0; i<10; i++){
            int start = Math.abs(random.nextInt()%100);
            int end = start + Math.abs(random.nextInt()%20);
            booked[i] = new Pair<Integer, Integer>(start, end);
        }

        freeInterval.findMaximumInterval(booked);
    }
}
