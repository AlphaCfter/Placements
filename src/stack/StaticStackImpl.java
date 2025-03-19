package stack;


public class StaticStackImpl {

    static int[] stack = new int[20];
    static int TOS = 0;

    private static void pop(){
        if(TOS == 0){
            System.out.println("Stack is empty");
        }else{

            TOS--;
            int value = stack[TOS];
            System.out.println("Poped value is "+value);

        }
    }

    private static void push(int value) {
        if (TOS < stack.length) {
            stack[TOS] = value;
            TOS++;
        } else {
            System.out.println("Stack is full");
        }
    }

    private static void display() {
        if (TOS == 0) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i < TOS; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    boolean isEmpty(){
        return TOS==-1;
    }



    public static void main(String[] args) {
        System.out.println("Created a dynamic stack of length 20");

        System.out.println("Inserting values in the stack");
        push(1);
        push(2);
        push(3);
        pop();

        display();
    }
}
