//#374 additive persistence https://www.reddit.com/r/dailyprogrammer/comments/akv6z4/20190128_challenge_374_easy_additive_persistence/
#include <iostream>

int addAllNumbers(int numbersToAdd, int numberTimesSoFar);

int main() {

    int input = 199;

    int result = addAllNumbers(input, 0);

    std::cout << result << std::endl;
    return 0;
}

int addAllNumbers(int numbersToAdd, int numberTimesSoFar) {
    int finalNumber = 0;

    std::string inputAsString = std::to_string(numbersToAdd);

    for (char i : inputAsString) {
        int charAsNumber = i - 48;
        finalNumber += charAsNumber;
    }

    if (finalNumber > 9){
        return addAllNumbers(finalNumber, numberTimesSoFar+1);
    }

    return numberTimesSoFar +1;
}