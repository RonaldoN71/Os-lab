import java.util.*;
class process{
    int id;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;
    int priority;
    process(int id,int arrivalTime,int burstTime,int priority){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

class Prioritynp{
   public static Comparator<process> ComparePrio = new Comparator<process>() {
     public int compare(process a,process b){
        if(a.priority==b.priority){
            return a.id-b.id;
        }
        else{
            return a.priority - b.priority;
        }
     }
    };
    public static void GanttDisplay(List<process> proc){
     System.out.println("Gantt chart:");
     System.out.println("---------------------");
     for(process p: proc){
        System.out.print("|");
        System.out.print(" P"+p.id+" ");
     }
     System.out.print("|");
     System.out.print("\n---------------------");
     System.out.println();
     System.out.print("0");
     for(process p: proc){
        System.out.print("    "+p.completionTime);
     }
     System.out.println();
    }

    public static void TableDisplay(List<process> proc){
        System.out.println("The Table of process Scheduling:");
        System.out.print("Process\t ArrivalTime\t BurstTime\t Priority\tCompletionTime\t WaitingTime\t ");
        System.out.println();
        for(process p:proc){
            System.out.println("P"+p.id+"\t  "+p.arrivalTime+"\t\t "+ p.burstTime+"\t\t  "+p.priority+"\t\t   "+p.completionTime+"\t\t   "+p.waitingTime);
        }
    }
    public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the no. of process:");
    int n = sc.nextInt();

    process[] proc = new process[n];
    for(int i=0;i<n;i++){
        System.out.print("\nEnter the Arrival time,burst time and priority of process "+(i+1)+":");
        int arrivalTime = sc.nextInt();
        int burstTime = sc.nextInt();
        int priority = sc.nextInt();
        proc[i] = new process(i+1,arrivalTime,burstTime,priority);
    }
    List<process> processlist = new ArrayList<>();
    Collections.addAll(processlist,proc);
    Collections.sort(processlist,ComparePrio);
    
    int currentTime = 0;
    for(process p: processlist){
        p.waitingTime = currentTime;
        currentTime += p.burstTime;
        p.completionTime = currentTime;
        p.turnAroundTime = p.completionTime;
        
    }
    GanttDisplay(processlist);
    TableDisplay(processlist);
    sc.close();
    }
}