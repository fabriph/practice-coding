#include "person.h"

#include <iostream>
#include <iterator>
#include <numeric>
#include <sstream>
#include <string>
#include <vector>

void Person::AddCountryVisited(std::string song) {
    countries_visited_.push_back(song);
}

std::string Person::ToString() const {
    // TODO: this is bad.
    std::ostringstream countries_visited;
    for(std::vector<std::string>::const_iterator it = countries_visited_.begin(); it != countries_visited_.end(); ++it) {
        if (it != countries_visited_.begin()) {
            countries_visited << ",";
        }
        countries_visited << *it;
    }
    return "Person {id:" + std::to_string(id_) + " name:" + name_ + " countries_visited:" +
        countries_visited.str() + "}";
}

std::ostream& operator<<(std::ostream& os, const Person& person) {
    os << person.ToString();
    return os;
}
