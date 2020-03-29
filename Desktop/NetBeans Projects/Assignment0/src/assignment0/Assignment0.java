/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment0;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author devonhobbs
 */
public class Assignment0 {
    
    /**
     * @param args the command line arguments
     */
    public static int sequentialSearch(int target, int vals[]){
        for(int j = 0;j < vals.length; j++){
            if(vals[j] == target){
                return j;
            }
          
        }
        return -1;
    }
    
    public static int binarySearch(int target, int vals[]) {
        int left = 0;
        int right = vals.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < vals[middle]) {
                right = middle - 1;
            } else if (target > vals[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
    
    public static void selectionSort(int vals[]){
        int n = vals.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(vals[j] < vals[min]){
                    min = j;
                }
            int temp = vals[min];
            vals[min] = vals[i];
            vals[i] = temp;
            }
        }
    }
    
    public static void insertionSort(int vals[]){
        int n = vals.length;
        for(int i = 1; i < n; i++){
           int key = vals[i];
           int j = i - 1;
           while(j >= 0 && vals[j] > key){
               vals[j + i] = vals[j];
               j = j - 1;
           }
           vals[j + 1] = key;
        }
    }
    
    public static void mergeSort(int vals[], int l, int m, int r){
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = vals[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = vals[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                vals[k] = L[i]; 
                i++; 
            } 
            else
            { 
                vals[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            vals[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            vals[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            mergeSort(arr, l, m, r); 
        } 
    }
    
    public static void printArray(int vals[]){
        int n = vals.length;
        for(int i = 0; i < n; i++){
            System.out.print(vals[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int searchVals[] = {4, 16, 73, 78, 91};
        System.out.println("List to be searched");
        printArray(searchVals);
        int seq = sequentialSearch(78, searchVals);
        System.out.println("Sequential Search: Index " + seq);
        int bin = binarySearch(16, searchVals);
        System.out.println("Binary Search: Index " + bin);
        System.out.println();
        
        Assignment0 selection = new Assignment0();
        Assignment0 insertion = new Assignment0();
        Assignment0 merge = new Assignment0();
        int vals[] = {11, 13, 46, 32, 2};
        System.out.println("Values to be sorted ");
        printArray(vals);
        selection.selectionSort(vals);
        System.out.println("Selection Sort");
        selection.printArray(vals);  
        insertion.insertionSort(vals);
        System.out.println("Insertion Sort");
        insertion.printArray(vals);
        merge.sort(vals, 0, vals.length - 1);
        System.out.println("Merge Sort");
        merge.printArray(vals);
        
        
        // TODO code application logic here
    }
    
}
