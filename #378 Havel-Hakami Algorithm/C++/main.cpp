#include <iostream>
#include <iterator>
#include <vector>
#include <algorithm>

std::vector<int> removeZeros(std::vector<int> &array);

std::vector<int> frontElimination(std::vector<int> &array, int amount);

bool hh(std::vector<int> array);

int main() {
    std::vector<int> array = {16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16};

    bool result = hh(array);
    std::cout << std::boolalpha;
    std::cout << result << std::endl;
    return 0;
}

std::vector<int> removeZeros(std::vector<int> &array) {
    for (int i = 0; i < array.size(); i++) {
        if (array[i] == 0) {
            array.erase(array.begin() + i);
        }
    }

    return array;
}

std::vector<int> frontElimination(std::vector<int> &array, int amount) {

    for (int i = 0; i < amount; i++) {
        array.at(i) = array[i] - 1;
    }

    return array;
}

bool hh(std::vector<int> array) {
    removeZeros(array);
    if (array.empty()) {
        return true;
    }

    std::sort(array.begin(), array.end(), std::greater<>());
    int n = array.at(0);
    array.erase(array.begin());

    if (n > array.size()) {
        return false;
    }

    frontElimination(array, n);

    return hh(array);
}
