"""
if problems appear, remember that 'and' and 'or' are short circuit, meanwhile
& and | are not.
"""
def processOperand(text, firstTerm):
	if not text:
		return firstTerm
	elif text[0] == "|":
		return firstTerm or processTerm(text[1:])
	elif text[0] == "&":
		return firstTerm and processTerm(text[1:])
	else:
		return firstTerm

def processTerm(text):
	if text[0] == "(":
		open = 0
		i = 1
		while True:
			if open == 0 and text[i] == ")":
				break
			elif text[i] == "(":
				open += 1
			elif text[i] == ")":
				open -= 1
			i += 1
		value = processTerm(text[1:i])
		return processOperand(text[i + 1:], value)
	elif text[0] == "0":
		return processOperand(text[1:], False)
	elif text[0] == "1":
		return processOperand(text[1:], True)
	else:
		print "Wrong formulation"
		return

def main(input, expected):
	result = processTerm(input)
	if result != expected:
		print "Fails on:", input
	else:
		print "Ok"

main("0|0", False)
main("0|1", True)
main("1|0", True)
main("1|1", True)
main("0&0", False)
main("0&1", False)
main("1&0", False)
main("1&1", True)
main("(0|0)&0", False)
main("(0|0)&1", False)
main("(1|0)&0", False)
main("(1|0)&1", True)
main("1&(1|0)", True)
main("1&(0|0)", False)
main("0&(1|0)", False)
main("(1)&(1|0)", True)
main("(1|0)&(1&0)", False)
main("(0|(1|0))&(1&((1|0)&0))", False)
