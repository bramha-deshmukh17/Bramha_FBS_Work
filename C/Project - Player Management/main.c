#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int arraySize = 10, playerCount = 10;

typedef struct Date
{
    int day, month, year;

} Date;

typedef struct Player
{

    int jno, runs, wickets, matches, century, half_century, outs, runs_conceded, over_bowled;

    char name[20], category[12];
    Date dob;

} Player;

void defaultDataAdd(Player *ptr)
{
    // Player 1: Virat Kohli (index 0)
    ptr[0].jno = 1;
    strcpy(ptr[0].name, "Virat Kohli");
    strcpy(ptr[0].category, "All-Rounder");
    ptr[0].runs = 100;
    ptr[0].wickets = 5;
    ptr[0].matches = 10;
    ptr[0].century = 1;
    ptr[0].half_century = 1;
    ptr[0].runs_conceded = 5;
    ptr[0].over_bowled = 2;
    ptr[0].outs = 1;
    ptr[0].dob.day = 1;
    ptr[0].dob.month = 1;
    ptr[0].dob.year = 1990;

    // Player 2: Rohit Sharma (index 1)
    ptr[1].jno = 2;
    strcpy(ptr[1].name, "Rohit Sharma");
    strcpy(ptr[1].category, "Bowler");
    ptr[1].runs = 200;
    ptr[1].wickets = 10;
    ptr[1].matches = 20;
    ptr[1].century = 2;
    ptr[1].half_century = 2;
    ptr[1].runs_conceded = 10;
    ptr[1].over_bowled = 4;
    ptr[1].outs = 2;
    ptr[1].dob.day = 2;
    ptr[1].dob.month = 2;
    ptr[1].dob.year = 1991;

    // Player 3: MS Dhoni (index 2)
    ptr[2].jno = 3;
    strcpy(ptr[2].name, "MS Dhoni");
    strcpy(ptr[2].category, "Batsman");
    ptr[2].runs = 300;
    ptr[2].wickets = 15;
    ptr[2].matches = 30;
    ptr[2].century = 3;
    ptr[2].half_century = 3;
    ptr[2].runs_conceded = 15;
    ptr[2].over_bowled = 6;
    ptr[2].outs = 3;
    ptr[2].dob.day = 3;
    ptr[2].dob.month = 3;
    ptr[2].dob.year = 1992;

    // Player 4: Sachin Tendulkar (index 3)
    ptr[3].jno = 4;
    strcpy(ptr[3].name, "Sachin Tendulkar");
    strcpy(ptr[3].category, "All-Rounder");
    ptr[3].runs = 400;
    ptr[3].wickets = 20;
    ptr[3].matches = 40;
    ptr[3].century = 4;
    ptr[3].half_century = 4;
    ptr[3].runs_conceded = 20;
    ptr[3].over_bowled = 8;
    ptr[3].outs = 4;
    ptr[3].dob.day = 4;
    ptr[3].dob.month = 4;
    ptr[3].dob.year = 1993;

    // Player 5: Rahul Dravid (index 4)
    ptr[4].jno = 5;
    strcpy(ptr[4].name, "Rahul Dravid");
    strcpy(ptr[4].category, "Bowler");
    ptr[4].runs = 500;
    ptr[4].wickets = 25;
    ptr[4].matches = 50;
    ptr[4].century = 5;
    ptr[4].half_century = 5;
    ptr[4].runs_conceded = 25;
    ptr[4].over_bowled = 10;
    ptr[4].outs = 5;
    ptr[4].dob.day = 5;
    ptr[4].dob.month = 5;
    ptr[4].dob.year = 1994;

    // Player 6: Yuvraj Singh (index 5)
    ptr[5].jno = 6;
    strcpy(ptr[5].name, "Yuvraj Singh");
    strcpy(ptr[5].category, "Batsman");
    ptr[5].runs = 600;
    ptr[5].wickets = 30;
    ptr[5].matches = 60;
    ptr[5].century = 6;
    ptr[5].half_century = 6;
    ptr[5].runs_conceded = 30;
    ptr[5].over_bowled = 12;
    ptr[5].outs = 6;
    ptr[5].dob.day = 6;
    ptr[5].dob.month = 6;
    ptr[5].dob.year = 1995;

    // Player 7: Suresh Raina (index 6)
    ptr[6].jno = 7;
    strcpy(ptr[6].name, "Suresh Raina");
    strcpy(ptr[6].category, "All-Rounder");
    ptr[6].runs = 700;
    ptr[6].wickets = 35;
    ptr[6].matches = 70;
    ptr[6].century = 7;
    ptr[6].half_century = 7;
    ptr[6].runs_conceded = 35;
    ptr[6].over_bowled = 14;
    ptr[6].outs = 7;
    ptr[6].dob.day = 7;
    ptr[6].dob.month = 7;
    ptr[6].dob.year = 1996;

    // Player 8: Jasprit Bumrah (index 7)
    ptr[7].jno = 8;
    strcpy(ptr[7].name, "Jasprit Bumrah");
    strcpy(ptr[7].category, "Bowler");
    ptr[7].runs = 800;
    ptr[7].wickets = 40;
    ptr[7].matches = 80;
    ptr[7].century = 8;
    ptr[7].half_century = 8;
    ptr[7].runs_conceded = 40;
    ptr[7].over_bowled = 16;
    ptr[7].outs = 8;
    ptr[7].dob.day = 8;
    ptr[7].dob.month = 8;
    ptr[7].dob.year = 1997;

    // Player 9: Hardik Pandya (index 8)
    ptr[8].jno = 9;
    strcpy(ptr[8].name, "Hardik Pandya");
    strcpy(ptr[8].category, "Batsman");
    ptr[8].runs = 900;
    ptr[8].wickets = 45;
    ptr[8].matches = 90;
    ptr[8].century = 9;
    ptr[8].half_century = 9;
    ptr[8].runs_conceded = 45;
    ptr[8].over_bowled = 18;
    ptr[8].outs = 9;
    ptr[8].dob.day = 9;
    ptr[8].dob.month = 9;
    ptr[8].dob.year = 1998;

    // Player 10: KL Rahul (index 9)
    ptr[9].jno = 10;
    strcpy(ptr[9].name, "KL Rahul");
    strcpy(ptr[9].category, "All-Rounder");
    ptr[9].runs = 1000;
    ptr[9].wickets = 50;
    ptr[9].matches = 100;
    ptr[9].century = 10;
    ptr[9].half_century = 10;
    ptr[9].runs_conceded = 50;
    ptr[9].over_bowled = 20;
    ptr[9].outs = 10;
    ptr[9].dob.day = 10;
    ptr[9].dob.month = 10;
    ptr[9].dob.year = 1999;
}

