                       ###### FOR ALL DIRECTIONS

                    For those who have already sent #1 and #2
In the language with static typization (to choose Java or C #), to implement a script 
(in the form of a jar file or assembly) that implements a summarized game stone-paper 
(any number of random combinations). When running the command line (main or Main) arguments pass 
an odd number of >=3 unique lines (with incorrect arguments, remove a neat error message - 
which is wrong, example is correct). These lines are moves 
(e.g. Stone Scissors Paper or Stone Scissor Paper Lizard Spock or 1 2 3
Victory is defined like this: half of the next in circles wins, half of the previous ones 
lose in circles (semantics of lines do not matter what sequence the user entered, that's what he plays).
The script generates a random key (SecureRandom or RandomNumberGenerator - a must! ) 128 bit long, 
makes its move (again safe randoms), calculates HMAC (SHA2 or SHA3) from progress with a generated key, 
shows HMAC user. After that, the user receives ′′ menu ′′ 1-Stone, 2-Scissors,...., 0-Exit,? - Help. 
The user makes his choice (with incorrect input again shows the ′′ menu ′′). The script shows who won,
the computer progress and the original key.
This way, the user can check that the computer plays honestly (has not changed its course after the user).
When choosing an option "?" (Help) in the terminal you need to display a table that determines which move wins.
Table generating should be delivered to a separate class and must use the third-party library to generate ASCII tables,
defining ′′ rules ′′ who won should be in a separate class, key generating functions and HMAC should be in a single
class (4th grade only). To the most extent, basic class libraries and third-party libraries 
should be used, not to invent a bike.
THE NUMBER OF HOODS CAN BE ANY (odd > 1, depends on the given parameters), not sewn in the code.
Example:
>java -jar game.jar rock paper scissors lizard Spock
HMAC: FAAC40C end1B4B12BF0EF5556EB feeC06925D5AE405D4444E006BB7A06565337D411
Available moves:
1 - rock
2 - paper
3 - scissors
4 - lizard
5 - Spock
0 - exit
? - help
Enter your move: 2
Your move: paper
Computer move: rock
You win!
HMAC key: BD9B554444439FCE thank359C26health34E370A2

And as an explanation: when calculating HMAC, the key is the secret key you generated. And the message is a move
(right here is a line of progress). After the user's move, he will have a key, the computer, the user will be able to
calculate HMAC and compare with the HMAC that was shown before the user's progress. It's not very difficult :))
A common mistake is an attempt to invent your ′′ HMAC ′′ as a hash from a random ′′ key ". It won't work like that.
If you show the same lines before and after the move, the user receives no new information after
the move and accordingly, you prove nothing to him. You need to generate a key (safe generator), 
make a computer move, calculate HMAC (standard algorithm) from the company (message) and key (key), show HMAC, 
get the user's move, show the key. Reread this paragraph until full smoking.
Conditionally the ′′ correct ′′ order of the parameters, where the game goes according to the classic rules 
(although the user can use a different order and play a game where the scissors defeat the stone; 
or play the game HOD1 HOD2 HOD3): STONE PAPER OF THE SCISSOR or, for 5 , STONE SPOKE PAPER LISCHOR SCISSOR.