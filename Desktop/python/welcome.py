
password = input("Enter your password:")


password_length = len(password)

hidden_password = "*" * password_length

print(hidden_password)

number1 = input("Enter a number")

number2 = input("Enter another number")



converted_value1 = float(number1)

converted_value2 = float(number2)

square_root1 = converted_value1 ** 0.5

square_root2 = converted_value2 ** 0.5

print("The addition of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 + converted_value2) + "\n"


"The subtraction of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 - converted_value2) + "\n"
"The multiplication of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 * converted_value2) + "\n"
"The division of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 / converted_value2) + "\n"
"The exponetial of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 ** converted_value2) + "\n"
"The modolus of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 % converted_value2) + "\n"
"The floor of " + str(number1) + " and " + str(number2) + " = " + str(converted_value1 // converted_value2) + "\n"
"The square root of " + str(number1) + " = " + str(square_root1) + "\n"
"The square root of " + str(number2) + " = " + str(square_root2) + "\n")