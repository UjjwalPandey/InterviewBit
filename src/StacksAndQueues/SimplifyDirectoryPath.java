/*  Simplify Directory Path

    Given a string A representing an absolute path for a file (Unix-style).
    Return the string A after simplifying the absolute path. Note:
    Absolute path always begin with '/' ( root directory ).
    Path will not have whitespace characters.

    Input Format
    The only argument given is string A.
    Output Format
    Return a string denoting the simplified absolue path for a file (Unix-style).
    For Example
    Input 1:
        A = "/home/"
    Output 1:
        "/home"

    Input 2:
        A = "/a/./b/../../c/"
    Output 2:
        "/c"

 */
package StacksAndQueues;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String A) {
        StringBuilder res = new StringBuilder();
        String[] list = A.split("/");

        Stack<String> dir = new Stack<>();
        for(String s: list){
            if(s.isEmpty()) continue;
            if(s.contains(" ")){
                dir.push(s.split(" ")[0]);
                return createPath(dir);
            }
            if(s.equals("..")){
                if(!dir.empty())
                    dir.pop();
            }else if(s.equals(".")){
                continue;
            }else{
                dir.push(s);
            }
        }
        return createPath(dir);
    }

    private static String createPath(Stack<String> dir) {
        if(dir.empty()){
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while(!dir.empty()){
            String s = dir.pop();
            res.insert(0, "/" + s);
        }
        return res.toString();
    }
}
