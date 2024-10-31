import java.util.Scanner;

class process{
    int waitingTime;
    int burstTime;
    int turnaroundTime;
    int id;
    process(int id,int burstTime){
        this.id=id;
        this.burstTime=burstTime;
    }
} public class FCFS { 
 static void FindWaiting(process[] proc){
    proc[0].waitingTime=0;
    for(int i=1;i<proc.length;i++){
        proc[i].waitingTime = proc[i-1].waitingTime + proc[i-1].burstTime;
    }
 }

 static void FindTurnAround(process[] proc){
    for(int i=0;i<proc.length;i++){
        proc[i].turnaroundTime = proc[i].waitingTime + proc[i].burstTime;
    }
 }
 
 static void PrintTable(process[] proc){
    System.out.println("Process Table:");
    System.out.print("Process"+"\tBurstTime"+ "\tWaitingTime"+"\tTurnAroundTime");
    System.out.println();
    for(process p : proc){
     System.out.println("P"+p.id+"\t"+p.burstTime+"\t\t"+p.waitingTime+"\t\t"+p.turnaroundTime);
    }
 }
 static void PrintGanttChart(process[] proc){
    System.out.println("Gannt Chart:");
    for(process p: proc){
        System.out.print(" ");
        for(int i=0;i<p.burstTime;i++){
            System.out.print("--");
        }
    }
    System.out.println();
    for(process p: proc){
        System.out.print("|");
        for(int i=0;i<p.burstTime-1;i++){
            System.out.print(" ");
        }
        System.out.print("P"+p.id);
        for(int i=0;i<p.burstTime-1;i++){
            System.out.print(" ");
        }
    }
    System.out.print("|");
    System.out.println();
    System.out.print("0");
    for(process p: proc){
        for(int i=0;i<p.burstTime;i++){
            System.out.print("  ");
        }
        System.out.print(p.waitingTime+p.turnaroundTime);
    
    }
 }
public static void main(String[]args){
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the no. of process: ");
    int n = sc.nextInt();
    process[] proc = new process[n];

    for(int i=0;i<n;i++){
    System.out.print("Enter the burst time for process P"+(i+1)+":");
    int burstTime =  sc.nextInt();
    proc[i] = new process(i+1 , burstTime);
    }
    FindTurnAround(proc);
    FindWaiting(proc);
    PrintTable(proc);
    PrintGanttChart(proc);
    sc.close();
}
}
