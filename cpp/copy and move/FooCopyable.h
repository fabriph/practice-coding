#ifndef COPY_AND_MOVE__FOO_COPYABLE
#define COPY_AND_MOVE__FOO_COPYABLE

#include <iostream>
#include<string>

class FooCopyable {
    public:
        FooCopyable(const std::string name) : name_(name), id_(++next_available_id) {}
        // Copyable
        FooCopyable(const FooCopyable& other);
        FooCopyable operator=(const FooCopyable& other);
        // Not movable
        FooCopyable(FooCopyable&&) = delete;
        FooCopyable& operator=(FooCopyable&&) = delete;

        std::string name() const {return name_;};

        // No need to be const, but doing it because of an IDE odd warninig.
        int id() const {return id_;};

        std::string ToString() const;
        friend std::ostream& operator<<(std::ostream& os, const FooCopyable& fc);

    private:
        static int next_available_id;

        std::string name_;
        int id_;
};

#endif
