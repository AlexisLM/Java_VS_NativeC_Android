package ndk_test.app.alexis.com.ndk_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  // Used to load the 'native-lib' library on application startup.
  static {
    System.loadLibrary("native-lib");
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Bubble Sort from C
    Button btn_bb_sort_c = (Button) findViewById(R.id.btn_bb_sort_c);
    btn_bb_sort_c.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        bubbleSortC();
      }
    });

    // Bubble Sort from Java
    Button btn_bb_sort_java = (Button) findViewById(R.id.btn_bb_sort_java);
    btn_bb_sort_java.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        bubbleSortJava();
      }
    });

    // Memory Allocation from C
    Button btn_mry_alloc_c = (Button) findViewById(R.id.btn_mry_alloc_c);
    btn_mry_alloc_c.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        memoryAllocationC();
      }
    });

    // Memory Allocation from Java
    Button btn_mry_alloc_java = (Button) findViewById(R.id.btn_mry_alloc_java);
    btn_mry_alloc_java.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        memoryAllocationJava();
      }
    });

  }

  private void bubbleSortC(){
    TextView tv_bb_sort_c = (TextView) findViewById(R.id.bb_sort_c_text);
    tv_bb_sort_c.setText("Running Bubble Sort from C...\n");

    long bubble_start_time = System.nanoTime();
    bubbleSort();
    long bubble_runtime = System.nanoTime() - bubble_start_time;

    tv_bb_sort_c.append("Finished in "+bubble_runtime+" nanoseconds.");
  }

  private void bubbleSortJava(){
    TextView tv_bb_sort_java = (TextView) findViewById(R.id.bb_sort_java_text);
    tv_bb_sort_java.setText("Running Bubble Sort from Java...\n");

    BubbleSort bubbleSort = new BubbleSort();

    long bubble_start_time = System.nanoTime();
    bubbleSort.run();
    long bubble_runtime = System.nanoTime() - bubble_start_time;

    tv_bb_sort_java.append("Finished in "+bubble_runtime+" nanoseconds.");
  }

  private void memoryAllocationC(){
    TextView tv_mry_alloc_c = (TextView) findViewById(R.id.bb_sort_c_text);
    tv_mry_alloc_c.setText("Running Heap Memory Allocation from C...\n");

    long mry_start_time = System.nanoTime();
    memoryAllocation();
    long mry_runtime = System.nanoTime() - mry_start_time;

    tv_mry_alloc_c.append("Finished in "+mry_runtime+" nanoseconds.");
  }

  private void memoryAllocationJava(){
    TextView tv_mry_alloc_java = (TextView) findViewById(R.id.bb_sort_java_text);
    tv_mry_alloc_java.setText("Running Heap Memory Allocation from Java...\n");

    long mry_start_time = System.nanoTime();
    int user_input = 5;
    char[] c = new char[4000*user_input];
    long mry_runtime = System.nanoTime() - mry_start_time;

    tv_mry_alloc_java.append("Finished in "+mry_runtime+" nanoseconds.");
  }

  /**
   * A native method that is implemented by the 'native-lib' native library,
   * which is packaged with this application.
   */
  public native void bubbleSort();

  public native void memoryAllocation();
}