void display(Player *ptr)
{

    for (int i = 0; i < playerCount; i++)
    {

        printf("\nPlayer %d", i + 1);
        printf("\nJersey No.: %d", ptr[i].jno);
        printf("  Name: %s", ptr[i].name);
        printf("\nCategory: %s", ptr[i].category);
        printf("  DOB: %d/%d/%d", ptr[i].dob.day, ptr[i].dob.month, ptr[i].dob.year);
        printf("  Matches: %d", ptr[i].matches);
        printf("  Runs: %d", ptr[i].runs);
        printf("  Centuries: %d", ptr[i].century);
        printf("  Half-Centuries: %d", ptr[i].half_century);
        printf("\nWickets: %d", ptr[i].wickets);
        printf("  Runs Conceded: %d", ptr[i].runs_conceded);
        printf("  Overs Bowled: %d", ptr[i].over_bowled);

        // Batsman Average
        if (ptr[i].outs > 0)
            printf("  Batting Average: %.2f", (float)ptr[i].runs / ptr[i].outs);
        else
            printf("  Batting Average: N/A");

        // Bowling Economy
        if (ptr[i].over_bowled > 0)
            printf("  Economy: %.2f", (float)ptr[i].runs_conceded / ptr[i].over_bowled);
        else
            printf("  Economy: N/A");
    }
}

