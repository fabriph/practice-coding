#include <fstream>
#include <iostream>
#include <vector>

unsigned int calc_value(std::string text){
    unsigned int result = 0;
    for (char& c : text) {
        result += c - 64;
    }
    return result;
}

int main(int argc, const char * argv[])
{
    std::string file = "Problem22/names.txt";
    std::ifstream xInFile(file);
    if(!xInFile){
        return 1;
    }
    
    std::string line;
    bool reading = false;
   
    std::vector<std::string> data = std::vector<std::string>();
    
    while(std::getline(xInFile, line)) {
        int i =0;
        while (i < line.length()) {
            if (reading) {
                reading = false;
                int start = i;
                while ('\"' != line[i] && i < line.length()) {
                    ++i;
                }
                std::string name = line.substr(start,i-start);
                data.insert(data.end(), name);
            }else {
                if ('\"' == line[i]) {
                    reading = true;
                }
            }
            ++i;
        }
    }
    
    std::sort(data.begin(), data.end());
    
    unsigned int sum = 0;
    for( int i =0; i < data.size(); ++i){
        sum += (i+1) * calc_value(data[i]);
    }
    std::cout << sum << std::endl;
    return 0;
}