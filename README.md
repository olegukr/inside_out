# Inside_out

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Diagrams](#diagrams)
- [Authors](#authors)

## Prerequisites

To run this project, you need to have the following installed:

- [Node.js](https://nodejs.org/) (version 20 or higher)
- [npm](https://www.npmjs.com/) (typically installed with Node.js)
- Other dependencies listed in `package.json`

## Installation

Follow these steps to set up and run the project locally:

1. Clone the repository:
  ```bash
    git clone https://github.com/OlenaMyroshnykova/inside_out.git
  ```
2. Navigate to the project folder:
  ```bash
    cd inside_out
  ```
## Running Tests
To run tests and check code coverage:

Execute the following command:
  ```bash
  npm test
  ```
This command will generate a coverage report (consider adding a screenshot or link to coverage details here if needed).

## Diagrams

Activity diagram
```mermaid
flowchart TD
    A((init)) --> B[Show my diary menu]
    B --> C{Is the number in the range of 1 to 5?}
    C -- 1 --> D[Option 1: Add Moment]
    C -- 2 --> E[Option 2: Show All Moments]
    C -- 3 --> F[Option 3: Delete Moment]
    C -- 4 --> G[Option 4: Filter Moments]
    C -- 5 --> H((Option 5: End))
    C -- No --> B
    D --> I[Add moment]
    I --> J[Enter the title]
    J --> K[Enter the description]
    K --> L[Enter the date dd/mm/yyyy]
    L --> M[Select an emotion: 1. Joy, 2. Sadness, ...]
    M --> N[Save moment]
    N --> O[Moment added successfully]
    O --> B
    E --> P[Show All Moments]
    P --> Q[Press any key for the main menu]
    Q --> B
    F --> R[Show all the moments and enter ID to DELETE]
    R --> S[Moment with ID deleted]
    S --> T[Moment deleted successfully]
    T --> U[Press any key for the main menu]
    U --> B
    G --> V[Show the filter-moment-menu]
    V --> W[Filter by: 1. Emotion, 2. Date]
    W --> X{Is the option in the range of 1 to 2?}
    X -- No --> W
    X -- Yes --> Y[Enter an option]
    Y --> Z[Option 1: Show moments filtered by an emotion]
    Z --> AA[Show emotion list: 1. Joy, 2. Sadness, 3. Anger, 4. Disgust, 5. Fear]
    AA --> AB[Require the client to select one]
    AB --> AC{Are the options correct?}
    AC -- No --> AB
    AC -- Yes --> AD[Show moments filtered by an emotion]
    AD --> AE[Press any key to go to the main menu]
    AE --> B
    Y --> AF[Option 2: Show moments filtered by date]
    AF --> AG[Enter a date to show moments filtered by month and year]
    AG --> AH[Show the moments filtered]
    AH --> AI[Press any key to go to the main menu]
    AI --> B
```
Classes
```mermaid
classDiagram

class Moment {
    - moments: List<Moment>
    - id: int
    - maxId: int
    - modificationDate: LocalDate
    - momentDate: LocalDate
    - description: String
    - emotion: String
    - title: String
    + getId(): int
    + getTitle(): String
    + getEmotion(): String
    + getDescription(): String
    + getMomentDate(): LocalDate
    + getCreationDate(): LocalDate
    + getModificationDate(): LocalDate
    + getMoments(): List<Moment>
    + getMomentById(int): Moment
    + setTitle(String): void
    + setEmotion(String): void
    + setDescription(String): void
    + updateModificationDate(): void
    + deleteMoment(int): void
}

class MomentController {
    + addMomentMenu(): void
    + showMomentsMenu(): void
    + deleteMomentMenu(): void
    + filterByMenu(): void
    + deleteMomentMenu(): void
    + addMoment(...): void
    - getFilterByEmotion(int): List<Moment>
    - getFilterByDate(LocalDate): List<Moment>
    - inputDate(): LocalDate
    - pressEnterToContinue(): void
}

class Emotion {
    - emotions: List<String>
    + getEmotionByIndex(int): String
    + getEmotion(): List<String>
}

class View {
    + showMainMenu(): void
    + showAllEmotions(): void
    + showMoments(List<Moment>): void
    + showFilterMenu(): void
    + showMoment(Moment): void
}

MomentController --> Moment
MomentController --> Emotion
MomentController --> View
```
## Authors
Olena Myroshnykova, Abdias Labrador, Oleg Poberezhets, Kari Tovar
