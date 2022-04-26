import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class Question5
{
  public static void main(String[] args)
  {
    /**
     * Prompt the user for number. This input indicates the number of integers the user will be entering next. 
     * Print out the mode (highest occurrence) from the set of integers. 
     *    e.g.
     *     > 5
     *     > 2
     *     > 4
     *     > 1
     *     > 3
     *     > 4
     *     4
     * 
     *    e.g.
     *     > 4
     *     > 2
     *     > 2
     *     > 3
     *     > 3
     *     2
     * Hint: Use a loop to get input. Use another 2 loops to find the mode
     */
     
    Scanner in = new Scanner(System.in);

    ArrayList<Integer> num_list = new ArrayList<>();
    ArrayList<Integer> checking_list = new ArrayList<>();
    ArrayList<Integer> mode_list = new ArrayList<>();

    System.out.print("Enter a number: ");
    int num_of_turns = in.nextInt();
    System.out.println("This number represents the number of times you will be entering a number.");
    
    // prompt user for integer a certain number of times based on integer provided above
    System.out.println("Enter an integer: ");
    for (int i = 0; i < num_of_turns; i++)
    {
      System.out.print("> ");
      int user_int = in.nextInt();
      num_list.add(user_int);
    }

    // sort list in ascending order
    Collections.sort(num_list);

    int prev_num = 0;

    for (int i=0; i<num_list.size(); i++)
    {
      if (i == 0)
      {
        checking_list.add(num_list.get(i));
      }
      if (num_list.get(i) == prev_num)
      {
        checking_list.add(num_list.get(i));
      }
      else
      {
        if (mode_list.size() == 0)
        {
          mode_list.add(prev_num);
          mode_list.add(checking_list.size());
          
        }
        if (checking_list.size() > mode_list.get(1))
        {
          mode_list.clear();
          mode_list.add(checking_list.get(0));
          mode_list.add(checking_list.size());
        }
        checking_list.clear();
        checking_list.add(num_list.get(i));
      }
      prev_num = num_list.get(i);
    }

    System.out.println(mode_list.get(0));

    in.close();

  }
}