Player *addNewPlayer(Player *ptr)
{

    // increase array size only if array is full
    if (playerCount == arraySize)
    {
        arraySize += 5;
        Player *ptr = (Player *)realloc(ptr, arraySize * sizeof(Player));
    }

    printf("Enter player details:\n");

    printf("Jersey No.: ");
    scanf("%d", &ptr[playerCount].jno);

    for(int i=0; i<playerCount; i++) {
        if(ptr[i].jno == ptr[playerCount].jno) {
            printf("Jersey No. already exists. Please enter a unique Jersey No.\n");
            return ptr;
        }
    }

    fflush(stdin);
    printf("Name: ");
    gets(ptr[playerCount].name);

    fflush(stdin);
    printf("Category (Batsman/Bowler/All-Rounder): ");
    scanf("%s", ptr[playerCount].category);

    if (strcmp(ptr[playerCount].category, "Batsman") == 0)
    {
        
    }
    else if (strcmp(ptr[playerCount].category, "Bowler") == 0)
    {
        
    }
    else if (strcmp(ptr[playerCount].category, "All-Rounder") == 0)
    {
        
    }
    else
    {
        printf("Invalid category. Please enter Batsman, Bowler, or All-Rounder.\n");
        return ptr; 
    }

        int d, m, y, valid = 0;
        while (!valid) {
            printf("DOB (dd mm yyyy): ");
            if (scanf("%d %d %d", &d, &m, &y) != 3) {
                printf("Invalid input. Enter numbers only.\n");
                int c; while ((c = getchar()) != '\n' && c != EOF) {}
                continue;
            }

            if (y >= 1900 && y <= 2011) {
                printf("Invalid year. Enter a year between 1900 and 2011.\n");
                continue;
            }

            if (m >= 1 && m <= 12) {
                printf("Invalid month. Enter a value between 1 and 12.\n");
                continue;
            }

            int isLeap = (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
            int mdays;
            if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
                mdays = 31;
            } else if(m==4 || m==6 || m==9 || m==11) {
                mdays = 30;
            } else if(m==2) {
                mdays = isLeap ? 29 : 28;
            } else {
                mdays = 0; 
            }

            if (d < 1 || d > mdays) {
                printf("Invalid day. Enter a value between 1 and %d for the given month/year.\n", mdays);
                continue;
            }

            ptr[playerCount].dob.day = d;
            ptr[playerCount].dob.month = m;
            ptr[playerCount].dob.year = y;
            valid = 1;
        }
    

    printf("Matches: ");
    scanf("%d", &ptr[playerCount].matches);

    printf("Runs: ");
    scanf("%d", &ptr[playerCount].runs);

    printf("Wickets: ");
    scanf("%d", &ptr[playerCount].wickets);

    printf("Centuries: ");
    scanf("%d", &ptr[playerCount].century);

    printf("Half-Centuries: ");
    scanf("%d", &ptr[playerCount].half_century);

    printf("Runs Conceded: ");
    scanf("%d", &ptr[playerCount].runs_conceded);

    printf("Overs Bowled: ");
    scanf("%d", &ptr[playerCount].over_bowled);

    playerCount++;
    printf("\nPlayer added successfully!\n");

    return ptr;
}

void updateBowlingStats(Player *ptr)
{
    int jno;
    printf("Enter Jersey No. of player to update bowling stats: ");
    scanf("%d", &jno);

    for (int i = 0; i < playerCount; i++)
    {
        if (ptr[i].jno == jno)
        {
            int matches, wickets, runs_conceded, overs_bowled;
            printf("Add new bowling stats for one match:\n");
            printf("Wickets: ");
            scanf("%d", &wickets);
            printf("Runs Conceded: ");
            scanf("%d", &runs_conceded);
            printf("Overs Bowled: ");
            scanf("%d", &overs_bowled);

            ptr[i].matches += 1;
            ptr[i].wickets += wickets;
            ptr[i].runs_conceded += runs_conceded;
            ptr[i].over_bowled += overs_bowled;

            printf("\nBowling stats updated successfully!");
            return;
        }
    }
    printf("\nPlayer with Jersey No. %d not found.", jno);
}

void updateBattingStats(Player *ptr)
{
    int jno;
    printf("Enter Jersey No. of player to update batting stats: ");
    scanf("%d", &jno);

    for (int i = 0; i < playerCount; i++)
    {
        if (ptr[i].jno == jno)
        {
            int matches, runs, outs, centuries, half_centuries;
            printf("Add new batting stats for one match:\n");
            printf("Runs: ");
            scanf("%d", &runs);
            printf("Outs: ");
            scanf("%d", &outs);

            int century = runs / 100;
            int half_century = (runs % 100) / 50;

            ptr[i].matches += matches;
            ptr[i].runs += runs;
            ptr[i].outs += outs;
            ptr[i].century += century;
            ptr[i].half_century += half_century;

            printf("\nBatting stats updated successfully!");
            return;
        }
    }
    printf("\nPlayer with Jersey No. %d not found.", jno);
}

void updateBothStats(Player *ptr)
{
    int jno;
    printf("Enter Jersey No. of player to update both stats: ");
    scanf("%d", &jno);

    for (int i = 0; i < playerCount; i++)
    {
        if (ptr[i].jno == jno)
        {
            int matches, runs, outs, wickets, runs_conceded, overs_bowled;
            printf("Add new stats for one match:\n");
            printf("Runs: ");
            scanf("%d", &runs);
            printf("Out(0: No, 1:Yes):");
            scanf("%d", &outs);
            printf("Wickets: ");
            scanf("%d", &wickets);
            printf("Runs Conceded: ");
            scanf("%d", &runs_conceded);
            printf("Overs Bowled: ");
            scanf("%d", &overs_bowled);

            int century = runs / 100;
            int half_century = (runs % 100) / 50;

            ptr[i].matches += 1;
            ptr[i].runs += runs;
            ptr[i].outs += outs;
            ptr[i].century += century;
            ptr[i].half_century += half_century;
            ptr[i].wickets += wickets;
            ptr[i].runs_conceded += runs_conceded;
            ptr[i].over_bowled += overs_bowled;

            printf("\nStats updated successfully!");
            return;
        }
    }
    printf("\nPlayer with Jersey No. %d not found.", jno);
}

