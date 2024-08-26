#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 100

int stack[MAX_SIZE];
int top = -1;

void initStack() {
    top = -1;
}

bool isEmpty() {
    return (top == -1);
}

bool isFull() {
    return (top == MAX_SIZE - 1);
}

void push(int value) {
    if (isFull()) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = value;
}

int pop() {
    if (isEmpty()) {
        printf("Stack Underflow\n");
        return -1;
    }
    return stack[top--];
}

int peek() {
    if (isEmpty()) {
        printf("Stack is empty\n");
        return -1;
    }
    return stack[top];
}

void display() {
    if (isEmpty()) {
        printf("Stack is empty\n");
        return;
    }
    printf("Stack elements: ");
    for (int i = top; i >= 0; i--) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main() {
    initStack();

    push(10);
    push(20);
    push(30);
    display();

    printf("Peek: %d\n", peek());

    printf("Popped element: %d\n", pop());
    display();

    return 0;
}