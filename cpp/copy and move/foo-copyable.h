#ifndef COPY_AND_MOVE__FOO_COPYABLE
#define COPY_AND_MOVE__FOO_COPYABLE

#include <iostream>
#include <string>
#include <vector>

class FooCopyable {
    public:
        FooCopyable(const std::string name) : name_(name), id_(++next_available_id), data_() {}
        // Copyable
        FooCopyable(const FooCopyable& other);
        FooCopyable operator=(const FooCopyable& other);
        // Not movable
        FooCopyable(FooCopyable&&) = delete;
        FooCopyable& operator=(FooCopyable&&) = delete;

        std::string name() const {return name_;};
        void name(std::string name) {name_ = name;};

        // No need to be const, but doing it because of an IDE odd warninig.
        int id() const {return id_;};
        void id(int id) {id_ = id;};

        std::vector<std::string> data() const {return data_;};
        void Append(std::string text);

        std::string ToString() const;
        friend std::ostream& operator<<(std::ostream& os, const FooCopyable& fc);

    private:
        static int next_available_id;

        std::string name_;
        int id_;
        // TODO: maybe make this a unique_ptr to better play with the semantics of copy / move.
        std::vector<std::string> data_;
};

#endif