void updatePlayer(Player *ptr)
{

    int choice = 1;
    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit update submenu");
        printf("\nEnter 1: to update bowling stats");
        printf("\nEnter 2: to update batting stats");
        printf("\nEnter 3: to update both stats");

        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            updateBowlingStats(ptr);
            break;
        case 2:
            updateBattingStats(ptr);
            break;
        case 3:
            updateBothStats(ptr);
            break;
        default:
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");
            break;
        }

    } while (choice != 0);
}

void searchByJno(Player *ptr)
{
    int jno, found = 0;
    printf("Enter Jersey No. to search: ");
    scanf("%d", &jno);

    for (int i = 0; i < playerCount; i++)
    {
        if (ptr[i].jno == jno)
        {
            printf("\nPlayer found:");
            printf("\nJersey No.: %d", ptr[i].jno);
            printf("  Name: %s", ptr[i].name);
            printf("\nCategory: %s", ptr[i].category);
            printf("  DOB: %d/%d/%d", ptr[i].dob.day, ptr[i].dob.month, ptr[i].dob.year);
            printf("  Matches: %d", ptr[i].matches);
            printf("  Runs: %d", ptr[i].runs);
            printf("  Centuries: %d", ptr[i].century);
            printf("  Half-Centuries: %d", ptr[i].half_century);
            printf("\nWickets: %d", ptr[i].wickets);
            printf("  Runs Conceded: %d", ptr[i].runs_conceded);
            printf("  Overs Bowled: %d", ptr[i].over_bowled);

            // Batsman Average
            if (ptr[i].outs > 0)
                printf("  Batting Average: %.2f", (float)ptr[i].runs / ptr[i].outs);
            else
                printf("  Batting Average: N/A");

            // Bowling Economy
            if (ptr[i].over_bowled > 0)
                printf("  Economy: %.2f", (float)ptr[i].runs_conceded / ptr[i].over_bowled);
            else
                printf("  Economy: N/A");

            found = 1;
            break;
        }
    }
    if (!found)
    {
        printf("\nPlayer with Jersey No. %d not found.", jno);
    }
}

void searchByName(Player *ptr)
{
    char name[20];
    int found = 0;
    printf("Enter Name to search: ");
    fflush(stdin);
    gets(name);

    for (int i = 0; i < playerCount; i++)
    {
        if (strcasecmp(ptr[i].name, name) == 0)
        {
            printf("\nPlayer found:");
            printf("\nJersey No.: %d", ptr[i].jno);
            printf("  Name: %s", ptr[i].name);
            printf("\nCategory: %s", ptr[i].category);
            printf("  DOB: %d/%d/%d", ptr[i].dob.day, ptr[i].dob.month, ptr[i].dob.year);
            printf("  Matches: %d", ptr[i].matches);
            printf("  Runs: %d", ptr[i].runs);
            printf("  Centuries: %d", ptr[i].century);
            printf("  Half-Centuries: %d", ptr[i].half_century);
            printf("\nWickets: %d", ptr[i].wickets);
            printf("  Runs Conceded: %d", ptr[i].runs_conceded);
            printf("  Overs Bowled: %d", ptr[i].over_bowled);

            // Batsman Average
            if (ptr[i].outs > 0)
                printf("  Batting Average: %.2f", (float)ptr[i].runs / ptr[i].outs);
            else
                printf("  Batting Average: N/A");

            // Bowling Economy
            if (ptr[i].over_bowled > 0)
                printf("  Economy: %.2f", (float)ptr[i].runs_conceded / ptr[i].over_bowled);
            else
                printf("  Economy: N/A");

            found = 1;
            break;
        }
    }
    if (!found)
    {
        printf("\nPlayer with Name %s not found.", name);
    }
}

void searchPlayer(Player *ptr)
{
    int choice = 1;
    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit search submenu");
        printf("\nEnter 1: to search by Jersey No.");
        printf("\nEnter 2: to search by Name");

        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            searchByJno(ptr);
            break;
        case 2:
            searchByName(ptr);
            break;
        default:
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");
            break;
        }

    } while (choice != 0);
}

