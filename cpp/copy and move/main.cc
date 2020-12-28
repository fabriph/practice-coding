
#include <iostream>
#include <numeric>
#include <sstream>
#include <iterator>
#include <string>

#include "foo-copyable.h"
#include "foo-copyable-and-movable.h"
#include "foo-movable.h"

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
    FooCopyable f_c2(f_c1);  // Copy constructor

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

void playground_copy_and_move_1() {
    std::cout << "\nplayground copy and move 1\n";
    FooCopyableAndMovable copyable_and_movable_a("A");
    copyable_and_movable_a.Append("1");
    copyable_and_movable_a.Append("2");
    FooCopyableAndMovable copyable_and_movable_b("B");
    copyable_and_movable_b.Append("3");
    copyable_and_movable_b.Append("4");
    copyable_and_movable_b.Append("5");

    std::cout << "A: " << copyable_and_movable_a << "\n";
    std::cout << "B: " << copyable_and_movable_b << "\n";
}

void playground_copy_and_move_2() {
    std::cout << "\nplayground copy and move 2\n";
    FooCopyableAndMovable copyable_and_movable_a("A");
    copyable_and_movable_a.Append("1");
    copyable_and_movable_a.Append("2");
    FooCopyableAndMovable copyable_and_movable_b(copyable_and_movable_a);  // Copy constructor

    std::cout << "A: " << copyable_and_movable_a << "\n";
    std::cout << "B: " << copyable_and_movable_b << "\n";
}

void playground_copy_and_move_3() {
    std::cout << "\nplayground copy and move 3\n";
    FooCopyableAndMovable copyable_and_movable_a("A");
    copyable_and_movable_a.Append("1");
    copyable_and_movable_a.Append("2");
    FooCopyableAndMovable copyable_and_movable_b = copyable_and_movable_a;  // Copy constructor.
    copyable_and_movable_b.Append("3");
    copyable_and_movable_b.Append("4");
    copyable_and_movable_b.Append("5");

    FooCopyableAndMovable copyable_and_movable_c("C");
    copyable_and_movable_c.Append("6");
    copyable_and_movable_c = copyable_and_movable_a;  // Copy assign.
    copyable_and_movable_c.Append("7");

    std::cout << "A: " << copyable_and_movable_a << "\n";  // prints 1,2
    std::cout << "B: " << copyable_and_movable_b << "\n";  // prints 1..5
    std::cout << "C: " << copyable_and_movable_c << "\n";  // prints 1,2,7
}

void playground_copy_and_move_4() {
    std::cout << "\nplayground copy and move 4\n";
    FooCopyableAndMovable copyable_and_movable_a("A");
    copyable_and_movable_a.Append("1");
    copyable_and_movable_a.Append("2");
    FooCopyableAndMovable copyable_and_movable_b = std::move(copyable_and_movable_a);  // Move constructor
    copyable_and_movable_b.Append("3");
    copyable_and_movable_b.Append("4");
    copyable_and_movable_b.Append("5");
    std::cout << "A: " << copyable_and_movable_a << "\n";  // prints {name: id:-1 1,2,}
    std::cout << "B: " << copyable_and_movable_b << "\n\n";  // prints {name:A id:0 1,2,3,4,5,}

    FooCopyableAndMovable copyable_and_movable_c("C");
    FooCopyableAndMovable copyable_and_movable_d("D");
    copyable_and_movable_c.Append("6");
    copyable_and_movable_d.Append("7");
    copyable_and_movable_d = std::move(copyable_and_movable_c);  // Move assign operator
    copyable_and_movable_c.Append("8");
    copyable_and_movable_d.Append("9");
    std::cout << "C: " << copyable_and_movable_c << "\n";  // prints {name: id:-1 6,8,}
    std::cout << "D: " << copyable_and_movable_d << "\n\n";  // prints {name:C id:0 6,9,}

    FooCopyableAndMovable copyable_and_movable_e("E");
    copyable_and_movable_e.Append("10");
    FooCopyableAndMovable copyable_and_movable_f(std::move(copyable_and_movable_e));  // Move constructor
    copyable_and_movable_e.Append("11");
    copyable_and_movable_f.Append("12");
    std::cout << "E: " << copyable_and_movable_e << "\n";  // prints {name: id:-1 10,11,}
    std::cout << "F: " << copyable_and_movable_f << "\n\n";  // prints {name:E id:0 10,12,}
}

