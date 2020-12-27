
#include "foo-copyable.h"

#include <iostream>
#include <numeric>
#include <sstream>
#include <iterator>
#include <string>

int FooCopyable::next_available_id = 0;

FooCopyable::FooCopyable(const FooCopyable& other) {
    std::cout << "FooCopyable: Copy Constructor\n";
    name_ = other.name();
    id_ = ++FooCopyable::next_available_id;
    data_ = other.data();
}

// Reference: https://en.cppreference.com/w/cpp/language/copy_assignment
FooCopyable FooCopyable::operator=(const FooCopyable& other) {
    std::cout << "FooCopyable: Copy Assign Operator";
    if (&other == this) {
        return *this;
    }
    name_ = other.name();
    id_ = ++next_available_id;
    data_ = other.data();
    return *this;
}

void FooCopyable::Append(std::string text) {
    data_.push_back(text);
}

std::string FooCopyable::ToString() const {
    // TODO: this is bad.
    std::ostringstream os;
    std::copy(data_.begin(), data_.end(), std::ostream_iterator<std::string>(os, ","));
    return "FooCopyable {name:" + name_ + " id:" + std::to_string(id_) + " " +
        os.str() + "}";
}

std::ostream& operator<<(std::ostream& os, const FooCopyable& fc) {
    os << fc.ToString();
    return os;
}
