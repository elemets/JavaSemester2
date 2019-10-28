public class Game
{

// ----------------------------------------------------------------------
// Part a: the score message
  private String scoreMessage;

  public String getScoreMessage()
  {
    return scoreMessage;
  } // getScoreMessage


  public void setScoreMessage(String message)
  {
    scoreMessage = message;
  } // setScoreMessage


  public String getAuthor()
  {
    return "Mr Arthur";
  } // getAuthor


// ----------------------------------------------------------------------
// Part b: constructor and grid accessors

  private final Cell gridArray[][];
  private final int gridSize;

  public Game(int requiredGridSize)
  {
    gridSize = requiredGridSize;

    gridArray = new Cell[gridSize][gridSize];


    for(int index = 0; index < gridSize; index++)
      for(int windex = 0; windex < gridSize; windex++)
      gridArray[index][windex] = new Cell();

  } // Game


  public int getGridSize()
  {
    return gridSize;
  } // getGridSize


  public Cell getGridCell(int x, int y)
  {
      return gridArray[x][y];
  } // getGridCell


// ----------------------------------------------------------------------
// Part c: initial game state
  private int score;
// Part c-1: setInitialGameState method

  public void setInitialGameState(int requiredTailX, int requiredTailY,
                                  int requiredLength, int requiredDirection)
  {
    numberOfTrees = 0;
    for(int i = 0; i < gridSize; i++)
      for(int w = 0; w < gridSize; w++)
      gridArray[i][w].setClear();
    if (treeToggle)
      placeTree();
    setScore(0);
    placeSnake(requiredTailX, requiredTailY, requiredLength, requiredDirection);
    placeFood();

  } // setInitialGameState

  private void setScore (int scoreToSet)
  {
    score = scoreToSet;
  }



// ----------------------------------------------------------------------
// Part c-2 place food

  private int xFoodCoordinate;
  private int yFoodCoordinate;
  private Cell foodCell;


  private void placeFood()
  {
    //Placing food
    do
    {
      //randomising food cell
      xFoodCoordinate = (int)(Math.random() * getGridSize());
      yFoodCoordinate =  (int)(Math.random() * getGridSize());
      foodCell = getGridCell(xFoodCoordinate, yFoodCoordinate);
    } while(foodCell.getType() != Cell.CLEAR);
    foodCell.setFood();
  }

// ----------------------------------------------------------------------
// Part c-3: place snake
 private  int snakeDirection;
 private  int snakeLength;
 private  int snakeXHeadPos;
 private  int snakeYHeadPos;
 private  int snakeXTailPos;
 private  int snakeYTailPos;
 private Cell snakeTailCell;
 private int xSnakeBody;
 private int ySnakeBody;
 private Cell headCell;


private void placeSnake(int tailX, int tailY, int length, int direction)
  {

    //Defining variables

    snakeLength = length;
    snakeDirection = direction;
    snakeXTailPos = tailX;
    snakeYTailPos = tailY;
    snakeTailCell = getGridCell(snakeXTailPos, snakeYTailPos);

    // Placing snake tail
    snakeTailCell.setSnakeTail();
    snakeTailCell.setSnakeOutDirection(snakeDirection);
    snakeTailCell.setSnakeInDirection(Direction.opposite(snakeDirection));

    //Placing snake body
    for(int i = 0; i < snakeLength-2; i++)
    {
      xSnakeBody = snakeXTailPos + (i + 1) * Direction.xDelta(snakeDirection);
      ySnakeBody = snakeYTailPos + (i + 1) * Direction.yDelta(snakeDirection);

      Cell bodyCell = getGridCell(xSnakeBody, ySnakeBody);
      bodyCell.setSnakeBody(Direction.opposite(snakeDirection), snakeDirection);

    }
    snakeXHeadPos = xSnakeBody + Direction.xDelta(snakeDirection);
    snakeYHeadPos = ySnakeBody + Direction.yDelta(snakeDirection);
      // Placing snake head
      headCell = getGridCell(xSnakeBody + Direction.xDelta(snakeDirection),
                                  ySnakeBody +Direction.yDelta(snakeDirection));
      headCell.setSnakeHead(Direction.opposite(snakeDirection), snakeDirection);
  }



// ----------------------------------------------------------------------
// Part d: set snake direction


  public void setSnakeDirection(int requiredDirection)
  {
    if (requiredDirection == headCell.getSnakeInDirection())
    {
      setScoreMessage("Cannibalism not allowed!1!!1");
    }
    else
    {
    headCell.setSnakeOutDirection(requiredDirection);
		snakeDirection = requiredDirection;
    }
  } // setSnakeDirection


// ----------------------------------------------------------------------
// Part e: snake movement
int xCoordinateOfMove;
int yCoordinateOfMove;
// Part e-1: move method
private int isFood;
private int directionOfMove;
private Cell nextHeadCell;


  public void move(int moveValue)
  {

    if(!headCell.isSnakeBloody())
    {
      //compute move
      xCoordinateOfMove = snakeXHeadPos + Direction.xDelta(
                      gridArray[snakeXHeadPos][snakeYHeadPos].getSnakeOutDirection());
      yCoordinateOfMove = snakeYHeadPos + Direction.yDelta(
                      gridArray[snakeXHeadPos][snakeYHeadPos].getSnakeOutDirection());


      // head cell to snake body
      // set the move coordinates to be the headcell
      //check for crashes
      if(checkForCrashes(xCoordinateOfMove, yCoordinateOfMove))
      {

        // remember if there is food in space
        isFood = getGridCell(xCoordinateOfMove, yCoordinateOfMove).getType();
        moveSnakeHead(xCoordinateOfMove, yCoordinateOfMove);  //move snake head
        if(isFood == Cell.FOOD)
          eatFood(moveValue);
        else
        {
        moveSnakeTail();
				if (foodToggle)
        foodmentMovement();
        resetCountDown();
        }
      } // check for crashes
    } //
  } // move


// ----------------------------------------------------------------------
// Part e-2: move the snake head
  private void moveSnakeHead(int xCoordinate, int yCoordinate)
  {
    gridArray[snakeXHeadPos][snakeYHeadPos].setSnakeBody();
    Cell movementCell = getGridCell(xCoordinate, yCoordinate);
    // setiing the snake head to the new cell
    movementCell.setSnakeHead(Direction.opposite(snakeDirection), snakeDirection);


    headCell = getGridCell(xCoordinate, yCoordinate);
    //updating the snake head  variables
    snakeXHeadPos = xCoordinate;
    snakeYHeadPos = yCoordinate;
  }


// ----------------------------------------------------------------------
// Part e-3: move the snake tail

  private void moveSnakeTail()
  {
    // updating the position of the snake tail
    snakeXTailPos = snakeXTailPos +
                                    Direction.xDelta(snakeTailCell.getSnakeOutDirection());
    snakeYTailPos = snakeYTailPos +
                                    Direction.yDelta(snakeTailCell.getSnakeOutDirection());
    // clearing the old tail cell
    snakeTailCell.setClear();
    // updating the tail cell position
    snakeTailCell = getGridCell(snakeXTailPos, snakeYTailPos);
    snakeTailCell.setSnakeTail();
  }


// ----------------------------------------------------------------------
// Part e-4: check for and deal with crashes
Cell crashingCell;

  private boolean checkForCrashes(int xCoordinate, int yCoordinate)
  {
    // defining the crashing cell
    try
    {
      // getting the next cell to cause an exception
      crashingCell = getGridCell(xCoordinate, yCoordinate);

    }
    catch (ArrayIndexOutOfBoundsException ex)
    {
      // setting crashed cell to bloody
      if (reduceCountDown())
      {
      gridArray[snakeXHeadPos][snakeYHeadPos].setSnakeBloody(true);
      return false;
      }
      else
        return false;
    }


    if (crashingCell.isSnakeType())
    {
      // if the reducing count down method says it's finished then kill snake
      if (reduceCountDown())
      {
        // set the crashing cell to bloody
      crashingCell.setSnakeBloody(true);
      gridArray[snakeXHeadPos][snakeYHeadPos].setSnakeBloody(true);
      return false;
      }
      else
        return false;
    }
    else if (crashingCell.getType() == Cell.TREE)
    {
      // if the count down has run out of time then snake dies (make it bloody)
      if (reduceCountDown())
      {
        // making the snake bloody if timer runs out of
      gridArray[snakeXHeadPos][snakeYHeadPos].setSnakeBloody(true);
      setScoreMessage("Don't make Trees rare, treat them with care!");
      return false;
      }
      else
        return false;
    }
    else
    { // resetting the count down timer and returning true as no blocks hit
      resetCountDown();
      return true;
    }
    // return false if crash
  }





// ----------------------------------------------------------------------
// Part e-5: eat the food

  private void eatFood(int moveValue)
  {
    // saving score before for comparison
    int scoreBefore = score;
    snakeLength++;
    if (treeToggle)
    {
      // increasing score depending on
      score += moveValue * ((snakeLength / (gridSize * gridSize  / 36 +1 )) + 1)
                * numberOfTrees;

      setScoreMessage("Raw score increase: " + ((score / numberOfTrees) - scoreBefore) +
                      " Number of trees: " + numberOfTrees +
                      " Actual score increase: " + (score - scoreBefore));
      placeTree();
      numberOfTrees++;

    }
    else {
    // incrementing score
    score += moveValue * ((snakeLength / (gridSize * gridSize  / 36 +1 )) + 1);
    // score message
    setScoreMessage("Score increased by " +  (score - scoreBefore));
    }
    // incrementing snake length

    // placing food
    placeFood();
  }


  public int getScore()
  {
    return score;
  } // getScore


// ----------------------------------------------------------------------
// Part f: cheat


  public void cheat()
  {
    setScoreMessage("ITS ONLY A FLESH WOUND, score halved");
    score = score / 2;
    //Making all bloody cells not bloody
    for(int gridex = 0; gridex < gridSize; gridex++)
      for(int gridey = 0; gridey <gridSize; gridey++)
      {
        // if the cell is bloody unbloody it
      if (gridArray[gridex][gridey].isSnakeBloody())
        gridArray[gridex][gridey].setSnakeBloody(false);
      }
  } // cheat


// ----------------------------------------------------------------------
// Part g: trees

private int numberOfTrees;
private boolean treeToggle;
private Cell randomTree;

  public void toggleTrees()
  {
      // if tree toggle is on
      if(treeToggle)
      {
        numberOfTrees = 0;
        // turn tree toggle off
        treeToggle = false;
          // check all spaces for trees
          for(int treedex = 0; treedex < gridSize; treedex++)
            for(int treedey = 0; treedey < gridSize; treedey++)
            {
              if(gridArray[treedex][treedey].getType() ==  Cell.TREE)
                // setting any tree spaces found to clear
                gridArray[treedex][treedey].setClear();
            }
      }
      else
      {
      // turning the tree toggle on
      treeToggle = true;
      // placing trees
      numberOfTrees++;
      placeTree();
      }
  } // toggleTrees

  private void placeTree()
  {
    do {
      //randomising trees
    int xRandomTreeCoordinate = (int)(Math.random() * getGridSize());
    int yRandomTreeCoordinate =  (int)(Math.random() * getGridSize());
    // random tree using the random x and y coordinates
    randomTree = getGridCell(xRandomTreeCoordinate, yRandomTreeCoordinate);
          // while the random tree isn't clear
    } while (randomTree.getType() != 1);
      // set space to random tree
      randomTree.setTree();

  }


// ----------------------------------------------------------------------
// Part h: crash countdown
private final int countDownStart = 5;
private int currentCountDown;

private void resetCountDown ()
{
  // If the current countdown is less than the start then you got away with it
  if(currentCountDown < countDownStart)
    setScoreMessage("You were lucky to escape! by this many moves: " +
                      currentCountDown);
  // resetting the countdown
  currentCountDown = countDownStart;
}
// method to reduce countdown
private boolean reduceCountDown ()
{
  // reducing the countdown
  currentCountDown--;
  if(currentCountDown > 0)
  {
     setScoreMessage("You only have " + currentCountDown + "moves before death");
     return false;
  }
  else
  {
    resetCountDown();
    return true;
  }
}



// ----------------------------------------------------------------------
// Part i: optional extras

private boolean foodToggle = false;

private void burnTrees()
{
  Cell burnTreeCell = getGridCell(xCoordinateOfMove, yCoordinateOfMove);
  if(burnTreeCell.getType() == Cell.TREE)
  {
    burnTreeCell.setClear();
    numberOfTrees--;
  }
}

private void foodmentMovement()
{
  Cell newFoodCell;
  int directionOfFood = Direction.SOUTH;

  int xNewFoodCoordinate = xFoodCoordinate + Direction.xDelta(directionOfFood);
  int yNewFoodCoordinate = yFoodCoordinate + Direction.yDelta(directionOfFood);



   try {
    newFoodCell = getGridCell(xNewFoodCoordinate, yNewFoodCoordinate);
    }
    catch(ArrayIndexOutOfBoundsException ex3)
    {
      xNewFoodCoordinate = xFoodCoordinate +
                      Direction.xDelta(Direction.leftTurn(directionOfFood));
      yNewFoodCoordinate = yFoodCoordinate +
                      Direction.yDelta(Direction.leftTurn(directionOfFood));


      xFoodCoordinate = xNewFoodCoordinate;
      yFoodCoordinate = yNewFoodCoordinate;
    }


  newFoodCell = getGridCell(xFoodCoordinate, yFoodCoordinate);

  if(xNewFoodCoordinate > gridSize-1 && yNewFoodCoordinate > gridSize-1
    && xNewFoodCoordinate < 0 && yNewFoodCoordinate < 0)
    {
      xNewFoodCoordinate = xFoodCoordinate +
                      Direction.xDelta(Direction.leftTurn(directionOfFood));
      yNewFoodCoordinate = yFoodCoordinate +
                      Direction.yDelta(Direction.leftTurn(directionOfFood));

      directionOfFood = Direction.rightTurn(directionOfFood);
    }
  else if(newFoodCell.getType() == Cell.TREE || newFoodCell.isSnakeType())
  {
    xNewFoodCoordinate = xFoodCoordinate +
                    Direction.xDelta(Direction.leftTurn(directionOfFood));
    yNewFoodCoordinate = yFoodCoordinate +
                    Direction.yDelta(Direction.leftTurn(directionOfFood));

    directionOfFood = Direction.rightTurn(directionOfFood);

  }

  foodCell.setClear();
  newFoodCell.setFood();
  xFoodCoordinate = xNewFoodCoordinate;
  yFoodCoordinate = yNewFoodCoordinate;
  foodCell = getGridCell(xFoodCoordinate, yFoodCoordinate);
  foodCell.setClear();

}



  public String optionalExtras()
  {
    return "  No optional extras defined\n";
  } // optionalExtras


  public void optionalExtraInterface(char c)
  {
    if (c == 'b')
      burnTrees();

    if (c == 'm'){
        if (foodToggle)
          foodToggle = false;
        else
          foodToggle = true;
        }

    if (c > ' ' && c <= '~')
      setScoreMessage("Key " + new Character(c).toString()
                      + " is unrecognised (try h)");
  } // optionalExtraInterface

} // class Game
