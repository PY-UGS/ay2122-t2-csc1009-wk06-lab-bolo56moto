
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListSorting{
    public static void main(String args[]){
        //generateRandomList();
        LinkedList<Integer> sortedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Scanner sc= new Scanner(System.in);
        char check = 'y';
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(5);
        sortedList.add(7);
        sortedList.add(9);
        sortedList.add(11);
        System.out.println(sortedList);
        do{
            
            System.out.print("\nwhat number do u want to add?: ");
            int ans = sc.nextInt();
            addAndSort(sortedList,ans);
            System.out.print("\ndo you still want to continue?: ");
            check = sc.next().charAt(0);
        }while(check == 'y'||check == 'Y');
        System.out.println("After adding the new numbers:\n" +sortedList);
        System.out.println("Enter 1st position to swap");
        int pos1 = sc.nextInt();
        System.out.println("Enter 2nd position to swap");
        int pos2 = sc.nextInt();
        swapValues(sortedList,pos1-1,pos2-1);
        System.out.println("After swapping the "+pos1+" and "+pos2+" values: \n" +sortedList);

        generateRandomList(linkedList);
        
        int val = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
        int position = findValue(linkedList,val);
        if(position ==-1){
            System.out.println("Number " + val+ " not found in list");
        }else{
            System.out.println("Position of number "+val +" is "+ position);
        }
        sc.close();
        

    }
    public static void addAndSort(LinkedList<Integer> list, int value){
        int size = list.size();
        
        
        for(int i = 0;i<size;i++){
            
            if(list.get(i) > value){
                list.add(i,value);
                return;
                
            }
            
        }
    }
        
        
        
        
    
    public static void swapValues(LinkedList<Integer> list, int index1,int index2){
        int temp = list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
         

    }

    
    public static void generateRandomList(LinkedList<Integer> linkedList){
        int lower = 1000;
        int upper = 9999;
        

        for(int i=0;i<500;i++){
            linkedList.add((int)Math.floor(Math.random()*(upper-lower+1)+lower));
            
        }

        
    }


    public static int findValue(LinkedList<Integer> list, int searchVal){
        if(list.contains(searchVal) != true){
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
