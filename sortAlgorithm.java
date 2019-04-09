class Scratch {
    /*
    直接插入排序
     */
    public static int[] directInsertSort(int[] List){
        for(int i=1;i<List.length;i++){
            for(int j=i-1;j>=0;j--){
               if(List[j]>List[j+1]){
                   int temp = List[j];
                   List[j] = List[j+1];
                   List[j+1] = temp;
               }}}
        return List;
    }
    /*
    希尔排序
     */
    public static int[] insertShell(int[] List){
        int gap = (int)(List.length/2);
        while(gap>=1){
            for(int x=gap;x<List.length;x++){
                for(int j=x-gap;j>=0;j=j-gap){
                    if(List[j]>List[j+gap]){
                        int temp = List[j];
                        List[j] = List[j+gap];
                        List[j+gap] = temp;
                } }}
            gap = gap/2;
        }return List;
    }
    /*
    简单选择排序
     */

    public static int[] simpleSorting(int[] List){
        for(int i=0;i<List.length;i++){
            int min = List[i];
            for(int j=List.length-1;j>=i;j--){
                if(List[j]<min){
                    int temp=min;
                    min=List[j];
                    List[j]=temp;}
            }List[i]=min;
        }return List;
    }
    /*
    冒泡排序
     */
    public static int[] bubbleSort(int[] List){
        for(int i=1;i<List.length;i++){
            for(int j=0;j<List.length-i;j++){
                if(List[j+1]<List[j]){
                    int temp = List[j+1];
                    List[j+1] = List[j];
                    List[j] = temp;
                }
            }
        }return List;
    }
    /*
/////////////////////////////////归并排序//////////////////////////////////////////////
     */
    public static void merge(int[] List, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(List[i]<List[j]){
                temp[k++]=List[i++];
            }else{temp[k++]=List[j++];}
            while(i<=mid){temp[k++]=List[i++];}
            while(j<=high){temp[k++]=List[j++];}
            for(int x=0;x<temp.length;x++){
                List[x+low] = temp[x];
            } } }
    public static int[] mergeSort(int[] List,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            mergeSort(List,low,mid);
            mergeSort(List,mid+1,high);
            //左右归并
            merge(List,low,mid,high);
        }
        return List;
    }
/*
//////////////////////     基数排序  ///////////////////////
 */
    public static int getNumInPos(int num, int pos) {
        int tmp = 1;
        for (int i = 0; i < pos - 1; i++) {
            tmp *= 10;
        }
        return (num / tmp) % 10;
    }

    public static int getMaxWeishu(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        int tmp = 1, d = 1;
        while (true) {
            tmp *= 10;
            if (max / tmp != 0) {
                d++;
            } else
                break;
        }
        return d;
    }

    public static int[] radixSort(int[] a, int d) {

        int[][] array = new int[10][a.length + 1];
        for (int i = 0; i < 10; i++) {
            array[i][0] = 0;// array[i][0]记录第i行数据的个数
        }
        for (int pos = 1; pos <= d; pos++) {
            for (int i = 0; i < a.length; i++) {// 分配过程
                int row = getNumInPos(a[i], pos);
                int col = ++array[row][0];
                array[row][col] = a[i];
            }
            for (int row = 0, i = 0; row < 10; row++) {// 收集过程
                for (int col = 1; col <= array[row][0]; col++) {
                    a[i++] = array[row][col];
                }
                array[row][0] = 0;// 复位，下一个pos时还需使用
            }
        }return a;
    }

///////////////////基数排序////////////////////


    public static void main(String[] args) {
        int[] A ={5,8,9,16,162,23,4,1};
///////////////////归并排序///////////////////////////////
        int[] C = mergeSort(A,0,A.length-1);
//////////////////////归并排序///////////////////////////
////////////////////////基数排序/////////////////////////
        int[] D = radixSort(A,getMaxWeishu(A));
////////////////////////基数排序/////////////////////////
        int[] b = bubbleSort(A);

        for(int num:D){
        System.out.print(num+" ");}
        
    }
}