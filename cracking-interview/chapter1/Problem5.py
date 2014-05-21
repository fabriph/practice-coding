def main(input):
	current = 0
	runner = 1
	output = ""
	while runner < len(input):
		if input[current] != input[runner]:
			output += input[current] + str(runner - current)
			current = runner
		runner += 1
	output += input[current] + str(runner - current)
	return output if len(input) > len(output) else input

print main("aaabbccccc")
print main("abc")