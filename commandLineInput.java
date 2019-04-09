import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class commandLineInput{
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read1 = br.readLine();
        String[] split_num = read1.split(" ");
        ArrayList<Integer> Num =new ArrayList<>();
        for(String num:split_num){
            Num.add(Integer.parseInt((num)));
        }
        for(int num:Num){
            System.out.print(num+" ");
        }
        Scanner input = new Scanner(System.in);
        int num1 =input.nextInt();
        System.out.println(num1);


    }
}