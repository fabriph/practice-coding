#ifndef COPY_AND_MOVE__FOO_COPYABLE
#define COPY_AND_MOVE__FOO_COPYABLE

#include<string>

class FooMovable {
    public:
        FooMovable(const std::string name) : name_(name), id_(0) {}
        // Not copyable
        FooMovable(const FooMovable& other) = delete;
        FooMovable operator=(const FooMovable& other) = delete;
        // Movable
        FooMovable(FooMovable&&) = delete;
        FooMovable& operator=(FooMovable&&) = delete;

        std::string name() const {return name_;};

        // No need to be const, but doing it because of an odd warninig.
        int id() const {return id_;};

        std::string ToString() const;

    private:
        std::string name_;
        int id_;
};

#endif
