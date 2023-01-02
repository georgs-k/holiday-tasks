class ListElement {

    private int value;
    private ListElement previousElement;
    private ListElement nextElement;

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    ListElement getPreviousElement() {
        return previousElement;
    }

    void setPreviousElement(ListElement previousElement) {
        this.previousElement = previousElement;
    }

    ListElement getNextElement() {
        return nextElement;
    }

    void setNextElement(ListElement nextElement) {
        this.nextElement = nextElement;
    }
}

public class MyLinkedList {

    private long size;
    private ListElement firstElement;
    private ListElement lastElement;

    public long getSize() {
        return size;
    }

    // O(1)
    public void add(int value) {
        ListElement newElement = new ListElement();
        newElement.setValue(value);
        if (size++ == 0) firstElement = newElement;
        else {
            lastElement.setNextElement(newElement);
            newElement.setPreviousElement(lastElement);
        }
        lastElement = newElement;
    }

    // O(n)
    public void add(long index, int value) throws IndexOutOfBoundsException {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        if (index == size) {
            add(value);
            return;
        }
        ListElement newElement = new ListElement();
        newElement.setValue(value);
        if (index == 0) {
            firstElement.setPreviousElement(newElement);
            newElement.setNextElement(firstElement);
            firstElement = newElement;
            size++;
            return;
        }
        ListElement traverseElement;
        if (index < size++ / 2) {
            traverseElement = firstElement;
            for (long i = 1; i < index; i++) traverseElement = traverseElement.getNextElement();
        }
        else {
            traverseElement = lastElement;
            for (long i = size - 1; i > index; i--) traverseElement = traverseElement.getPreviousElement();
        }
        newElement.setPreviousElement(traverseElement);
        newElement.setNextElement(traverseElement.getNextElement());
        traverseElement.getNextElement().setPreviousElement(newElement);
        traverseElement.setNextElement(newElement);
    }

    // O(n)
    public void delete(long index) throws IndexOutOfBoundsException {
        if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
        if (size == 1) {
            size--;
            return;
        }
        if (index == 0) {
            firstElement = firstElement.getNextElement();
            firstElement.setPreviousElement(null);
            size--;
            return;
        }
        if (index == size - 1) {
            lastElement = lastElement.getPreviousElement();
            lastElement.setNextElement(null);
            size--;
            return;
        }
        ListElement traverseElement;
        if (index < size-- / 2) {
            traverseElement = firstElement;
            for (long i = 0; i < index; i++) traverseElement = traverseElement.getNextElement();
        }
        else {
            traverseElement = lastElement;
            for (long i = size; i > index; i--) traverseElement = traverseElement.getPreviousElement();
        }
        traverseElement.getNextElement().setPreviousElement(traverseElement.getPreviousElement());
        traverseElement.getPreviousElement().setNextElement(traverseElement.getNextElement());
    }

    // O(n)
    public int get(long index) throws IndexOutOfBoundsException {
        if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) return firstElement.getValue();
        if (index == size - 1) return lastElement.getValue();
        ListElement traverseElement;
        if (index < size / 2) {
            traverseElement = firstElement;
            for (long i = 0; i < index; i++) traverseElement = traverseElement.getNextElement();
        }
        else {
            traverseElement = lastElement;
            for (long i = size - 1; i > index; i--) traverseElement = traverseElement.getPreviousElement();
        }
        return traverseElement.getValue();
    }
}
