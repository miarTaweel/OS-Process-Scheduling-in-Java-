
/*

 Miar Taweel 
 
 */
import java.util.*;


class Process {
	String name;
	int arrivalTime;
	int burstTime;
	int waitingTime;
	int Arrived = 0;
	int comeBack;
	int completion;
	int remain;
	int timesCalled;
	int prevExcecution;
	int priority;
	int priorityOrg;
	int arrivalTimeOrg;
	int readyQ;
	int comebackTimes;

	public Process(String name, int arrivalTime, int arrivalTimeOrg, int burstTime, int waitingTime, int Arrived,
			int comeBack, int completion, int remain, int timesCalled, int prevExcecution, int priority,
			int priorityOrg) {
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.arrivalTimeOrg = arrivalTimeOrg;
		this.burstTime = burstTime;
		this.waitingTime = waitingTime;
		this.Arrived = Arrived;
		this.comeBack = comeBack;
		this.completion = completion;
		this.remain = remain;
		this.timesCalled = timesCalled;
		this.prevExcecution = prevExcecution;
		this.priority = priority;
		this.priorityOrg = priorityOrg;
		this.readyQ = readyQ;
		this.comebackTimes = comebackTimes;

	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public int getRemain() {
		return remain;
	}

	public int getPriority() {
		return priority;
	}

	public int getReadyQ() {
		return readyQ;
	}

}

public class Miar {

	public static final int END_TIME = 200;

	public static int hasarrived2(int comp, int arrive) {

		if (comp >= arrive) {
			return 1;
		} else
			return 0;

	}

	

	public static void assignBurstTime1(ArrayList<Process> processQueue, ArrayList<Process> processList) {
		for (Process listProcess : processList) {

			for (Process queueProcess : processQueue) {
				if (queueProcess.name.equals(listProcess.name)) {
					listProcess.timesCalled = queueProcess.timesCalled;
					// System.out.println( listProcess.timesCalled +""+queueProcess.timesCalled);

					// break; // Breaks inner loop after assignment
				}
			}
		}

		for (Process listProcess : processList) {

			for (Process queueProcess : processQueue) {
				if (queueProcess.name.equals(listProcess.name)
						&& queueProcess.comebackTimes > listProcess.comebackTimes) {
					listProcess.comebackTimes = queueProcess.comebackTimes;
					// System.out.println( listProcess.timesCalled +""+queueProcess.timesCalled);

					// break; // Breaks inner loop after assignment
				}
			}
		}

		for (Process listProcess : processList) {

			for (Process queueProcess : processQueue) {
				if (queueProcess.name.equals(listProcess.name)) {
					listProcess.prevExcecution = queueProcess.prevExcecution;
					// System.out.println( listProcess.timesCalled +""+queueProcess.timesCalled);

					// break; // Breaks inner loop after assignment
				}
			}
		}

		for (Process listProcess : processList) {

			for (Process queueProcess : processQueue) {
				if (queueProcess.name.equals(listProcess.name)) {
					listProcess.completion = queueProcess.completion;
					// System.out.println( listProcess.timesCalled +""+queueProcess.timesCalled);

					// break; // Breaks inner loop after assignment
				}
			}
		}

		for (Process listProcess : processList) {

			for (Process queueProcess : processQueue) {
				if (queueProcess.name.equals(listProcess.name)) {
					listProcess.waitingTime = queueProcess.waitingTime;
					// System.out.println( listProcess.timesCalled +""+queueProcess.timesCalled);

					// break; // Breaks inner loop after assignment
				}
			}

		}

	}

	 //initialises the input arrayList with the seven processes and their attributes
	public static void initializeProcessList(ArrayList<Process> pList) {

		
		pList.add(new Process("P1", 0, 0, 10, 0, 0, 2, 0, 10, 0, 0, 3, 3));
		pList.add(new Process("P2", 1, 1, 8, 0, 0, 4, 0, 8, 0, 0, 2, 2));
		pList.add(new Process("P3", 3, 3, 14, 0, 0, 6, 0, 14, 0, 0, 3, 3));
		pList.add(new Process("P4", 4, 4, 7, 0, 0, 8, 0, 7, 0, 0, 1, 1));
		pList.add(new Process("P5", 6, 6, 5, 0, 0, 3, 0, 5, 0, 0, 0, 0));
		pList.add(new Process("P6", 7, 7, 4, 0, 0, 6, 0, 4, 0, 0, 1, 1));
		pList.add(new Process("P7", 8, 8, 6, 0, 0, 9, 0, 6, 0, 0, 2, 2));

		
	

	}

