#include <stdio.h>
 
// Function to perform SJF scheduling
void SJF_scheduling(int processes[][3], int n) {
    int completion_time[n];
    int turn_around_time[n];
    int waiting_time[n];
 
    // Sort processes based on arrival time
    for (int i = 0; i < n; i++) {
        int min_index = i;
        for (int j = i + 1; j < n; j++) {
            if (processes[j][1] < processes[min_index][1]) {
                min_index = j;
            }
        }
        // Swap processes
        int temp1 = processes[i][0];
        int temp2 = processes[i][1];
        int temp3 = processes[i][2];
        processes[i][0] = processes[min_index][0];
        processes[i][1] = processes[min_index][1];
        processes[i][2] = processes[min_index][2];
        processes[min_index][0] = temp1;
        processes[min_index][1] = temp2;
        processes[min_index][2] = temp3;
    }
 
    // Initialize completion_time array
    int current_time = 0;
 
    // Calculate completion time, turnaround time, and waiting time for each process
    for (int i = 0; i < n; i++) {
        current_time = (current_time > processes[i][1]) ? current_time : processes[i][1];
        current_time += processes[i][2];
        completion_time[i] = current_time;
        turn_around_time[i] = completion_time[i] - processes[i][1];
        waiting_time[i] = turn_around_time[i] - processes[i][2];
    }
 
    // Calculate average completion time, average turnaround time, and average waiting time
    float avg_completion_time = 0;
    float avg_turn_around_time = 0;
    float avg_waiting_time = 0;
    for (int i = 0; i < n; i++) {
        avg_completion_time += completion_time[i];
        avg_turn_around_time += turn_around_time[i];
        avg_waiting_time += waiting_time[i];
    }
    avg_completion_time /= n;
    avg_turn_around_time /= n;
    avg_waiting_time /= n;
 
    // Printing the output
    printf("\nProcess no | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting Time\n");
    for (int i = 0; i < n; i++) {
        printf("   %d       |      %d         |      %d      |       %d        |         %d         |        %d\n",
               processes[i][0], processes[i][1], processes[i][2], completion_time[i], turn_around_time[i], waiting_time[i]);
    }
    printf("\nAverage Completion Time: %.2f\n", avg_completion_time);
    printf("Average Turnaround Time: %.2f\n", avg_turn_around_time);
    printf("Average Waiting Time: %.2f\n", avg_waiting_time);
}
 
int main() {
    int num_processes;
    while (1) {
        printf("Enter the number of processes (Enter 0 to exit): ");
        scanf("%d", &num_processes);
        if (num_processes == 0) {
            printf("Exiting the program...\n");
            break;
        } else if (num_processes > 5) {
            printf("Limit crossed. Maximum 5 processes allowed.\n");
            continue;
        }
 
        int processes[num_processes][3];
        for (int i = 0; i < num_processes; i++) {
            printf("Enter arrival time for Process %d: ", i + 1);
            scanf("%d", &processes[i][1]);
            printf("Enter burst time for Process %d: ", i + 1);
            scanf("%d", &processes[i][2]);
            processes[i][0] = i + 1;
        }
 
        SJF_scheduling(processes, num_processes);
    }
    return 0;
}
