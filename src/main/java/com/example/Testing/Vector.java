package com.example.Testing;

public class Vector<T extends Comparable<T>> {
    private Object[] elements;  // Array to store elements
    private int size;           // Number of elements in the vector
    private static final int DEFAULT_CAPACITY = 10;  // Default initial capacity

    // Constructor to initialize the vector with a default capacity
    public Vector() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Add an element to the end of the vector
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Add an element at a specific index in the vector
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity();

        // Shift elements to make space for the new element
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    // Remove the first occurrence of a specified element from the vector
    public void remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
        }
    }

    // Remove the element at a specific index from the vector
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Shift elements to remove the element at the given index
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
    }

    // Get the element at a specific index in the vector
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Set the element at a specific index in the vector
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    // Get the current size (number of elements) of the vector
    public int size() {
        return size;
    }

    public int getCapacity() {
        return elements.length;
    }

    // Display the elements in the vector
    public void display() {
        System.out.print("Elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + elements[i]);
        }
        System.out.println();
    }

    // Ensure that the vector has enough capacity to add elements
    private void ensureCapacity() {
        if (size == elements.length) {
            // Double the array size if it reaches capacity
            Object[] newElements = new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Find the index of the first occurrence of a specified element
    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }


    public void quickSort() {
        quickSort(0, size - 1);
    }

    // Recursive method to perform quick sort on a subarray
    private void quickSort(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            quickSort(low, partitionIndex - 1);
            quickSort(partitionIndex + 1, high);
        }
    }

    // Choose a pivot and partition the subarray into two halves
    private int partition(int low, int high) {
        T pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (get(j).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    // Swap elements at two indices in the vector
    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    // Perform a merge sort on the elements in the vector
    public void mergeSort() {
        mergeSort(0, size - 1);
    }

    // Recursive method to perform merge sort on a subarray
    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(low, mid);
            mergeSort(mid + 1, high);

            merge(low, mid, high);
        }
    }

    // Merge two subarrays into a sorted array
    private void merge(int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        // Create temporary arrays to hold the left and right subarrays
        Object[] leftArray = new Object[leftSize];
        Object[] rightArray = new Object[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; ++i) {
            leftArray[i] = elements[low + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArray[j] = elements[mid + 1 + j];
        }

        // Merge the temporary arrays

        int i = 0, j = 0;
        int k = low;
        while (i < leftSize && j < rightSize) {
            if (((T) leftArray[i]).compareTo((T) rightArray[j]) <= 0) {
                elements[k] = leftArray[i];
                i++;
            } else {
                elements[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray[], if there are any
        while (i < leftSize) {
            elements[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray[], if there are any
        while (j < rightSize) {
            elements[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void BubbleSort() {
        boolean swapped;

        for (int i = 0; i < size - 1; i++) {
            swapped = false;

            for (int j = 0; j < size - 1 - i; j++) {
                if (get(j).compareTo(get(j + 1)) > 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }

            // If no swaps were made in this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Perform an insertion sort on the elements in the vector
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            T key = get(i);
            int j = i - 1;

            // Move elements that are greater than key to one position ahead of their current position
            while (j >= 0 && key.compareTo(get(j)) < 0) {
                set(j + 1, get(j));
                j--;
            }

            set(j + 1, key);
        }
    }

    // Perform a selection sort on the elements in the vector
    public void selectionSort() {
        int n = size;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (get(j).compareTo(get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            swap(i, minIndex);
        }
    }

    //Reverse all elements
    public void reverse() {
        int start = 0;
        int end = size - 1;

        while (start < end) {
            // Swap elements at start and end indices
            swap(start, end);

            // Move indices towards the center
            start++;
            end--;
        }
    }

    // Perform a linear search to find the index of a specific element in the vector
    public int linearSearch(T target) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(target)) {
                return i;  // Element found, return its index
            }
        }
        return -1;  // Element not found
    }

    // Perform a lower bound (binary search) to find the index of the first element >= the specified element
    public int lowerBound(T target) {
        int low = 0;
        int high = size;
        int result = size; // Initialize to the position after the last index

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (get(mid).compareTo(target) >= 0) {
                // Move left to find the first occurrence
                result = mid;
                high = mid;
            } else {
                // Move right
                low = mid + 1;
            }
        }

        return result;
    }

    // Perform an upper bound (binary search) to find the index of the first element > the specified element
    public int upperBound(T target) {
        int low = 0;
        int high = size;
        int result = size; // Initialize to the position after the last index

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (get(mid).compareTo(target) > 0) {
                // Move left to find the last occurrence
                result = mid;
                high = mid;
            } else {
                // Move right
                low = mid + 1;
            }
        }

        return result;
    }

}
