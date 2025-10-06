#include <stdio.h>

// Define the structure for a Player
typedef struct Player
{
    char name[50];
    int matches;
    int runs;
    int wickets;
} Player;

void acceptInfo(Player *p, int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("\nEnter details for Player %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", p[i].name);
        printf("Matches Played: ");
        scanf("%d", &p[i].matches);
        printf("Total Runs: ");
        scanf("%d", &p[i].runs);
        printf("Wickets Taken: ");
        scanf("%d", &p[i].wickets);
    }
}

void displayInfo(Player *p, int n)
{
    printf("\nPlayer Information\n");
    printf("Name\t\tMatches\t\tRuns\t\tWickets\n");
    for (int i = 0; i < n; i++)
    {
        printf("%s\t\t%d\t\t%d\t\t%d\n", p[i].name, p[i].matches, p[i].runs, p[i].wickets);
    }
}

void displayMaxStats(Player *p, int n)
{
    if (n <= 0)
        return;

    int maxRunsIndex = 0;
    int maxWicketsIndex = 0;

    for (int i = 1; i < n; i++)
    {
        if (p[i].runs > p[maxRunsIndex].runs)
        {
            maxRunsIndex = i;
        }
        if (p[i].wickets > p[maxWicketsIndex].wickets)
        {
            maxWicketsIndex = i;
        }
    }

    printf("\nTop Performers\n");
    printf("Player with maximum runs: %s (%d runs)\n", p[maxRunsIndex].name, p[maxRunsIndex].runs);
    printf("Player with maximum wickets: %s (%d wickets)\n", p[maxWicketsIndex].name, p[maxWicketsIndex].wickets);
}

void main()
{
    struct Player players[10];
    int choice = 1;

    do
    {
        printf("\n\nPress 0: Exit");
        printf("\nPress 1: Add new player(s)");
        printf("\nPress 2: To display all player details");
        printf("\nPress 3: To show top performers");

        printf("\n\nEnter choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 0:
            printf("\nExited\n");
            break;
        case 1:
            acceptInfo(players, 10);
            break;
        case 2:
            displayInfo(players, 10);
            break;
        case 3:
            displayMaxStats(players, 10);
            break;
        
        default:
            printf("\nWrong choice... \nEnter correct choice...\n\n");
            break;
        }

    } while (choice != 0);
}