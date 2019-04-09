import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gridWalking{
    //网格走法
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read1 = br.readLine();
        String[] split_num = read1.split(" ");
        int a = Integer.parseInt((split_num[0]));
        int b = Integer.parseInt((split_num[1]));

        System.out.println(method(a,b));//测试


    }
    static long a[][]=new long[1024][1024];//row,line
    public static long method(int row,int line) {
        if(row==0||line==0){
            a[row][line]=1;
            return a[row][line];
        }else {
            if(a[row][line]==0) {
                a[row][line]=method(row-1,line)+method(row,line-1);
                return a[row][line];
            }else {
                return a[row][line];
            }
        }
    }
}

