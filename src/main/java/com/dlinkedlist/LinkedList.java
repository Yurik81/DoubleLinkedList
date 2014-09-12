package com.dlinkedlist;

import sun.awt.image.ImageWatched;

/**
 * Created by ykuzub on 9/11/2014.
 */
public class LinkedList {
    private Node firstNode;
    private Node lastNode;
    private int count;
    private int currentIndex;

    public LinkedList() {
        firstNode = null;
        lastNode = null;
        count = 0;
    }

    public void addToHead(int value) {
        Node newNode = new Node(++currentIndex, value);
        if (count==0) {
            lastNode = newNode;
        }
        else {
            firstNode.setPrevNode(newNode);
        }
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        count++;
    }

    public void addToTail(int value) {
        Node newNode = new Node(++currentIndex,value);
        if (count==0) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
            newNode.setPrevNode(lastNode);
        }
        lastNode = newNode;
        count++;
    }

    public boolean addAtIndex(int index, int value) {
        if (count==0) {
            return false;
        }

        Node currentNode = firstNode;
        while (currentNode.getIndex()!=index) {
            currentNode = currentNode.getNextNode();
            if (currentNode == null) {
                return false;
            }
        }
        Node newNode = new Node(++currentIndex, value);

        if (currentNode==lastNode) {
            newNode.setNextNode(null);
            lastNode = newNode;
        } else {
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.getNextNode().setPrevNode(newNode);
        }
        newNode.setPrevNode(currentNode);
        currentNode.setNextNode(newNode);
        count++;
        return true;
    }

    public void removeFirstNode () {
        Node tmp = firstNode;

        if (tmp==null) {
            return;
        }

        if (firstNode.getNextNode()==null) {
            lastNode = null;
        } else {
            firstNode.getNextNode().setPrevNode(null);
        }
        firstNode = firstNode.getNextNode();
        count--;
    }

    public void removeLastNode () {
        Node tmp = lastNode;

        if (tmp==null) {
            return;
        }

        if (firstNode.getNextNode() == null) {
            firstNode = null;
        } else {
            lastNode.getPrevNode().setNextNode(null);
        }
        lastNode = lastNode.getPrevNode();
        count--;
    }

    public void removeAtIndex(int index) {
        Node currentNode = firstNode;

        while (currentNode.getIndex()!=index) {
            currentNode = currentNode.getNextNode();
            if (currentNode == null) {
                return ;
            }
        }

        if (currentNode==firstNode) {
            firstNode = currentNode.getNextNode();
        } else {
            currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
        }

        if (currentNode==lastNode) {
            lastNode = currentNode.getPrevNode();
        } else {
            currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
        }
        count--;
    }

    public Node GetAtIndex(int index) {
        if (count==0) {
            return null;
        }

        Node currentNode = firstNode;
        while (currentNode.getIndex()!=index) {
            if (currentNode == null) {
                return null;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    public int getCount() {
        return count;
    }

}
