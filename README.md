# Bug summary
After `EditText` is being recycled in `RecyclerView`, its long press behavior which used to select all text, and show context menu "Cut/Copy/Paste", no longer work as expected.

This problem occurs from Android 15 till Android 28.

I tried both `EditText` and `android.support.v7.widget.AppCompatEditText`. Both yields same problem.

I can confirm this problem occurs after `View` is being recycled. If I apply `setIsRecyclable(false);` in `ViewHolder`, the problem will not occur.

# Steps to reproduce
1. Long press on 1st `EditText`. We can confirm all text in `EditText` will be selected. Context menu will be shown.
2. Scroll `RecyclerView` till the end of list.
3. Scroll `RecyclerView` till the start of list.
4. Long press on 1st `EditText`. All text in `EditText` will NOT be selected. Context menu will NOT be shown.

# Expected behavior
After the view has been recycled, we expect step 4 will still behave exactly same as step 1.
