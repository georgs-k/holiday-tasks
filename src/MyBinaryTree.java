public class MyBinaryTree {

    private Integer value;
    private MyBinaryTree leftChild;
    private MyBinaryTree rightChild;

    private Integer getSmallestValue() {
        Integer nextSmallestValue = value;
        if (leftChild != null && leftChild.value != null) nextSmallestValue = leftChild.getSmallestValue();
        return nextSmallestValue;
    }

    private int addToArray(int nextIndex, int[] array) {
        if (value == null) return nextIndex;
        if (leftChild != null) nextIndex = leftChild.addToArray(nextIndex, array);
        array[nextIndex++] = value;
        if (rightChild != null) nextIndex = rightChild.addToArray(nextIndex, array);
        return nextIndex;
    }

    private int count(int number) {
        if (value == null) return number;
        if (leftChild != null) number = leftChild.count(number);
        number++;
        if (rightChild != null) number = rightChild.count(number);
        return number;
    }

    public int getSize() {
        return count(0);
    }

    // O(log n)
    public boolean add(int value) {
        if (this.value == null) {
            this.value = value;
            return true;
        }
        if (value < this.value) {
            if (leftChild == null) leftChild = new MyBinaryTree();
            return leftChild.add(value);
        }
        if (value > this.value) {
            if (rightChild == null) rightChild = new MyBinaryTree();
            return rightChild.add(value);
        }
        return false;
    }

    // O(log n)
    public boolean contains(int value) {
        if (this.value == null) return false;
        if (value < this.value) {
            if (leftChild == null) return false;
            return leftChild.contains(value);
        }
        if (value > this.value) {
            if (rightChild == null) return false;
            return rightChild.contains(value);
        }
        return true;
    }

    // O(log n)
    public boolean remove(int value) {
        if (this.value == null) return false;
        if (value < this.value) {
            if (leftChild == null) return false;
            return leftChild.remove(value);
        }
        if (value > this.value) {
            if (rightChild == null) return false;
            return rightChild.remove(value);
        }
        if ((leftChild == null || leftChild.value == null) && (rightChild == null || rightChild.value == null)) {
            this.value = null;
            leftChild = null;
            rightChild = null;
            return true;
        }
        if (leftChild == null || leftChild.value == null) {
            this.value = rightChild.value;
            leftChild = rightChild.leftChild;
            rightChild = rightChild.rightChild;
            return true;
        }
        if (rightChild == null || rightChild.value == null) {
            this.value = leftChild.value;
            rightChild = leftChild.rightChild;
            leftChild = leftChild.leftChild;
            return true;
        }
        Integer nextSmallestValue = rightChild.getSmallestValue();
        remove(nextSmallestValue);
        this.value = nextSmallestValue;
        return true;
    }

    // O(n)
    public int[] toArray() {
        int[] array = new int[getSize()];
        addToArray(0, array);
        return array;
    }
}
