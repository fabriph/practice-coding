
#include "FooMovable.h"

#include <iostream>
#include <numeric>
#include <sstream>
#include <iterator>
#include <string>

int FooMovable::next_available_id = 0;

FooMovable::FooMovable(FooMovable&& other) {
    std::cout << "FooMovable: Move Constructor\n";
    name_ = other.name();
    id_ = other.id();
    data_ = std::move(other.data());

    other.name("");
    other.id(-1);
}

// Reference: https://en.cppreference.com/w/cpp/language/move_assignment
FooMovable& FooMovable::operator=(FooMovable&& other) {
    std::cout << "FooMovable: Move Assign Operator\n";

    name_ = std::move(other.name());
    other.name("");
    id_ = other.id();
    other.id(-1);
    data_ = std::move(other.data());
    return *this;
}

void FooMovable::Append(std::string text) {
    data_.push_back(text);
}

std::string FooMovable::ToString() const {
    // TODO: this is bad.
    std::ostringstream os;
    std::copy(data_.begin(), data_.end(), std::ostream_iterator<std::string>(os, ","));
    return "FooMovable {name:" + name_ + " id:" + std::to_string(id_) + " " +
        os.str() + "}";
}

std::ostream& operator<<(std::ostream& os, const FooMovable& fm) {
    os << fm.ToString();
    return os;
}
