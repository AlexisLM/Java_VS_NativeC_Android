package ndk_test.app.alexis.com.ndk_test;

public class BubbleSort {

  private final int __ARRAY_SIZE = 5000; //Number of elements

  /**
   * Implementation of BubbleSort.
   * @param arr Array of numbers.
   * @param size Number of elements.
   */
  void bubbleSort(int arr[], int size){

    int i, j, temp;
    for(i = 0; i < size-1; i++)
      for(j = 0; j < size-i-1; j++)
        if(arr[j] > arr[j+1]){
          temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
  }

  /**
   * Method that fills the array in decreasing order.
   * @param arr Empty array.
   * @param size Number of elements.
   */
  private void fillArray(int[] arr, int size){

    for(int i = 0; i < size; i++)
      arr[i] = (size - i) * 10;

  }

  /**
   * Method to print an array.
   * @param arr Array of numbers.
   * @param size Number of elements.
   */
  private void printArray(int[] arr, int size){

    System.out.print("[");
    for(int i = 0; i < size; i++)
      if(i == size-1)
        System.out.print(" "+arr[i]+" ]\n");
      else
        System.out.print(" "+arr[i]+" |");

  }

  /**
   * Method that runs BubbleSort with __ARRAY_SIZE elements.
   */
  void run(){

    int arr[] = new int[__ARRAY_SIZE];
    int n = __ARRAY_SIZE;

    fillArray(arr, n);
    bubbleSort(arr, n);

  }

}
