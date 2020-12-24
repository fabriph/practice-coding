
#include <iostream>

#include "FooCopyable.h"
#include "FooMovable.h"

void playground_copy_1() {
    std::cout << "\nplayground copy 1\n";
    FooCopyable f_c1("A");
    f_c1.Append("1");
    f_c1.Append("2");
    FooCopyable f_c2("B");
    f_c2.Append("3");
    f_c2.Append("4");
    f_c2.Append("5");

    std::cout << "A: " << f_c1 << "\n";
    std::cout << "B: " << f_c2 << "\n";
}

void playground_copy_2() {
    std::cout << "\nplayground copy 2\n";
    FooCopyable f_c1("A");
    f_c1.Append("1");
    f_c1.Append("2");
    FooCopyable f_c2(f_c1);

    std::cout << "A: " << f_c1 << "\n";
    std::cout << "B: " << f_c2 << "\n";
}

void playground_copy_3() {
    std::cout << "\nplayground copy 3\n";
    FooCopyable f_c1("A");
    f_c1.Append("1");
    f_c1.Append("2");
    FooCopyable f_c2 = f_c1;  // Copy constructor.
    f_c2.Append("3");
    f_c2.Append("4");
    f_c2.Append("5");

    FooCopyable f_c3("C");
    f_c3.Append("6");
    f_c3 = f_c1;  // Copy assign.
    f_c3.Append("7");

    std::cout << "A: " << f_c1 << "\n";  // prints 1,2
    std::cout << "B: " << f_c2 << "\n";  // prints 1..5
    std::cout << "C: " << f_c3 << "\n";  // prints 1,2,7
}

void playground_move_1() {
    std::cout << "\nplayground move 1\n";
    FooMovable movable_a("A");
    movable_a.Append("1");
    movable_a.Append("2");
    FooMovable movable_b = std::move(movable_a);  // Move constructor
    movable_b.Append("3");
    movable_b.Append("4");
    movable_b.Append("5");
    std::cout << "A: " << movable_a << "\n";  // prints {name: id:-1 1,2,}
    std::cout << "B: " << movable_b << "\n\n";  // prints {name:A id:0 1,2,3,4,5,}

    FooMovable movable_c("C");
    FooMovable movable_d("D");
    movable_c.Append("6");
    movable_d.Append("7");
    movable_d = std::move(movable_c);  // Move assign operator
    movable_c.Append("8");
    movable_d.Append("9");
    std::cout << "C: " << movable_c << "\n";  // prints {name: id:-1 6,8,}
    std::cout << "D: " << movable_d << "\n\n";  // prints {name:C id:0 6,9,}

    FooMovable movable_e("E");
    movable_e.Append("10");
    FooMovable movable_f(std::move(movable_e));  // Move constructor
    movable_e.Append("11");
    movable_f.Append("12");
    std::cout << "E: " << movable_e << "\n";  // prints {name: id:-1 10,11,}
    std::cout << "F: " << movable_f << "\n\n";  // prints {name:E id:0 10,12,}
}

int main() {
    std::cout << "main()\n";

    //playground_copy_1();
    //playground_copy_2();
    //playground_copy_3();

    playground_move_1();
    

    std::cout << "main() END\n";
    return 0;
}
