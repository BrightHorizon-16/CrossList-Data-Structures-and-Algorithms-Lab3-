import java.util.Scanner;

public class StackTest
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    StackReferenceBased stack = new StackReferenceBased();
    int choice = 0;

    while (choice != 6)
    {
      System.out.println("\nWelcome to StackTest! Please select a number from the list");
      System.out.println("1. Push a string on to the stack");
      System.out.println("2. Pop a string from the stack");
      System.out.println("3. Peek at the top of the stack");
      System.out.println("4. Empty the stack");
      System.out.println("5. Check if a string has balanced brackets.");
      System.out.println("6. Quit the program");
      System.out.print("Selection: ");

      try
      {
        choice = Integer.parseInt(input.nextLine().trim());
      }
      catch (NumberFormatException e)
      {
        choice = 0;
      }

      switch (choice)
      {
        case 1:
          System.out.print("Enter a string to push: ");
          String item = input.nextLine();
          stack.push(item);
          System.out.println("Pushed: " + item);
          break;

        case 2:
          try
          {
            System.out.println("Popped: " + stack.pop());
          }
          catch (StackException e)
          {
            System.out.println(e.getMessage());
          }
          break;

        case 3:
          try
          {
            System.out.println("Top of the stack: " + stack.peek());
          }
          catch (StackException e)
          {
            System.out.println(e.getMessage());
          }
          break;

        case 4:
          stack.popAll();
          System.out.println("The stack has been emptied.");
          break;

        case 5:
          System.out.print("Enter a string to check: ");
          String s = input.nextLine();
          if (isBalanced(s))
          {
            System.out.println("\"" + s + "\" has balanced brackets.");
          }
          else
          {
            System.out.println("\"" + s + "\" does NOT have balanced brackets.");
          }
          break;

        case 6:
          System.out.println("Goodbye!");
          break;

        default:
          System.out.println("Invalid selection. Please enter a number from 1 to 6.");
      }

      if (choice != 6)
      {
        System.out.println("\nCurrent stack:");
        stack.displayStack();
      }
    }

    input.close();
  }  // end main

  public static boolean isBalanced(String s)
  {
    StackReferenceBased braces = new StackReferenceBased();

    for (int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);

      if (c == '{')
      {
        braces.push(c);              
      }
      else if (c == '}')
      {
        if (braces.isEmpty())
        {
          return false;              
        }  // end if
        braces.pop();                
      }  // end if
    }  // end for

    return braces.isEmpty();         
  }  // end isBalanced
}  // end StackTest