FooCopyableAndMovable get_new_foo() {
    FooCopyableAndMovable foo("a");
    foo.Append("1");

    std::cout << "foo built: " << foo.ToString() << std::endl;
    return foo;
}

/* named return value optimization (NRVO)
 * prints:

foo_check_nrvo()
** assigning **
foo built: FooCopyableAndMovable {name:a id:1 data:1,}
** assigned **
** moving **
foo built: FooCopyableAndMovable {name:a id:3 data:1,}
FooCopyableAndMovable: Move Assign Operator fromFooCopyableAndMovable {name:a id:3 data:1,}
** moved **
next available id: 3
*/
void foo_check_nrvo() {
    std::cout << "\nfoo_check_nrvo()\n";

    std::cout << "** assigning **\n";
    FooCopyableAndMovable assigned = get_new_foo();
    std::cout << "** assigned **\n";

    FooCopyableAndMovable moved("temp");
    moved.Append("to be dropped");

    std::cout << "** moving **\n";
    moved = get_new_foo();
    std::cout << "** moved **\n";
    std::cout << "next available id: " << FooCopyableAndMovable::next_available_id() << "\n";
}

std::vector<FooCopyableAndMovable> get_new_vector() {
    std::cout << "  get_new_vector()\n";
    std::vector<FooCopyableAndMovable> vector;
    std::cout << "    1\n";
    vector.push_back(FooCopyableAndMovable("a"));
    std::cout << "    2\n";
    vector.push_back(FooCopyableAndMovable("b"));
    std::cout << "    3\n";

    std::ostringstream os;
    for(std::vector<FooCopyableAndMovable>::iterator it = vector.begin(); it != vector.end(); ++it) {
        os << it->ToString() << ", ";
    }
    std::cout << "    vector built: " << os.str() << std::endl;
    return vector;
}

/* named return value optimization (NRVO)
 * prints:

vector_check_nrvo()
** assigning **
  get_new_vector()
    1
FooCopyableAndMovable: Move Constructor from FooCopyableAndMovable {name:a id:4 data:}
    2
FooCopyableAndMovable: Move Constructor from FooCopyableAndMovable {name:b id:5 data:}
FooCopyableAndMovable: Copy Constructor of FooCopyableAndMovable {name:a id:4 data:}
    3
    vector built: FooCopyableAndMovable {name:a id:6 data:}, FooCopyableAndMovable {name:b id:5 data:}, 
** assigned **
FooCopyableAndMovable: Move Constructor from FooCopyableAndMovable {name:to_be_dropped id:7 data:}
** moving **
  get_new_vector()
    1
FooCopyableAndMovable: Move Constructor from FooCopyableAndMovable {name:a id:8 data:}
    2
FooCopyableAndMovable: Move Constructor from FooCopyableAndMovable {name:b id:9 data:}
FooCopyableAndMovable: Copy Constructor of FooCopyableAndMovable {name:a id:8 data:}
    3
    vector built: FooCopyableAndMovable {name:a id:10 data:}, FooCopyableAndMovable {name:b id:9 data:}, 
** moved **
next available id: 10
*/
void vector_check_nrvo() {
    std::cout << "\nvector_check_nrvo()\n";

    std::cout << "** assigning **\n";
    std::vector<FooCopyableAndMovable> assigned = get_new_vector();
    std::cout << "** assigned **\n";

    std::vector<FooCopyableAndMovable> moved;
    moved.push_back(FooCopyableAndMovable("to_be_dropped"));

    std::cout << "** moving **\n";
    moved = get_new_vector();
    std::cout << "** moved **\n";
    std::cout << "next available id: " << FooCopyableAndMovable::next_available_id() << "\n";
}

int main() {
    std::cout << "main()\n";

    //playground_copy_1();
    //playground_copy_2();
    //playground_copy_3();

    //playground_move_1();

    // playground_copy_and_move_1();
    // playground_copy_and_move_2();
    // playground_copy_and_move_3();
    // playground_copy_and_move_4();
    
    foo_check_nrvo();
    vector_check_nrvo();

    std::cout << "main() END\n";
    return 0;
}