	public static void FCFS(ArrayList<Process> pList) {//First come first serve 

	
		ArrayList<Process> answers = new ArrayList<>();// the answer arrayList
		ArrayList<Process> pList2= new ArrayList<>();//An arrayList that carries the seven processes 
	    ArrayList<Process> processes = new ArrayList<>();// The arrived processes arraylist
		initializeProcessList(pList); //initialising the input arrayList with the seven processes 

		int waiting = 0;
		Process minProcess;
		int m = 0;
		processes.clear();

		waiting = 0;
		int comp=0;
        


		// start

		while (1 == 1) {

			Collections.sort(pList, Comparator.comparingInt(Process::getArrivalTime));

			if (m != 0) {
 
				//A loop to check which which processes have arrived 
				for (int j = 1; j < pList.size(); j++) {

					if (((hasarrived2(answers.get(answers.size() - 1).completion, pList.get(j).arrivalTime)) == 1)
							&& (pList.get(j).Arrived == 0)) {

						pList.get(j).Arrived = 1;

						processes.add(pList.get(j));

					}
				}

			}

		
			if (m == 0) {// first process

				answers.add(pList.get(m));
				pList.get(m).completion = pList.get(m).burstTime;
				answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
						+ answers.get(answers.size() - 1).completion - answers.get(answers.size() - 1).waitingTime;

				//The processes finishes and reEnteres the waiting queue
				Process p = new Process(pList.get(m).name, pList.get(m).arrivalTime, 0, pList.get(m).burstTime,
						pList.get(m).waitingTime, 0, pList.get(m).comeBack, 0, 0,
						answers.get(answers.size() - 1).timesCalled + 1, answers.get(answers.size() - 1).prevExcecution,
						pList.get(m).priorityOrg, pList.get(m).priorityOrg);

				p.arrivalTime = pList.get(m).completion + pList.get(m).comeBack;
				pList.add(p);

			} else {// other processes

		
		       //Sorting the arrived processes based on their arrival time 
				Collections.sort(processes, Comparator.comparingInt(Process::getArrivalTime));
				
				minProcess = processes.get(0);
				processes.remove(0);
				
				// calculating the waiting time and completion time 
				waiting += answers.get(m - 1).burstTime;
				comp = waiting + minProcess.burstTime;

				if (waiting < END_TIME) {

					if (comp > END_TIME)// time reached 200 
						minProcess.completion = END_TIME;
					else
						minProcess.completion = comp;
					minProcess.waitingTime = waiting;
					answers.add(minProcess);
					answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
							+ answers.get(answers.size() - 1).completion - answers.get(answers.size() - 1).waitingTime;
					//The processes finishes and reEnteres the waiting queue with a new arrival time 
					Process p = new Process(minProcess.name, minProcess.arrivalTime, 0, minProcess.burstTime,
							minProcess.waitingTime, 0, minProcess.comeBack, 0, 0,
							answers.get(answers.size() - 1).timesCalled + 1,
							answers.get(answers.size() - 1).prevExcecution, minProcess.priorityOrg,
							minProcess.priorityOrg);
					p.arrivalTime = minProcess.completion + minProcess.comeBack;
					pList.add(p);

				} else
					break;

			}

			m++;
		}



		System.out.println("\n");
		System.out.println("FCFS :\n");
		System.out.println("-Gant:");

		System.out.print("(0)");
	
		for (Process process : answers) {
			System.out.print(process.name + " ( " + process.completion + ")");

		}
		pList2.clear();
		initializeProcessList(pList2);

		assignBurstTime1(answers, pList2);

		System.out.println("\n");
		System.out.println("-Time:");
		double avg = 0;
		double avg1 = 0;
		double ans = 0;
		int count = 0;
		// calculating the waiting time and turn around  time for each process 
		for (Process process : pList2) {
			int prevExcution = process.prevExcecution - (process.completion - process.waitingTime);
			int called = process.timesCalled;
			int comeback = process.comeBack * called;
			int wait = process.waitingTime - prevExcution - process.arrivalTime - comeback;
			int turn = wait + process.prevExcecution + comeback;
			if (process.waitingTime == 0 && process.prevExcecution == 0) {
				wait = 0;

			}
			if (process.completion == 0) {
				turn = 0;
				count--;
			}
			System.out.println(
					process.name + ":      waiting time " + "  =" + wait + "    Turnabout time" + "  =" + turn);
		
			// calculating the average waiting time and average turn around time 
			avg += wait;
			avg1 += turn;
			count++;
		}
		ans = avg / count;
		System.out.println("");
		System.out.println("Average waiting time =" + ans);
		ans = avg1 / count;
		System.out.println("Average Turnabout time =" + ans);

	}

