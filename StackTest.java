public class StackTest
{
  public static void main(String[] args)
  {
    StackReferenceBased stack = new StackReferenceBased();

    System.out.println("Empty stack:");
    stack.displayStack();

    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");

    System.out.println("\nAfter pushing A, B, C, D:");
    stack.displayStack();

    System.out.println("\nPopped: " + stack.pop());
    System.out.println("After one pop:");
    stack.displayStack();

    System.out.println("\nPeek: " + stack.peek());

    stack.popAll();
    System.out.println("\nAfter popAll:");
    stack.displayStack();
  }  // end main
}  // end StackTest
