#include<stdio.h>
#include<stdlib.h>

// Structure of a BST node
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new BST node
struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function to perform search operation in BST
struct Node* search(struct Node* root, int key) {
    if (root == NULL || root->data == key)
        return root;
    
    // Key is greater than root's data
    if (root->data < key)
        return search(root->right, key);
    
    // Key is smaller than root's data
    return search(root->left, key);
}

// Main function
int main() {
    struct Node* root = createNode(5);
    root->left = createNode(3);
    root->right = createNode(7);
    root->left->left = createNode(2);
    root->left->right = createNode(4);
    
    int key = 4;
    struct Node* result = search(root, key);
    if (result != NULL)
        printf("Element %d is found in the BST.\n", key);
    else
        printf("Element %d is not found in the BST.\n", key);
    
    return 0;
}