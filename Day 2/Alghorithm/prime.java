import java.util.Scanner; 

public class prime{  
    public static void main(String args[]){  
        int i,m;
        boolean flag=false;
        Scanner input = new Scanner(System.in);
        System.out.print("input number : ");
        int n= input.nextInt();
        m=n/2;    
        if(n==0||n==1){
            System.out.println("Bukan Bilangan Prima");    
        }else{
            for(i=2;i<=m;i++){    
                if(n%i==0){    
                    System.out.println("Bukan Bilangan Prima");    
                    flag=true;    
                    break;    
                }    
            }    
            if(flag==false)  {
                System.out.println("Bilangan Prima");
            }
        }
    }  
} 