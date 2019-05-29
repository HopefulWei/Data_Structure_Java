import java.util.ArrayList;
class threeEqualParts {
    public int[] threeEqualParts(int[] A) {
        int[] Ret={-1,-1};
        if(A==null)return Ret;
        int[] Ret1={0,A.length-1};
        ArrayList<Integer> index=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]==1)index.add(i);}
        if(index.size()==0)return Ret1;
        else if(index.size()%3!=0)return Ret;
        int gap4=A.length-index.get(index.size()-1)-1;
        if(index.get(2*index.size()/3)-index.get(2*index.size()/3-1)-1<gap4||index.get(index.size()/3)-index.get(index.size()/3-1)-1<gap4){
            return Ret;}
        int[] Ret2={index.get(index.size()/3-1)+gap4,index.get(2*(index.size()/3)-1)+1+gap4};
        if(index.size()==3){
            return Ret2; }
        for(int i=0;i<index.size()/3-1;i++){
            int gap1=index.get(i+1)-index.get(i);
            int gap2=index.get(index.size()/3+i+1)-index.get(index.size()/3+i);
            int gap3=index.get(2*index.size()/3+i+1)-index.get(2*index.size()/3+i);
            if(gap1!=gap2||gap2!=gap3)return Ret;}
        return Ret2;
    }
}