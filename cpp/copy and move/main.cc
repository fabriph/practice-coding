
#include <iostream>

#include "FooCopyable.h"

int main() {
    std::cout << "main()\n";

    FooCopyable f_c1("A");
    FooCopyable f_c2("B");

    std::cout << "A: " << f_c1 << "\n";
    std::cout << "B: " << f_c2 << "\n";

    std::cout << "main() END\n";
    return 0;
}
