
#include "foo-copyable-and-movable.h"

#include <iostream>
#include <numeric>
#include <sstream>
#include <iterator>
#include <string>

int FooCopyableAndMovable::next_available_id = 0;

FooCopyableAndMovable::FooCopyableAndMovable(const FooCopyableAndMovable& other) {
    std::cout << "FooCopyableAndMovable: Copy Constructor\n";
    name_ = other.name();
    id_ = ++FooCopyableAndMovable::next_available_id;
    data_ = other.data();
}

// Reference: https://en.cppreference.com/w/cpp/language/copy_assignment
FooCopyableAndMovable FooCopyableAndMovable::operator=(const FooCopyableAndMovable& other) {
    std::cout << "FooCopyableAndMovable: Copy Assign Operator";
    if (&other == this) {
        return *this;
    }
    name_ = other.name();
    id_ = ++next_available_id;
    data_ = other.data();
    return *this;
}

FooCopyableAndMovable::FooCopyableAndMovable(FooCopyableAndMovable&& other) {
    std::cout << "FooCopyableAndMovable: Move Constructor\n";
    name_ = other.name();
    id_ = other.id();
    data_ = std::move(other.data());

    other.name("");
    other.id(-1);
}

// Reference: https://en.cppreference.com/w/cpp/language/move_assignment
FooCopyableAndMovable& FooCopyableAndMovable::operator=(FooCopyableAndMovable&& other) {
    std::cout << "FooCopyableAndMovable: Move Assign Operator\n";

    name_ = std::move(other.name());
    other.name("");
    id_ = other.id();
    other.id(-1);
    data_ = std::move(other.data());
    return *this;
}

void FooCopyableAndMovable::Append(std::string text) {
    data_.push_back(text);
}

std::string FooCopyableAndMovable::ToString() const {
    // TODO: this is bad.
    std::ostringstream os;
    std::copy(data_.begin(), data_.end(), std::ostream_iterator<std::string>(os, ","));
    return "FooCopyableAndMovable {name:" + name_ + " id:" + std::to_string(id_) + " " +
        os.str() + "}";
}

std::ostream& operator<<(std::ostream& os, const FooCopyableAndMovable& fc) {
    os << fc.ToString();
    return os;
}
