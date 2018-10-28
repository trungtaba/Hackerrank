package hackerrankcompete;

import java.util.ArrayList;

public class WordMachine {
    public ArrayList<Integer> stack=new ArrayList<>();
    
    public int solution(String s){
        String[] commands=s.split(" ");
        for(int i=0;i<commands.length;i++){
            try{
                stack=perform(commands[i]);
            }catch(Exception e){
                //System.out.println(e.toString());
                return -1;
            }
        }
        return stack.get(stack.size()-1);
    }
    
    ArrayList<Integer> perform(String command) throws Exception{
        ArrayList<Integer> tmpStack=stack;
        //System.out.println("tmpStack.size="+tmpStack.size());
        switch(command){
            case "DUP":
                int lastElement=tmpStack.get(tmpStack.size()-1);
                //System.out.println("DUP");
                tmpStack.add(tmpStack.size(),lastElement);
                //printStack(tmpStack);
                break;
            case "POP":
                if(tmpStack.isEmpty()){
                    throw new Exception("stack empty");
                }else{
                    //System.out.println("POP");
                    tmpStack.remove(tmpStack.size()-1);
                    //printStack(tmpStack);
                    break;
                }
            case "+":
                if(tmpStack.size()<2){
                    throw new Exception("stack not enough element");
                }else{
                    int first=tmpStack.remove(tmpStack.size()-1);
                    int second=tmpStack.remove(tmpStack.size()-1);
                    //System.out.println("+\t first="+first+" second="+second);
                    int value=first+second;
                    tmpStack.add(tmpStack.size(), value);
                    //printStack(tmpStack);
                    break;
                }
            case "-":
                if(tmpStack.size()<2){
                    throw new Exception("stack not enough element");
                }else{
                    int first=tmpStack.remove(tmpStack.size()-1);
                    int second=tmpStack.remove(tmpStack.size()-1);
                    //System.out.println("-\t first="+first+" second="+second);
                    int value=first-second;
                    if(value<0){
                        throw new Exception("Negative result");
                    }else{
                        tmpStack.add(tmpStack.size(), value);
                        //printStack(tmpStack);
                        break;
                    }
                }
            default:
                int value=Integer.parseInt(command);
                //System.out.println("push "+value+" to stack ");
                if(tmpStack.isEmpty()){
                    tmpStack.add(value);
                }else{
                    tmpStack.add(tmpStack.size(), value);
                }
                //printStack(tmpStack);
                break;
                
        }
        //System.out.println("tmpStack.size="+tmpStack.size());
        return tmpStack;
    }
    
    void printStack(ArrayList<Integer> A){
        for(int i=0;i<A.size();i++){
            System.out.print(A.get(i)+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        WordMachine wm=new WordMachine();
        //String string="13 DUP 4 POP 5 DUP + DUP + -";
        String string="3 DUP 5 - -";
        System.out.println(wm.solution(string));
    }
}
