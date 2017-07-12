/**
 * Created by zyl on 2017/7/12.
 */
public class SelectGift
{

    static int Select3Gift(int[] gifts){
        int count = 0;
        if(gifts.length <=2) return 0;
        for(int i = 0; i < gifts.length; i++){
            for(int j = i + 1; j < gifts.length; j++){
                if(gifts[i] >= gifts[j]){
                    for(int k = j+1; k < gifts.length;k++){
                        if(gifts[j] >= gifts[k]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(new SelectGift().Select3Gift(new int[]{12, 11, 8, 9, 10}));
    }
}