	public static void SJF(ArrayList<Process> pList) {//Shortest Job First
		
		ArrayList<Process> answers = new ArrayList<>();// the answer arrayList
		
		ArrayList<Process> pList2= new ArrayList<>();//An arrayList that carries the seven processes 
		
	    ArrayList<Process> processes = new ArrayList<>();// The arrived processes arrayList

		int m = 0;
		Process minProcess;

		pList2.clear();
		initializeProcessList(pList2);
		pList.clear();
		initializeProcessList(pList); //initialising the input arrayList with the seven processes 

		processes.clear();
		int comp = 0;
		int waiting = 0;

		double avg = 0;
		double avg1 = 0;
		double ans = 0;

		while (1 == 1) {

			Collections.sort(pList, Comparator.comparingInt(Process::getArrivalTime));

			if (m != 0) {
				for (int j = 1; j < pList.size(); j++) {	//A loop to check which which processes have arrived 
						
					if (((hasarrived2(answers.get(answers.size() - 1).completion, pList.get(j).arrivalTime)) == 1)
							&& (pList.get(j).Arrived == 0)) {
			       
						pList.get(j).Arrived = 1;


						processes.add(pList.get(j));
						
						//Sorting the processes in the ready queue based on their burst time 
						Collections.sort(processes, Comparator.comparingInt(Process::getBurstTime));

					}
				}

			}

			if (comp > END_TIME)//  time passed 200
				break;

			if (m == 0) {// first process
				 
				answers.add(pList.get(m));
				//The processes finishes and reEnteres the waiting queue with a new arrival time 
				pList.get(m).completion = pList.get(m).burstTime;
				Process p = new Process(pList.get(m).name, pList.get(m).arrivalTime, 0, pList.get(m).burstTime,
						pList.get(m).waitingTime, 0, pList.get(m).comeBack, 0, 0, pList.get(m).timesCalled + 1, 0, 0,
						0);
				p.prevExcecution = pList.get(m).completion;
				p.arrivalTime = pList.get(m).waitingTime + pList.get(m).comeBack;
				pList.add(p);

			} else {// other processes

				minProcess = processes.get(0);
				processes.remove(0);
				waiting += answers.get(m - 1).burstTime;
				comp = waiting + minProcess.burstTime;

				if (waiting < END_TIME) {

					if (comp > END_TIME)// time passed 200
						minProcess.completion = END_TIME;
					else// calculating the waiting time and completion time for each process 
						minProcess.completion = comp;
					minProcess.waitingTime = waiting;
					minProcess.prevExcecution += minProcess.completion - waiting;
					answers.add(minProcess);
					//The processes finishes and reEnteres the waiting queue with a new arrival time 
					Process p = new Process(minProcess.name, minProcess.arrivalTime, 0, minProcess.burstTime,
							minProcess.waitingTime, 0, minProcess.comeBack, 0, 0, minProcess.timesCalled + 1,
							minProcess.prevExcecution, 0, 0);
					p.comebackTimes = minProcess.comebackTimes;
					p.arrivalTime = minProcess.completion + minProcess.comeBack;
					pList.add(p);

				}

			}

			m++;
		}

		System.out.println("\n");
		System.out.println("SJF :\n");
		System.out.println("-Gant:");
		System.out.print("(0)");
		for (Process process : answers) {
			System.out.print(process.name + " ( " + process.completion + ")");

		}

		pList2.clear();
		initializeProcessList(pList2);

		assignBurstTime1(answers, pList2);

		System.out.println("\n");
		System.out.println("-Time:");

		avg = 0;
		avg1 = 0;
		int count = 0;

		// calculating the  waiting time and turn around time for each process
		for (Process process : pList2) {
			int prevExcution = process.prevExcecution - (process.completion - process.waitingTime);
			int called = process.timesCalled;
			int comeback = process.comeBack * called;
			int wait = process.waitingTime - prevExcution - process.arrivalTime - comeback;
			int turn = wait + process.prevExcecution + comeback;
			if (process.waitingTime == 0 && process.prevExcecution == 0) {
				wait = 0;

			}
			if (process.completion == 0) {
				turn = 0;
				count--;
			}
			if(wait!=0 || turn!=0)
			System.out.println(
					process.name + ":      waiting time " + "  =" + wait + "    Turnabout time" + "  =" + turn);
			else 
				System.out.println(
						process.name + ":      waiting time " + "  = infinity"  + "    Turnabout time" + "  = infinity" );
			avg += wait;
			avg1 += turn;
			count++;
		}
		// calculating the average waiting time and average turn around time 
		ans = avg / count;
		System.out.println("");
		System.out.println("Average waiting time =" + ans);
		ans = avg1 / count;
		System.out.println("Average Turnabout time =" + ans);

	}

