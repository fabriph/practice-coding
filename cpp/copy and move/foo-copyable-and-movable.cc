
#include "foo-copyable-and-movable.h"

#include <iostream>
#include <iterator>
#include <numeric>
#include <sstream>
#include <string>

int FooCopyableAndMovable::next_available_id_ = 0;

FooCopyableAndMovable::FooCopyableAndMovable(const FooCopyableAndMovable& other) {
    std::cout << "FooCopyableAndMovable: Copy Constructor of " << other.ToString() << std::endl;
    name_ = other.name();
    id_ = ++FooCopyableAndMovable::next_available_id_;
    data_ = other.data();
}

// Reference: https://en.cppreference.com/w/cpp/language/copy_assignment
FooCopyableAndMovable FooCopyableAndMovable::operator=(const FooCopyableAndMovable& other) {
    std::cout << "FooCopyableAndMovable: Copy Assign Operator of " << other.ToString() << std::endl;
    if (&other == this) {
        return *this;
    }
    name_ = other.name();
    id_ = ++next_available_id_;
    data_ = other.data();
    return *this;
}

FooCopyableAndMovable::FooCopyableAndMovable(FooCopyableAndMovable&& other) {
    std::cout << "FooCopyableAndMovable: Move Constructor from " << other.ToString() << std::endl;
    name_ = other.name();
    id_ = other.id();
    data_ = std::move(other.data());

    other.name("");
    other.id(-1);
}

// Reference: https://en.cppreference.com/w/cpp/language/move_assignment
FooCopyableAndMovable& FooCopyableAndMovable::operator=(FooCopyableAndMovable&& other) {
    std::cout << "FooCopyableAndMovable: Move Assign Operator from" << other.ToString() << std::endl;

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
    for(std::vector<std::string>::const_iterator it = data_.begin(); it != data_.end(); ++it) {
        if (it != data_.begin()) {
            os << ",";
        }
        os << *it;
    }
    return "FooCopyableAndMovable {name:" + name_ + " id:" + std::to_string(id_) + " data:" +
        os.str() + "}";
}

std::ostream& operator<<(std::ostream& os, const FooCopyableAndMovable& fc) {
    os << fc.ToString();
    return os;
}
