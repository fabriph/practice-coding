def printRecursiveApproach1(partial, pendingToOpen, alreadyOpened, missingToClose):
	if alreadyOpened == pendingToOpen and missingToClose == 0:
		print partial
		return
	else:
		if 0 < missingToClose:
			printRecursiveApproach1(partial + ")", pendingToOpen, alreadyOpened, missingToClose - 1)
		if alreadyOpened < pendingToOpen:
			printRecursiveApproach1(partial + "(", pendingToOpen, alreadyOpened + 1, missingToClose + 1)

def printRecursiveApproach2(partial, pendingToOpen, missingToClose):
	if 0 == pendingToOpen and missingToClose == 0:
		print partial
		return
	else:
		if 0 < missingToClose:
			printRecursiveApproach2(partial + ")", pendingToOpen, missingToClose - 1)
		if 0 < pendingToOpen:
			printRecursiveApproach2(partial + "(", pendingToOpen - 1, missingToClose + 1)

printRecursiveApproach1("", 3, 0, 0)
print
printRecursiveApproach2("", 3, 0)