	public static void SRTF(ArrayList<Process> pList3) {//Shortest remaining time first

		pList3.clear();

		ArrayList<Process> answers = new ArrayList<>();// the answer arrayList
		
		ArrayList<Process> pList2= new ArrayList<>();//An arrayList that carries the seven processes
		
	    ArrayList<Process> processes = new ArrayList<>();// The arrived processes arraylist
	    
		initializeProcessList(pList3); //initialising the input arrayList with the seven processes 
		int m = 0;
		Process minProcess;
		int count = 0;

		processes.clear();
		int comp = 0;
		int waiting = 0;

		double avg = 0;
		double avg1 = 0;
		double ans = 0;

		processes.clear();
		answers.clear();

		waiting = 0;
		Collections.sort(pList3, Comparator.comparingInt(Process::getArrivalTime));
		answers.add(pList3.get(0));

		for (int j = 0; j < END_TIME; j++) {

			for (int k = 1; k < pList3.size(); k++) {
				// Loop to add the arrived processes to the ready queue
				
				if (((hasarrived2(j, pList3.get(k).arrivalTime)) == 1)
						&& (pList3.get(k).Arrived == 0)) {
		        
					pList3.get(k).Arrived = 1;

					processes.add(pList3.get(k));
				}
			}
			//Sorting the processes in the ready queue based on their remaining burst time 
			Collections.sort(processes, Comparator.comparingInt(Process::getRemain));

			if (j == 0) {// first process

				answers.get(answers.size() - 1).completion++;
				answers.get(answers.size() - 1).remain--;
				answers.get(answers.size() - 1).prevExcecution++;

			} else {// other processes
              if(processes.size()!=0) {
                //determining the process with the least burst time 
				if (processes.get(0).remain < answers.get(answers.size() - 1).remain) {
					minProcess = processes.get(0);

				} else
					minProcess = answers.get(answers.size() - 1);
				
				
                //The process doesn't change 
				if (minProcess.name.compareTo(answers.get(answers.size() - 1).name) == 0) {

					answers.get(answers.size() - 1).completion = j + 1;
					answers.get(answers.size() - 1).remain--;

					if (answers.get(answers.size() - 1).remain == 0 // the process finished its burst time 
							|| answers.get(answers.size() - 1).completion == END_TIME) {
						
						//The processes finishes and reEnteres the waiting queue with a new arrival time 
						//Passing the attributes 
						answers.get(answers.size() - 1).remain = 200;
						answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
								+ answers.get(answers.size() - 1).completion
								- answers.get(answers.size() - 1).waitingTime;

						Process p = new Process(answers.get(answers.size() - 1).name,
								answers.get(answers.size() - 1).arrivalTime, 0,
								answers.get(answers.size() - 1).burstTime, answers.get(answers.size() - 1).waitingTime,
								0, answers.get(answers.size() - 1).comeBack, 0, answers.get(answers.size() - 1).remain,
								answers.get(answers.size() - 1).timesCalled + 1,
								answers.get(answers.size() - 1).prevExcecution, 0, 0);
						p.arrivalTime = answers.get(answers.size() - 1).completion
								+ answers.get(answers.size() - 1).comeBack;
						p.remain = p.burstTime;
						pList3.add(p);

					}

				} else {//A process with less burst time enters 

					processes.remove(0);
					if (answers.get(answers.size() - 1).remain == 0) {
						answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
								+ answers.get(answers.size() - 1).completion
								- answers.get(answers.size() - 1).waitingTime;
						answers.get(answers.size() - 1).timesCalled++;

					}
					
					//Passing the attributes 
					Process p = new Process(answers.get(answers.size() - 1).name,
							answers.get(answers.size() - 1).arrivalTime, 0, answers.get(answers.size() - 1).burstTime,
							answers.get(answers.size() - 1).waitingTime, 0, answers.get(answers.size() - 1).comeBack, 0,
							answers.get(answers.size() - 1).remain, answers.get(answers.size() - 1).timesCalled,
							answers.get(answers.size() - 1).prevExcecution, 0, 0);
					p.prevExcecution += answers.get(answers.size() - 1).completion
							- answers.get(answers.size() - 1).waitingTime;
					if (p.remain != 0) {	//The processes Leaves and reEnteres the waiting queue due to another process entering the cpu
						pList3.add(p);

					} else {//The processes finishes and reEnteres the waiting queue with a new arrival time 
						p.arrivalTime = answers.get(answers.size() - 1).completion
								+ answers.get(answers.size() - 1).comeBack;
						p.timesCalled++;
						p.remain = p.burstTime;
						pList3.add(p);
					}
					minProcess.waitingTime = answers.get(answers.size() - 1).completion;

					answers.add(minProcess);
					answers.get(answers.size() - 1).completion = j + 1;
					answers.get(answers.size() - 1).remain--;

				}
              }
			}

		}

		System.out.println("\n");
		System.out.println("SRTF :\n");
		System.out.println("-Gant:");
		System.out.print("(0)");

		for (Process process : answers) {
			System.out.print(process.name + " ( " + process.completion + ")");

		}

		pList2.clear();
		initializeProcessList(pList2);

		assignBurstTime1(answers, pList2);

		System.out.println("\n");
		System.out.println("-Time:");

		System.out.println("");

		System.out.println("");
		avg = 0;
		avg1 = 0;
		count = 0;

		// calculating the  waiting time and turn around time for each process
		for (Process process : pList2) {
			int prevExcution = process.prevExcecution - (process.completion - process.waitingTime);
			int called = process.timesCalled;
			int comeback = process.comeBack * called;
			int wait = process.waitingTime - prevExcution - process.arrivalTime - comeback;
			int turn = wait + process.prevExcecution + comeback;
			if (process.waitingTime == 0 && process.prevExcecution == 0) {
				wait = 0;

			}
			if (wait<0)
				wait=0;
			if (process.completion == 0) {
				turn = 0;
				count--;
			}
			if(wait!=0 || turn!=0)
			System.out.println(
					process.name + ":      waiting time " + "  =" + wait + "    Turnabout time" + "  =" + turn);
			else 
				System.out.println(
						process.name + ":      waiting time " + "  = infinity"  + "    Turnabout time" + "  = infinity" );
			avg += wait;
			avg1 += turn;
			count++;
		}
		// calculating the average waiting time and average turn around time 
		ans = avg / count;
		System.out.println("");
		System.out.println("Average waiting time =" + ans);
		ans = avg1 / count;
		System.out.println("Average Turnabout time =" + ans);

	}

