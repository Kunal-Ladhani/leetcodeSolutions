class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return naive(nums, k);
        return better(nums, k);
    }

    // sort it and return k th from end = n-k+1 th from start
    // TC = O(NlogN)
    private static int naive(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    
    // without sorting
    private static int better(int[] arr, int k) {
        buildMaxHeap(arr); // TC = O(N)

        // k times
        int n = arr.length, cntr = k;
        for (int i=n-1; i>0 && cntr>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); // logN
            cntr--;
        }

        return arr[n-k];
    }

    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i=n/2-1; i>=0; i--)
            heapify(arr, i, n);
    }

    private static void heapify(int[] arr, int i, int heapSize) {
        while(true) {
            int l = 2*i+1;
            int r = 2*i+2;
            int largest = i;

            if (l < heapSize && arr[l] > arr[largest])
                largest = l;
            
            if (r < heapSize && arr[r] > arr[largest])
                largest = r;
            
            if (largest == i)
                break;
            
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            i = largest;
        }
    }
}