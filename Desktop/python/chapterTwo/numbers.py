firstNumber = int(input('Enter a number: '))

secondNumber = int(input('Enter another number: '))

thirdNumber = int(input('Enter another number: '))

sum = firstNumber + secondNumber + thirdNumber

average = sum/3

product = firstNumber * secondNumber * thirdNumber

print(sum)

print(round(average,2))

print(product)

if firstNumber < secondNumber and firstNumber < thirdNumber :
	print('The smallest number is ' + str(firstNumber))

if secondNumber < firstNumber and secondNumber < thirdNumber :
	print('The smallest number is ' + str(secondNumber))

if thirdNumber < firstNumber and thirdNumber < secondNumber :
	print('The smallest number is ' + str(thirdNumber))

if firstNumber > secondNumber and firstNumber > thirdNumber :
	print('The largest number is ' + str(firstNumber))

if secondNumber > firstNumber and secondNumber > thirdNumber :
	print('The largest number is ' + str(secondNumber))

if thirdNumber > firstNumber and thirdNumber > secondNumber :
	print('The largest number is ' + str(thirdNumber))