	public static void RR(ArrayList<Process> pList3) {//Round Robin 

		ArrayList<Process> answers = new ArrayList<>();// the answer arrayList
		
		ArrayList<Process> pList2= new ArrayList<>();//An arrayList that carries the seven processes 
		
	    ArrayList<Process> processes = new ArrayList<>();// The arrived processes arrayList

		int m = 0;

		Process minProcess;
		int count = 0;
		int comp = 0;
		int waiting = 0;

		double avg = 0;
		double avg1 = 0;
		double ans = 0;

		pList3.clear();
		initializeProcessList(pList3);//initialising the input arrayList with the seven processes 
		processes.clear();
		answers.clear();

		waiting = 0;
		int counter = 0;
		Collections.sort(pList3, Comparator.comparingInt(Process::getArrivalTime));
		answers.add(pList3.get(0));

		for (int j = 0; j < END_TIME; j++) {

			for (int k = 1; k < pList3.size(); k++) {
				// Loop to add the arrived processes to the waiting list
		
				if (((hasarrived2(j, pList3.get(k).arrivalTime)) == 1)
						&& (pList3.get(k).Arrived == 0)) {

					pList3.get(k).Arrived = 1;

					processes.add(pList3.get(k));

				}
			}	
			Collections.sort(pList3, Comparator.comparingInt(Process::getArrivalTime));
		
			if (j == 0) {// first process
				answers.get(answers.size() - 1).completion++;
				answers.get(answers.size() - 1).remain--;

			} else {// other processes
                
				 if (processes.size()!=0) {
				//The process finished its burst or Q=5 passed a new process enters 
				if (((answers.get(answers.size() - 1).remain) == 0) || (counter % 5 == 0)) {
					minProcess = processes.get(0);
					processes.remove(0);
					counter = 0;
				} else
					minProcess = answers.get(answers.size() - 1);

				//The process didnt change 
				if (minProcess.name.compareTo(answers.get(answers.size() - 1).name) == 0) {
				
					answers.get(answers.size() - 1).completion = j + 1;
			
					answers.get(answers.size() - 1).remain--;
					if (j == END_TIME - 1) // time reaches 200
						answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
								+ answers.get(answers.size() - 1).completion
								- answers.get(answers.size() - 1).waitingTime;

				} else {
					answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
							+ answers.get(answers.size() - 1).completion - answers.get(answers.size() - 1).waitingTime;

					
					//Passing the attributes 
					Process p = new Process(answers.get(answers.size() - 1).name,
							answers.get(answers.size() - 1).arrivalTime, 0, answers.get(answers.size() - 1).burstTime,
							answers.get(answers.size() - 1).waitingTime, 0, answers.get(answers.size() - 1).comeBack, 0,
							answers.get(answers.size() - 1).remain, answers.get(answers.size() - 1).timesCalled,
							answers.get(answers.size() - 1).prevExcecution, 0, 0);

					//The processes Leaves and reEnteres the waiting queue due to another process entering the cpu
					pList3.add(p);
					if (p.remain != 0)
						pList3.add(p);
					else {//The process finished its burst or Q=5 passed ,The processes Leaves and reEnteres with a new arrival time 
						p.arrivalTime = answers.get(answers.size() - 1).completion
								+ answers.get(answers.size() - 1).comeBack;
						p.remain = p.burstTime;
						p.timesCalled++;
						if (p.name.compareTo(pList3.get(pList3.size() - 1).name) != 0)
							pList3.add(p);
					}

					minProcess.waitingTime = answers.get(answers.size() - 1).completion;

					answers.add(minProcess);

					answers.get(answers.size() - 1).completion = j + 1;

					answers.get(answers.size() - 1).remain--;

				}

			}
			}

			counter++;

		}

		System.out.println("\n");
		System.out.println("Round Robin :\n");
		System.out.println("-Gant:");
		System.out.print("(0)");
        //Printing the gant chart 
		for (Process process : answers) {
			System.out.print(process.name + " ( " + process.completion + ")");

		}

		pList2.clear();
		initializeProcessList(pList2);

		assignBurstTime1(answers, pList2);

		System.out.println("\n");
		System.out.println("-Time:");



		avg = 0;
		avg1 = 0;
		count = 0;
		// calculating the  waiting time and turn around time for each process
		for (Process process : pList2) {
			int prevExcution = process.prevExcecution - (process.completion - process.waitingTime);
			int called = process.timesCalled;
			int comeback = process.comeBack * called;
			int wait = process.waitingTime - prevExcution - process.arrivalTime - comeback;
			int turn = wait + process.prevExcecution + comeback;
			if (process.waitingTime == 0 && process.prevExcecution == 0) {
				wait = 0;

			}
			if (process.completion == 0) {
				turn = 0;
				count--;
			}
			if(wait<0)
				wait=0;
			System.out.println(
					process.name + ":      waiting time " + "  =" + wait + "    Turnabout time" + "  =" + turn);
			avg += wait;
			avg1 += turn;
			count++;
		}
		// calculating the average waiting time and average turn around time 
		ans = avg / count;
		System.out.println("");
		System.out.println("Average waiting time =" + ans);
		ans = avg1 / count;
		System.out.println("Average Turnabout time =" + ans);

	}

