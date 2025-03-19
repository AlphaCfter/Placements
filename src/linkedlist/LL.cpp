#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }
};

class SLL
{
public:
    Node *head;

    SLL()
    {
        this->head = NULL;
    }

    void insertAtHead(int val)
    {
        Node *n = new Node(val);
        n->next = head;
        head = n;
    }

    void display()
    {
        Node *temp = head;
        while (temp != NULL)
        {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    void insertAtEnd(int val)
    {
        Node *n = new Node(val);
        if (head == NULL)
        {
            head = n;
            return;
        }
        Node *temp = head;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = n;
    }

    void insertAtPos(int val, int pos)
    {
        Node *n = new Node(val);
    }
};

int main()
{
    SLL list;

    list.insertAtHead(10);
    list.insertAtHead(20);
    list.insertAtHead(30);

    list.display();

    list.insertAtEnd(50);
    list.display();

    return 0;
}
