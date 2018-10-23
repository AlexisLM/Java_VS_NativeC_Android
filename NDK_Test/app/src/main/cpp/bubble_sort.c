//
// Created by Alexis on 10/21/2018.
//

/* Implementation of Bubble sort */
#include <stdio.h>
#include <stdlib.h>
#include "bubble_sort.h"

/**
 * Implementation of BubbleSort.
 * @param arr Array of numbers.
 * @param size Number of elements.
 */
void bubbleSort(int *arr, int size)
{
  int i, j, temp;
  for(i = 0; i < size-1; i++)
    for(j = 0; j < size-i-1; j++)
      if(arr[j] > arr[j+1]){
        temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
      }

  return;
}

/**
 * Method to print an array.
 * @param arr Array of numbers.
 * @param size Number of elements.
 */
void printArray(int *arr, int size)
{
  int i;
  printf("[");
  for(i = 0; i < size; i++)
    if(i == size-1)
      printf(" %d ]\n", arr[i]);
    else
      printf(" %d |", arr[i]);

  return;
}

/**
 * Method that fills the array in decreasing order.
 * @param arr Empty array.
 * @param size Number of elements.
 */
void fillArray(int *arr, int size)
{
  int i;
  for(i = 0; i < size; i++)
    arr[i] = (size - i) * 10;

  return;
}

/**
 * Method that runs BubbleSort with __ARRAY_SIZE elements.
 */
void run_bubble_sort()
{
  int *arr = (int*)malloc(sizeof(int)*__ARRAY_SIZE);
  int n = __ARRAY_SIZE;

  fillArray(arr, n);
  bubbleSort(arr, n);

  free(arr);

  return;
}
