import java.util.*;
public class HashMapSorting {
    public static void main(String[] args){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> randomHashMap = new HashMap<Integer, Integer>();
        hashMap.put(0,1);
        hashMap.put(1,3);
        hashMap.put(2,5);
        hashMap.put(3,7);
        hashMap.put(4,9);
        hashMap.put(5,11);
        Scanner sc= new Scanner(System.in);
        char check = 'y';
        System.out.println(hashMap);
        do{
            
            System.out.print("\nwhat number do u want to add?: ");
            int ans = sc.nextInt();
            addAndSort(hashMap,ans);
            System.out.print("\ndo you still want to continue?: ");
            check = sc.next().charAt(0);
        }while(check == 'y'||check == 'Y');
        System.out.println("After adding the new numbers:\n" +hashMap);
        System.out.println("Enter 1st position to swap");
        int pos1 = sc.nextInt();
        System.out.println("Enter 2nd position to swap");
        int pos2 = sc.nextInt();
        swapValues(hashMap,pos1-1,pos2-1);
        System.out.println("After swapping the "+pos1+" and "+pos2+" values: \n" +hashMap);

        generateRandomList(randomHashMap);
        
        int val = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
        int position = findValue(randomHashMap,val);
        if(position ==-1){
            System.out.println("Number " + val+ " not found in list");
       }else{
            System.out.println("Position of number "+val +" is "+ position);
        }
        sc.close();
        

    }

    public static void addAndSort(HashMap<Integer, Integer> list, int value){
        int size = list.size();
        int ii;
        int temp = 0;
        int i;
        int temp2 =0;
        for(i = 0;i<size;i++){
            
            if(list.get(i) > value){
                temp = list.get(i);
                list.remove(i);
                list.put(i,value);
                
                break;
                
                
            }
            
               
        }
        int last = list.get(size-1);
        
        for(ii =i+1; ii<size;){
            
            if(ii !=i+1){
                list.put(ii,temp2);
                temp2 = list.get(ii);
                

                
            }else{
                temp2 = list.get(ii);
                list.put(ii,temp);
                
                
            }
            ii++;
        }
        list.put(size,last); 
    }
    public static void swapValues(HashMap<Integer, Integer> list, int index1,int index2){
        int temp = list.get(index1);
        list.put(index1,list.get(index2));
        list.put(index2,temp);
         

    }

    
    public static void generateRandomList(HashMap<Integer, Integer> list){
        int lower = 1000;
        int upper = 9999;
        

        for(int i=0;i<500;i++){
            list.put(i,(int)Math.floor(Math.random()*(upper-lower+1)+lower));
            
        }

        
    }


    public static int findValue(HashMap<Integer, Integer> list, int searchVal){
        if(list.containsValue(searchVal) != true){
            return -1;
        }
        else{
            for(int i=0;i<list.size();i++){
                if(searchVal == list.get(i)){
                    return i+1;
                }
                
            }
        }
        return -1;
        
    }
    
}
