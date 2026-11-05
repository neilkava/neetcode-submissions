class DynamicArray {
    int[] arr;
    int length;
    int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        length = 0;
        arr = new int[this.capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        length--;
        return arr[length];
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity]; // creating new array with double capacity
        for (int i = 0; i < capacity; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr; // storing the new double capacity array as arr
        capacity = newCapacity;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
