package com.shelfproject;


public class ShelfSort {
    // Merage elements into orginal Array
    static void merge(int arrr[][], int arr[], int lenArray[], int dup[]) {
        int index = 0, hitorgap = 0, length = 1, dupIndex = 0, lengthCounter = 0;
        boolean dupflag = false;
        if (dup.length > 0) {
            dupflag = true;
        }
        while (index < arr.length) {
            if (lengthCounter >= lenArray[length]) {
                length = length + 1;
                lengthCounter = 0;
                hitorgap = 0;
            } else if ((length > 1 && arrr[length][hitorgap] == 0) || arrr[length][hitorgap] == 0 && hitorgap>0 || arrr[length][hitorgap] == -1 ) {
                hitorgap++;
            } else {
                if (length <= 2) {
                    lengthCounter++;
                    arr[index] = arrr[1][hitorgap];
                    index++;
                    hitorgap++;

                } else {
                    lengthCounter++;
                    arr[index] = arrr[length][hitorgap];
                    index++;
                    hitorgap++;

                }
                if (dupflag == true && dup[dupIndex] == arr[index - 1]) {
                    while (dup[dupIndex] == arr[index - 1]) {
                        arr[index] = arr[index - 1];
                        index++;
                        lengthCounter++;
                        if (dupIndex != dup.length - 1) {
                            dupIndex++;
                        } else {
                            dupflag = false;
                            break;
                        }
                    }

                }

            }
        }

    }

    static void sort(int arr[], int index) {
        int lengthCounter[] = new int[15], tempdup[] = new int[index], DupCounter = 0,insertionSort=0;
        int[][] DimonsunalArray = new int[11][index];
        DimonsunalArray[1][0]=-1;
        tempdup[0]=2147483590;
        for (int i = 0; i < arr.length; i++) {
            String c = "" + arr[i];
            if (c.length() <= 2) {
                lengthCounter[1] = lengthCounter[1] + 1;
            } else {
                lengthCounter[c.length()] = lengthCounter[c.length()] + 1;
            }
            if (arr[i] == DimonsunalArray[1][arr[i]]) {
                DupCounter++;
                insertionSort=DupCounter;
                
                while (true) {     
                   if(insertionSort!=0&&arr[i]<tempdup[insertionSort-1]){
                        tempdup[insertionSort]=tempdup[insertionSort-1];
                        
                        insertionSort--;
                    }else{
                       
                        tempdup[insertionSort]=arr[i];
                        break;
                    }
                
                }
            } else {
                if (c.length() <= 2) {
                    DimonsunalArray[1][arr[i]] = arr[i];
                } else {
                    int x = Character.getNumericValue(c.charAt(0) - 1);
                    String y = "" + x + c.substring(1);
                    if (arr[i] == DimonsunalArray[c.length()][Integer.parseInt(y)]) {
                        DupCounter++;
                        insertionSort=DupCounter;
                        
                
                while (true) {                    
                    if(insertionSort!=0&&arr[i]<tempdup[insertionSort-1]){
                        tempdup[insertionSort]=tempdup[insertionSort-1];
                        insertionSort--;
                    }else{
                        tempdup[insertionSort]=arr[i];
                        break;
                    }
                
                        }
                    }else{
                        DimonsunalArray[c.length()][Integer.parseInt(y)] = arr[i];

                    }
                }}}
        int duplicated[] = new int[DupCounter];
        if (DupCounter >= 1) {
            System.arraycopy(tempdup, 0, duplicated, 0, DupCounter);
        /*            duplicated(duplicated);*/        }
        merge(DimonsunalArray, arr, lengthCounter, duplicated);
    }

    static void printArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
    

    // My algorthim
    public static void main(String args[]) {
        int[] arr = {3,4,3,11,23,4421,2,11,2};//new int[29999999];//max 29999999

                sort(arr, 29999999);
                
            System.out.println("\nSorted array");
            printArray(arr);
                
        }
    }
    //this code is belong to R-Alothaim
    //https://github.com/R-Alothaim/ShelfSort



