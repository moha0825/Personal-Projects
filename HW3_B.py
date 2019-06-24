# Lubna Mohamed Abdirahman, moha0825, Lab Section 011, HW 3, Problem B
def rock_paper_scissors(player1, player2):
    rock = "R"
    paper = "P"
    scissors = "S"
    if player1 == "R" and player2 == "S":
        return("Player1 wins!")
    elif player1 == "S" and player2 == "P":
        return("Player1 wins!")
    elif player1 == "P" and player2 == "R":
        return("Player1 wins!")
    elif player2 == "R" and player1 == "S":
        return("Player2 wins!")
    elif player2 == "S" and player1 == "P":
        return("Player2 wins!")
    elif player2 == "P" and player1 == "R":
        return("Player2 wins!")
    if player1 == "r" and player2 == "s":
        return("Player1 wins!")
    elif player1 == "s" and player2 == "p":
        return("Player1 wins!")
    elif player1 == "p" and player2 == "r":
        return("Player1 wins!")
    elif player2 == "r" and player1 == "s":
        return("Player2 wins!")
    elif player2 == "s" and player1 == "p":
        return("Player2 wins!")
    elif player2 == "p" and player1 == "r":
        return("Player2 wins!")
    else:
        return("It's a tie, nobody wins")


def main():
    point1 = 0 
    point2 = 0
    finalpoints = 0
    games = 0
# Game 1 
    player1 = input("Player1, please enter R, P, or S: ")
    player2 = input("Player2, please enter R, P, or S: ")
    rock_paper_scissors(player1, player2)
    if games <=3:
        games = games + 1
    print("Game", games,":")
    print("Player 1: ", player1)
    print("Player 2: ", player2)
    play = rock_paper_scissors(player1, player2)
    if play == "Player1 wins!":
        point1 = point1 + 1
    elif play == "Player2 wins!":
        point2 = point2 + 1
    elif play == "It's a tie, nobody wins":
        finalpoints = finalpoints + 1
    print(play)
    if point1 >= 2:
        return("Final determination: Player1 has won")
    elif point2 >= 2:
        return("Final determination: Player2 has won")
    print("\n")
    
# Game 2
    player1 = input("Player1, please enter R, P, or S: ")
    player2 = input("Player2, please enter R, P, or S: ")
    rock_paper_scissors(player1, player2)
    if games <=3:
        games = games + 1
    print("Game", games,":")
    print("Player 1: ", player1)
    print("Player 2: ", player2)
    play = rock_paper_scissors(player1, player2)
    if play == "Player1 wins!":
        point1 = point1 + 1
    elif play == "Player2 wins!":
        point2 = point2 + 1
    elif play == "It's a tie, nobody wins":
        finalpoints = finalpoints + 1
    print(play)
    if point1 >= 2:
        return("Final determination: Player1 has won")
    elif point2 >= 2:
        return("Final determination: Player2 has won")
    print("\n")
    
# Game 3
    player1 = input("Player1, please enter R, P, or S: ")
    player2 = input("Player2, please enter R, P, or S: ")
    rock_paper_scissors(player1, player2)  
    if games <=3:
        games = games + 1
    print("Game", games,":")
    print("Player 1: ", player1)
    print("Player 2: ", player2)
    play = rock_paper_scissors(player1, player2)
    if play == "Player1 wins!":
        point1 = point1 + 1
    elif play == "Player2 wins!":
        point2 = point2 + 1
    elif play == "It's a tie, nobody wins":
        finalpoints = finalpoints + 1
    print(play)
    print("\n")
    
# Final Points
    if point1 >= 2:
        print("Final determination: Player1 has won this round.")
    elif point2 >= 2:
        print("Final determination: Player2 has won this round.")
    else:
        print("Final determination: It's a tie! No one won this round.")


if __name__=="__main__":
    main()

        
