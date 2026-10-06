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

    // isBalanced tests
    System.out.println("\nisBalanced tests:");
    System.out.println("{}      -> " + isBalanced("{}"));
    System.out.println("{{}}    -> " + isBalanced("{{}}"));
    System.out.println("{a{b}c} -> " + isBalanced("{a{b}c}"));
    System.out.println("{       -> " + isBalanced("{"));
    System.out.println("}{      -> " + isBalanced("}{"));
    System.out.println("{{}     -> " + isBalanced("{{}"));
    System.out.println("{}}     -> " + isBalanced("{}}"));

  }  // end main

  public static boolean isBalanced(String s)
  {
    StackReferenceBased braces = new StackReferenceBased();

    for (int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);

      if (c == '{')
      {
        braces.push(c);              // opening brace: push it
      }
      else if (c == '}')
      {
        if (braces.isEmpty())
        {
          return false;              // closing brace with nothing to match
        }  // end if
        braces.pop();                // matched a pair
      }  // end if
    }  // end for

    return braces.isEmpty();         // leftover '{' means unbalanced
  }  // end isBalanced
}  // end StackTest
