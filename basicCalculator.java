import java.util.Stack;
import java.util.ArrayList;
class basicCalculator {
    static int calculate(String s) {
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
                if(s.charAt(i)!=' '){stack.push(s.charAt(i));}
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                while(stack.peek()!='('){
                    int j=1;
                    int M=0;
                    int len = stack.size();
                    while(stack.peek()!='+'&&stack.peek()!='-'&&stack.peek()!='('){
                        char m=stack.pop();
                        int m1=(int)m-48;
                        M=M+m1*j;
                        j=j*10;
                    }if(len!=stack.size()){list.add(M);}
                    if(stack.peek()=='+'){
                        stack.pop();
                        if(stack.isEmpty()){list.add(-1);}
                        else{
                            if(stack.peek()=='+'){stack.pop();stack.push('+');}
                            else if(stack.peek()=='-'){stack.pop();stack.push('-');}
                            else{list.add(-1);}}
                    }
                    if(stack.peek()=='-'){
                        stack.pop();
                        if(stack.isEmpty()){list.add(-2);}
                        else{
                            if(stack.peek()=='+'){stack.pop();stack.push('-');}
                            else if(stack.peek()=='-'){stack.pop();stack.push('+');}
                            else{list.add(-2);}}
                    }
                }
                if(stack.peek()=='('){stack.pop();}
                int n=list.get(list.size()-1);
                for(int k=list.size()-2;k>=0;k=k-2){
                    if(list.get(k)==-1){n=n+list.get(k-1);}
                    if(list.get(k)==-2){n=n-list.get(k-1);}
                }
                String N =String.valueOf(n);
            for(int l=0;l<N.length();l++){
                stack.push(N.charAt(l));
            }
        }}


        ArrayList<Integer> list1=new ArrayList<>();
        while(!stack.isEmpty()){
            int j=1;
            int M=0;
            int len=stack.size();
            while(!stack.isEmpty() && stack.peek()!='+' &&  stack.peek()!='-'){
                char m=stack.pop();
                int m1=(int)m-48;
                M=M+m1*j;
                j=j*10;
            }if(len!=stack.size()){list1.add(M);}
            if(!stack.isEmpty()){
                if(stack.peek()=='+'){
                    stack.pop();
                    if(stack.isEmpty()){list1.add(-1);}
                    else{
                        if(stack.peek()=='+'){stack.pop();stack.push('+');}
                        else if(stack.peek()=='-'){stack.pop();stack.push('-');}
                        else{list1.add(-1);}}
                }
                if(stack.peek()=='-'){
                    stack.pop();
                    if(stack.isEmpty()){list1.add(-2);}
                    else{
                        if(stack.peek()=='+'){stack.pop();stack.push('-');}
                        else if(stack.peek()=='-'){stack.pop();stack.push('+');}
                        else{list1.add(-2);}}
                }}
        }
        if(list1.size()==0){return 0;}
        if(list1.get(list1.size()-1)==-2){
            int F=list1.get(list1.size()-2);
            list1.remove(list1.size()-1);
            list1.set(list1.size()-1,F*(-1));
        }
        int n1=list1.get(list1.size()-1);
        for(int k=list1.size()-2;k>=0;k=k-2){
            if(list1.get(k)==-1){n1=n1+list1.get(k-1);}
            if(list1.get(k)==-2){n1=n1-list1.get(k-1);}
        }
        return n1;}
    public static void main(String[] args) {
        String s="(5-(1+(5)))";
        int m=calculate(s);
        System.out.print(m);
    }
}