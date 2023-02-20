package com.codecool.linkedlist;

import java.util.Arrays;

public class SinglyLinkedList<T> {

    private int size;
    private T[] newList;


    private class Link {

        private final T value;
        private Link next;

        Link(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = new Link(null);
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(T value) {
        if (size==0) {
            this.head = new Link(value);
        } else {
            if (head.getNext()==null) {
                head.setNext(new Link(value));
            } else {
                Link nextLink = head.getNext();
                for (int i = 1; i < size-1; i++) {
                    nextLink = nextLink.getNext();
                }
                nextLink.setNext(new Link(value));
            }
        }
        this.size+=1;
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public T get(int index) {
        if (index<size && index>=0) {
            if (index==0) {
                return head.getValue();
            } else {
                Link nextLink = head.getNext();
                for (int i = 1; i < index; i++) {
                    nextLink = nextLink.getNext();
                }
                return nextLink.getValue();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(int number) {
        Link nextLink = head;
        for (int i = 0; i < size; i++) {
            if (nextLink.getValue().equals(number)) {
                return i;
            }
            nextLink = nextLink.getNext();
        }
        return -1;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, T number) {
        if (index<0) {
            throw new IndexOutOfBoundsException();
        }
        if (index==size) {
            add(number);
        } else {
            if (index==0) {
                Link temp = head;
                this.head = new Link(number);
                head.setNext(temp);
            } else {
                Link nextLink = head;
                for (int i = 1; i < index-1; i++) {
                    nextLink = nextLink.getNext();
                }
                Link temp = nextLink.getNext();
                nextLink.setNext(new Link(number));
                nextLink.getNext().setNext(temp);
            }
            this.size+=1;
        }
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        if(head == null) return 0;

        return this.size;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }

    public String toString() {
        StringBuilder linkedListAsString = new StringBuilder();
        linkedListAsString.append("[");
        Link nextLink = head;
        for (int i = 0; i < size; i++) {
            linkedListAsString.append(nextLink.getValue());
            if (i!=size-1) {
                linkedListAsString.append(",");
            }
            nextLink = nextLink.getNext();
        }
        linkedListAsString.append("]");
        return linkedListAsString.toString();
    }

}
