
#include "FooCopyable.h"

#include <iostream>
#include <string>

int FooCopyable::next_available_id = 0;

FooCopyable::FooCopyable(const FooCopyable& other) {
    std::cout << "FooCopyable: Copy Constructor";
    name_ = other.name();
    id_ = FooCopyable::next_available_id++;
}

// FooCopyable FooCopyable::operator=(const FooCopyable& other) {
//     std::cout << "FooCopyable: Copy Assign Operator";
//     if (&other == this) {
//         return *this;
//     }
//     name_ = other.name();
//     id_ = ++next_available_id;
// }

std::string FooCopyable::ToString() const {
    // TODO: this si bad.
    return "FooCopyable {name:" + name_ + " id:" + std::to_string(id_) + "}";
}

std::ostream& operator<<(std::ostream& os, const FooCopyable& fc) {
    os << fc.ToString();
    return os;
}
