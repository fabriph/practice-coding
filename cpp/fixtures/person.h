#ifndef FIXTURES__PERSON
#define FIXTURES__PERSON

#include <string>
#include <vector>

class Person {
    public:
        Person(std::string name) : id_(++next_available_id_), name_(name) {}

        int id() {return id_;};
        void id(int id) {id_ = id;};

        std::string name() const {return name_;};

        void AddCountryVisited(std::string song);
        std::vector<std::string> CountriesVisited() {return countries_visited_;};
        
        std::string ToString() const;
        friend std::ostream& operator<<(std::ostream& os, const Person& person);

    private:
        static int next_available_id_;

        int id_;
        std::string name_;
        std::vector<std::string> countries_visited_;
};

#endif
