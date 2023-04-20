package com.shelfproject;

/**
 * Hello world!
 *
 */
public class ShelfSort {
    // Merage elements into orginal Array
    static void merge(int arrr[][], int arr[], int max2[], int dup[]) {
        int index = 0, counter = 0, m = 1, r = 0, j = 0;
        boolean dupflag = false;
        if (dup.length > 0) {
            dupflag = true;
        }
        while (index < arr.length) {
            if (j >= max2[m]) {
                m = m + 1;
                j = 0;
                counter = 0;
            } else if ((m > 1 && arrr[m][counter] == 0) || arrr[m][counter] == 0 && counter>0 || arrr[m][counter] == -1 ) {
                counter++;
            } else {
                if (m <= 2) {
                    j++;
                    arr[index] = arrr[1][counter];
                    index++;
                    counter++;

                } else {
                    j++;
                    arr[index] = arrr[m][counter];
                    index++;
                    counter++;

                }
                if (dupflag == true && dup[r] == arr[index - 1]) {
                    while (dup[r] == arr[index - 1]) {
                        arr[index] = arr[index - 1];
                        index++;
                        j++;
                        if (r != dup.length - 1) {
                            r++;
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
        int max2[] = new int[15], tempdup[] = new int[index], dup = 0,xx=0;
        int[][] arrr = new int[11][index];
        arrr[1][0]=-1;
        tempdup[0]=2147483590;
        for (int i = 0; i < arr.length; i++) {
            String c = "" + arr[i];
            if (c.length() <= 2) {
                max2[1] = max2[1] + 1;
            } else {
                max2[c.length()] = max2[c.length()] + 1;
            }
            if (arr[i] == arrr[1][arr[i]]) {
                dup++;
                xx=dup;
                
                while (true) {     
                   if(xx!=0&&arr[i]<tempdup[xx-1]){
                        tempdup[xx]=tempdup[xx-1];
                        
                        xx--;
                    }else{
                       
                        tempdup[xx]=arr[i];
                        break;
                    }
                
                }
            } else {
                if (c.length() <= 2) {
                    arrr[1][arr[i]] = arr[i];
                } else {
                    int x = Character.getNumericValue(c.charAt(0) - 1);
                    String y = "" + x + c.substring(1);
                    if (arr[i] == arrr[c.length()][Integer.parseInt(y)]) {
                        dup++;
                        xx=dup;
                        
                
                while (true) {                    
                    if(xx!=0&&arr[i]<tempdup[xx-1]){
                        tempdup[xx]=tempdup[xx-1];
                        xx--;
                    }else{
                        tempdup[xx]=arr[i];
                        break;
                    }
                
                        }
                    }else{
                     arrr[c.length()][Integer.parseInt(y)] = arr[i];

                    }
                }}}
        int duplicated[] = new int[dup];
        if (dup >= 1) {
            System.arraycopy(tempdup, 0, duplicated, 0, dup);
        /*            duplicated(duplicated);*/        }
        merge(arrr, arr, max2, duplicated);
    }

    static void printArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
    

    // My algorthim
    public static void main(String args[]) {
        int[] arr = {3,4,66,3,11,23,4421,2,11,2};//new int[29999999];//max 29999999

                sort(arr, 29999999);
                
            System.out.println("\nSorted array");
            printArray(arr);
                
        }
    }



