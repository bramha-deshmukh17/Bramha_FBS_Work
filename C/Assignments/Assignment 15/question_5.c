#include <stdio.h>
#include <string.h>

typedef struct Movie
{
    char title[100];
    char director[100];
    int year;
    char genre[50];
} Movie;

void addMovieExact(Movie database[], int *movieCount)
{
    if (*movieCount < 50)
    {
        fflush(stdin);
        printf("Enter title: ");
        gets(database[*movieCount].title);

        fflush(stdin);
        printf("Enter director: ");
        gets(database[*movieCount].director);

        printf("Enter release year: ");
        scanf("%d", &database[*movieCount].year);

        fflush(stdin);
        printf("Enter genre: ");
        gets(database[*movieCount].genre);

        (*movieCount)++;
        printf("Movie added successfully!\n");
    }
    else
    {
        printf("Database is full.\n");
    }
}

void displayAllMoviesExact(Movie database[], int movieCount)
{
    printf("\nAll Movies in Database\n");
    for (int i = 0; i < movieCount; i++)
    {
        printf("Title: %s, Director: %s, Year: %d, Genre: %s\n",
               database[i].title, database[i].director, database[i].year, database[i].genre);
    }
    if (movieCount == 0)
    {
        printf("No movies in the database.\n");
    }
}

void searchMovieByTitleExact(Movie database[], int movieCount)
{
    char searchTitle[100];
    int found = 0;
    printf("Enter title to search for: ");
    fgets(searchTitle, 100, stdin);
    strtok(searchTitle, "\n");

    for (int i = 0; i < movieCount; i++)
    {
        if (strcmp(database[i].title, searchTitle) == 0)
        {
            printf("\n--- Movie Found ---\n");
            printf("Title: %s, Director: %s, Year: %d, Genre: %s\n",
                   database[i].title, database[i].director, database[i].year, database[i].genre);
            found = 1;
            break;
        }
    }
    if (!found)
    {
        printf("Movie not found.\n");
    }
}

void updateMovieExact(Movie database[], int movieCount)
{
    char searchTitle[100];
    int idx = -1;

    printf("Enter title to update: ");
    fflush(stdin);
    gets(searchTitle);

    for (int i = 0; i < movieCount; i++)
    {
        if (strcasecmp(database[i].title, searchTitle) == 0)
        {
            idx = i;
            break;
        }
    }

    if (idx == -1)
    {
        printf("Movie not found.\n");
        return;
    }

    fflush(stdin);
    printf("Enter new title: ");
    gets(database[idx].title);

    fflush(stdin);
    printf("Enter new director: ");
    gets(database[idx].director);

    printf("Enter new release year: ");
    scanf("%d", &database[idx].year);

    fflush(stdin);
    printf("Enter new genre: ");
    gets(database[idx].genre);

    printf("Movie updated successfully!\n");
}

int main()
{
    Movie database[50];
    int movieCount = 0;
    int choice;

    do
    {
        printf("\nMovie Database Menu\n");
        printf("0. Exit\n");
        printf("1. Add a new movie\n");
        printf("2. Display all movies\n");
        printf("3. Search for a movie by title\n");
        printf("4. Update a movie\n");
        
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 0:
            printf("Exiting database.\n");
            break;
        case 1:
            addMovieExact(database, &movieCount);
            break;
        case 2:
            displayAllMoviesExact(database, movieCount);
            break;
        case 3:
        {
            searchMovieByTitleExact(database, movieCount);
            break;
        }
        case 4:
        {
            updateMovieExact(database, movieCount);
            break;
        }
        default:
            printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 0);

    return 0;
}