	public static void PNP(ArrayList<Process> pList) {//Priority non Pre-emptive 
		
		ArrayList<Process> answers = new ArrayList<>();// the answer arrayList
		
		ArrayList<Process> pList2= new ArrayList<>();//An arrayList that carries the seven processes 
		
	    ArrayList<Process> processes = new ArrayList<>();// The arrived processes arrayList

		int m = 0;
		Process minProcess;
		int count = 0;

		int comp = 0;
		int waiting = 0;
		int counter = 0;

		double avg = 0;
		double avg1 = 0;
		double ans = 0;

		pList.clear();
		initializeProcessList(pList);

		waiting = 0;
		pList.clear();
		initializeProcessList(pList);
		answers.clear();
		m = 0;

		
		while (1 == 1) {
			//Sorting the processes in the ready queue based on their arrival time
			Collections.sort(pList, Comparator.comparingInt(Process::getArrivalTime));

			if (m != 0) {

				for (int j = 1; j < pList.size(); j++) {// Loop to add the arrived processes to the ready queue

					if (((hasarrived2(answers.get(answers.size() - 1).completion, pList.get(j).arrivalTime)) == 1)
							&& (pList.get(j).Arrived == 0)) {

						pList.get(j).Arrived = 1;

						processes.add(pList.get(j));

					}
				}

			}

		
			if (m == 0) {// first process

				answers.add(pList.get(m));
				pList.get(m).completion = pList.get(m).burstTime;
				answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
						+ answers.get(answers.size() - 1).completion - answers.get(answers.size() - 1).waitingTime;
				//The processes finishes and reEnteres the waiting queue with a new arrival time 
				//Passing the attributes 
				Process p = new Process(pList.get(m).name, pList.get(m).arrivalTime, 0, pList.get(m).burstTime,
						pList.get(m).waitingTime, 0, pList.get(m).comeBack, 0, 0,
						answers.get(answers.size() - 1).timesCalled + 1, answers.get(answers.size() - 1).prevExcecution,
						pList.get(m).priorityOrg, pList.get(m).priorityOrg);

				p.arrivalTime = pList.get(m).completion + pList.get(m).comeBack;
				pList.add(p);

			} else {// other processes

				
				//Reducing the priority due to aging 
				for (int i = 0; i < processes.size(); i++) {

					int fives = (answers.get(answers.size() - 1).completion - processes.get(i).arrivalTime) / 5;
					processes.get(i).priority = processes.get(i).priority - fives;

					if (processes.get(i).priority < 0)
						processes.get(i).priority = 0;

				}
				//Sorting the processes in the ready queue based on their priority
				Collections.sort(processes, Comparator.comparingInt(Process::getArrivalTime));
				Collections.sort(processes, Comparator.comparingInt(Process::getPriority));

				minProcess = processes.get(0);  //determining the process with the least priority
				processes.remove(0);
				waiting += answers.get(m - 1).burstTime;
				comp = waiting + minProcess.burstTime;

				if (waiting < END_TIME) {

					if (comp > END_TIME)// time reached 200 
						minProcess.completion = END_TIME;
					else
						minProcess.completion = comp;
					minProcess.waitingTime = waiting;
					answers.add(minProcess);
					answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
							+ answers.get(answers.size() - 1).completion - answers.get(answers.size() - 1).waitingTime;
					//The processes finishes and reEnteres the waiting queue with a new arrival time 
					//Passing the attributes 
					Process p = new Process(minProcess.name, minProcess.arrivalTime, 0, minProcess.burstTime,
							minProcess.waitingTime, 0, minProcess.comeBack, 0, 0,
							answers.get(answers.size() - 1).timesCalled + 1,
							answers.get(answers.size() - 1).prevExcecution, minProcess.priorityOrg,
							minProcess.priorityOrg);
					p.arrivalTime = minProcess.completion + minProcess.comeBack;
					pList.add(p);

				} else
					break;

			}

			m++;
		}

		System.out.println("\n");
		System.out.println("Priority scheduling non preemptive \n");
		System.out.println("-Gant:");
		System.out.print("(0)");
		for (Process process : answers) {
			System.out.print(process.name + " ( " + process.completion + ")");

		}

		pList2.clear();
		initializeProcessList(pList2);

		assignBurstTime1(answers, pList2);

		System.out.println("\n");
		System.out.println("-Time:");

		avg = 0;
		avg1 = 0;
		count = 0;
		// calculating the  waiting time and turn around time for each process
		for (Process process : pList2) {

			int prevExcution = process.prevExcecution - (process.completion - process.waitingTime);
			int called = process.timesCalled;
			int comeback = process.comeBack * called;
			int wait = process.waitingTime - prevExcution - process.arrivalTime - comeback;
			int turn = wait + process.prevExcecution + comeback;
			if (process.waitingTime == 0 && process.prevExcecution == 0) {
				wait = 0;

			}
			if (process.completion == 0) {
				turn = 0;
				count--;
			}
			if(wait <0)
				wait=0;
			System.out.println(
					process.name + ":      waiting time " + "  =" + wait + "    Turnabout time" + "  =" + turn);
			avg += wait;
			avg1 += turn;
			count++;
		}
		// calculating the average waiting time and average turn around time 
		ans = avg / count;
		System.out.println("");
		System.out.println("Average waiting time =" + ans);
		ans = avg1 / count;
		System.out.println("Average Turnabout time =" + ans);

	}