void sortPlayerByRuns(Player *ptr, int displayFlag)
{
    Player temp;
    for (int i = 0; i < playerCount - 1; i++)
    {
        for (int j = 0; j < playerCount - i - 1; j++)
        {
            if (ptr[j].runs < ptr[j + 1].runs)
            {
                temp = ptr[j];
                ptr[j] = ptr[j + 1];
                ptr[j + 1] = temp;
            }
        }
    }
    printf("\nPlayers sorted by Runs in descending order:");
    if (displayFlag)
        display(ptr);
}

void sortPlayerByWickets(Player *ptr, int displayFlag)
{
    Player temp;
    for (int i = 0; i < playerCount - 1; i++)
    {
        for (int j = i; j < playerCount - i - 1; j++)
        {
            if (ptr[j].wickets < ptr[j + 1].wickets)
            {
                temp = ptr[j];
                ptr[j] = ptr[j + 1];
                ptr[j + 1] = temp;
            }
        }
    }
    printf("\nPlayers sorted by Wickets in descending order:");
    if (displayFlag)
        display(ptr);
}

void sortPlayer(Player *ptr)
{
    int choice = 1;
    do
    {
        if (choice == 0)
            break;
        printf("\n\nPress 0: Exit sort submenu");
        printf("\nEnter 1: sort by Runs (descending)");
        printf("\nEnter 2: sort by Wickets (descending)\n");

        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            sortPlayerByRuns(ptr, 1);
            break;
        case 2:
            sortPlayerByWickets(ptr, 1);
            break;
        default:
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");
            break;
        }

    } while (choice != 0);
}

void findTop3Batsmen(Player *ptr)
{
    sortPlayerByRuns(ptr, 0);
    printf("\nTop 3 Batsmen:");
    for (int i = 0; i < 3 && i < playerCount; i++)
    {
        printf("\n%d. %s - Runs: %d", i + 1, ptr[i].name, ptr[i].runs);
    }
}

void findTop3Bowlers(Player *ptr)
{
    sortPlayerByWickets(ptr, 0);
    printf("\nTop 3 Bowlers:");
    for (int i = 0; i < 3 && i < playerCount; i++)
    {
        printf("\n%d. %s - Wickets: %d", i + 1, ptr[i].name, ptr[i].wickets);
    }
}

void topThreePlayers(Player *ptr)
{
    int choice = 1;
    do
    {
        printf("\n\nPress 0: Exit top three players submenu");
        printf("\nEnter 1: Top 3 Batsmen");
        printf("\nEnter 2: Top 3 Bowlers\n");

        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            findTop3Batsmen(ptr);
            break;
        case 2:
            findTop3Bowlers(ptr);
            break;
        default:
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");
            break;
        }

    } while (choice != 0);
}

void deleteByJno(Player *ptr)
{
    int jno, found = 0;
    printf("Enter Jersey No. to delete: ");
    scanf("%d", &jno);

    for (int i = 0; i < playerCount; i++)
    {
        if (ptr[i].jno == jno)
        {
            for (int j = i; j < playerCount - 1; j++)
            {
                ptr[j] = ptr[j + 1];
            }
            playerCount--;
            found = 1;
            printf("\nPlayer with Jersey No. %d deleted successfully.", jno);
            break;
        }
    }
    if (!found)
    {
        printf("\nPlayer with Jersey No. %d not found.", jno);
    }
}

void main()
{

    Player *ptr = (Player *)malloc(arraySize * sizeof(Player));
    int choice = 1;
    defaultDataAdd(ptr);
    printf("Players:");
    display(ptr);

    do
    {
        printf("\n\nPress 0: Exit");
        printf("\nPress 1: To display all player details");
        printf("\nPress 2: To Add new player details");
        printf("\nPress 3: To update player details");
        printf("\nPress 4: To Find a player");
        printf("\nPress 5: To Sort players");
        printf("\nPress 6: To find top 3 players");
        printf("\nPress 7: To delete player by Jersey No.");

        printf("\n\nEnter choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            display(ptr);
            break;
        case 2:
            ptr = addNewPlayer(ptr);
            break;
        case 3:
            updatePlayer(ptr);
            break;
        case 4:
            searchPlayer(ptr);
            break;
        case 5:
            sortPlayer(ptr);
            break;
        case 6:
            topThreePlayers(ptr);
            break;
        case 7:
            deleteByJno(ptr);
            break;
        default:
            choice != 0 ? printf("\nWrong choice... \nEnter correct choice...\n\n") : printf("\nExited");
            break;
        }

    } while (choice != 0);
}