#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 100

int queue[MAX_SIZE];
int front = -1, rear = -1;

void initQueue() {
    front = rear = -1;
}

bool isEmpty() {
    return (front == -1);
}

bool isFull() {
    return (rear == MAX_SIZE - 1);
}

void enqueue(int value) {
    if (isFull()) {
        printf("Queue Overflow\n");
        return;
    }
    if (isEmpty()) {
        front = 0;
    }
    queue[++rear] = value;
}

int dequeue() {
    if (isEmpty()) {
        printf("Queue Underflow\n");
        return -1;
    }
    int value = queue[front];
    if (front == rear) {
        front = rear = -1;
    } else {
        front++;
    }
    return value;
}

int peek() {
    if (isEmpty()) {
        printf("Queue is empty\n");
        return -1;
    }
    return queue[front];
}

void display() {
    if (isEmpty()) {
        printf("Queue is empty\n");
        return;
    }
    printf("Queue elements: ");
    for (int i = front; i <= rear; i++) {
        printf("%d ", queue[i]);
    }
    printf("\n");
}

int main() {
    initQueue();

    enqueue(100);
    enqueue(200);
    enqueue(300);
    display();

    printf("Peek: %d\n", peek());

    printf("Dequeued element: %d\n", dequeue());
    display();

    return 0;
}