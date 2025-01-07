package stack.practice.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/*
Simple Text Editors

Implement a simple text editor. The editor initially contains an empty string S
Perform Q operations of following 4 steps:

1. append (W): Append string W to end of S
2. delete (k): Delete the last k characters of S
3. print (k): print kth character of S
4. undo (): Undo the last (not previously undone) operation of type 1 or 2.

reverting S to the state it was in prior to that operation.

S="abcde"
ops = ['1 fg', '3 6', '2 5', '4', '3 7', '4', '3 4']

output:
f
g
d

operation
index   S       ops[index]  explanation
-----   ------  ----------  -----------
0       abcde   1 fg        append fg
1       abcdefg 3 6         print the 6th letter - f
2       abcdefg 2 5         delete the last 5 letters
3       ab      4           undo the last operation, index 2
4       abcdefg 3 7         print the 7th characgter - g
5       abcdefg 4           undo the last operation, index 0
6       abcde   3 4         print the 4th character - d
* */
public class SimpleTextEditor {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int ops = Integer.parseInt(scanner.next());
            StringBuilder mainStr = new StringBuilder();
            Stack<Integer> lastOpStack = new Stack<>();
            Stack<String> undoStrStack = new Stack<>();
            for (int i = 0; i < ops; i++) {
                int opsType = Integer.parseInt(scanner.next());
                switch(opsType){
                    //append
                    case 1:
                        String appendStr = scanner.next();
                        mainStr.append(appendStr);
                        lastOpStack.push(opsType);
                        undoStrStack.push(appendStr);
                        break;
                    //delete
                    case 2:
                        int delLast = Integer.parseInt(scanner.next());
                        undoStrStack.push(mainStr.substring(mainStr.length() - delLast, mainStr.length()));
                        lastOpStack.push(opsType);

                        mainStr.delete(mainStr.length() - delLast,  mainStr.length());
                        break;
                    //print
                    case 3:
                        int thChar = Integer.parseInt(scanner.next());
                        //since index do -1
                        System.out.println(mainStr.charAt(thChar - 1));
                        break;
                    //undo
                    case 4:
                        // last Op was append so remove that string
                        int undoOp = lastOpStack.pop();
                        String undoStr = undoStrStack.pop();
                        if(undoOp == 1)
                        {
                            mainStr.delete(mainStr.length() - undoStr.length(), mainStr.length());

                        }
                        // last Op was delete so append that string
                        if(undoOp == 2){
                            mainStr.append(undoStr);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