	public static void PP(ArrayList<Process> pList3) {//Priority Pre-emptive 

		ArrayList<Process> answers = new ArrayList<>();// the answer arrayList
		
		ArrayList<Process> pList2= new ArrayList<>();//An arrayList that carries the seven processes 
		
	    ArrayList<Process> processes = new ArrayList<>();// The arrived processes arrayList
		int m = 0;
		Process minProcess;
		int count = 0;
		int comp = 0;
		int waiting = 0;
		int counter = 0;

		double avg = 0;
		double avg1 = 0;
		double ans = 0;

		pList3.clear();
		initializeProcessList(pList3);

		for (Process process : pList3) {
			process.readyQ = process.arrivalTime;

		}

		waiting = 0;
		counter = 0;
		
		
		Collections.sort(pList3, Comparator.comparingInt(Process::getArrivalTime));
		answers.add(pList3.get(0));//Passing the first process to the cpu 

		// start

		for (int j = 0; j < END_TIME; j++) {
			
			// Loop to add the arrived processes to the ready queue
			for (int k = 1; k < pList3.size(); k++) {

				Collections.sort(pList3, Comparator.comparingInt(Process::getArrivalTime));
				if (((hasarrived2(j, pList3.get(k).arrivalTime)) == 1)
						&& (pList3.get(k).Arrived == 0)) {

					pList3.get(k).Arrived = 1;

					processes.add(pList3.get(k));

				}
			}

			if (j == 0) {// first process

				answers.get(answers.size() - 1).completion++;
				answers.get(answers.size() - 1).remain--;
				answers.get(answers.size() - 1).readyQ++;

			} else {// other processes

				for (int i = 0; i < processes.size(); i++) {	//Reducing the priority due to aging 

					int fives = (answers.get(answers.size() - 1).completion - processes.get(i).readyQ) / 5;
					processes.get(i).priority = processes.get(i).priority - fives;

					if (processes.get(i).priority < 0)
						processes.get(i).priority = 0;

				}
				//Sorting the processes in the ready queue based on the time they entered the readyQ and based on their priority
				Collections.sort(processes, Comparator.comparingInt(Process::getReadyQ));
				Collections.sort(processes, Comparator.comparingInt(Process::getPriority));
		
				
				
            if(processes.size()>0) {
            	 //determining the process with the least priority if a new process will enter
				if (((answers.get(answers.size() - 1).remain) == 0)
						|| (processes.get(0).priority < answers.get(answers.size() - 1).priority)) {
					minProcess = processes.get(0);
					processes.remove(0);
					counter = 0;
				} else
					minProcess = answers.get(answers.size() - 1);

				for (Process process : processes) {
					process.priority = process.priorityOrg;

				}
				
				//The process doesn't change 
				if (minProcess.name.compareTo(answers.get(answers.size() - 1).name) == 0) {

					answers.get(answers.size() - 1).completion = j + 1;
					answers.get(answers.size() - 1).remain--;
					if (j + 1 == 200)
						answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
								+ answers.get(answers.size() - 1).completion
								- answers.get(answers.size() - 1).waitingTime;

				} else {

					answers.get(answers.size() - 1).prevExcecution = answers.get(answers.size() - 1).prevExcecution
							+ answers.get(answers.size() - 1).completion - answers.get(answers.size() - 1).waitingTime;

					if (answers.get(answers.size() - 1).remain != 0) {		//The processes Leaves the cpu and reEnteres the waiting queue 

						Process p = new Process(answers.get(answers.size() - 1).name,
								answers.get(answers.size() - 1).arrivalTime,
								answers.get(answers.size() - 1).arrivalTimeOrg,
								answers.get(answers.size() - 1).burstTime, answers.get(answers.size() - 1).waitingTime,
								0, answers.get(answers.size() - 1).comeBack, 0, answers.get(answers.size() - 1).remain,
								answers.get(answers.size() - 1).timesCalled,
								answers.get(answers.size() - 1).prevExcecution,
								answers.get(answers.size() - 1).priority, answers.get(answers.size() - 1).priorityOrg);
						p.readyQ = answers.get(answers.size() - 1).completion;

						if (j + 1 == END_TIME)
							p.prevExcecution = p.prevExcecution + p.completion - p.waitingTime;
						pList3.add(p);
 
	
					} else if (answers.get(answers.size() - 1).remain == 0) {				
					//The processes finishes and reEnteres the waiting queue with a new arrival time 
					//Passing the attributes 
						Process p = new Process(answers.get(answers.size() - 1).name,
								answers.get(answers.size() - 1).arrivalTimeOrg,
								answers.get(answers.size() - 1).arrivalTimeOrg,
								answers.get(answers.size() - 1).burstTime, answers.get(answers.size() - 1).waitingTime,
								0, answers.get(answers.size() - 1).comeBack, 0, answers.get(answers.size() - 1).remain,
								answers.get(answers.size() - 1).timesCalled + 1,
								answers.get(answers.size() - 1).prevExcecution,
								answers.get(answers.size() - 1).priorityOrg,
								answers.get(answers.size() - 1).priorityOrg);

						p.arrivalTime = answers.get(answers.size() - 1).completion
								+ answers.get(answers.size() - 1).comeBack;
						p.readyQ = p.arrivalTime;
						p.remain = p.burstTime;
						if (j + 1 == END_TIME)
							p.prevExcecution = p.prevExcecution + p.completion - p.waitingTime;
						if (p.name.compareTo(pList3.get(pList3.size() - 1).name) != 0)
							pList3.add(p);
						
					}

					minProcess.waitingTime = answers.get(answers.size() - 1).completion;

					answers.add(minProcess);

					answers.get(answers.size() - 1).completion = j + 1;
					answers.get(answers.size() - 1).arrivalTime++;
					answers.get(answers.size() - 1).remain--;

				}
              }
			}

			counter++;

		}

		System.out.println("\n");
		System.out.println("Preemptive priority scheduling  :\n");
		System.out.println("-Gant:");
		System.out.print("(0)");

		for (Process process : answers) {
			System.out.print(process.name + " ( " + process.completion + ")");

		}

		pList2.clear();

		initializeProcessList(pList2);

		assignBurstTime1(answers, pList2);

		System.out.println("\n");
		System.out.println("-Time:");

		System.out.println("");

		avg = 0;
		avg1 = 0;
		count = 0;

		for (Process process : pList2) {
			// calculating the  waiting time and turn around time for each process
			int prevExcution = process.prevExcecution - (process.completion - process.waitingTime);
			int called = process.timesCalled;
			int comeback = process.comeBack * called;
			int wait = process.waitingTime - prevExcution - process.arrivalTime - comeback;
			int turn = wait + process.prevExcecution + comeback;
			if (process.waitingTime == 0 && process.prevExcecution == 0) {
				wait = 0;

			}
			if (process.completion == 0) {
				turn = 0;
				count--;
			}
			if (wait<0)
				wait=0;
			System.out.println(
					process.name + ":      waiting time " + "  =" + wait + "    Turnabout time" + "  =" + turn);
			avg += wait;
			avg1 += turn;
			count++;
		}
		// calculating the average waiting time and average turn around time 
		ans = avg / count;
		System.out.println("");
		System.out.println("Average waiting time =" + ans);
		ans = avg1 / count;
		System.out.println("Average Turnabout time =" + ans);

	}

	public static void main(String[] args) {

		ArrayList<Process> pList = new ArrayList<>();

		
		//Calling the functions of each of the five algorithms 
		
		FCFS(pList);//First come first serve 

		SJF(pList);//Shortest Job First

		SRTF(pList);//Shortest remaining time first

		RR(pList);//Round Robin 

		PNP(pList);//Priority non Pre-emptive 

		PP(pList);//Priority Pre-emptive 

		// end

	}

}
